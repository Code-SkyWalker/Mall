package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsSkuFullReductionMapper;
import com.skywalker.sms.pojo.SmsMemberPrice;
import com.skywalker.sms.pojo.SmsSkuFullReduction;
import com.skywalker.sms.pojo.SmsSkuLadder;
import com.skywalker.sms.service.SmsMemberPriceService;
import com.skywalker.sms.service.SmsSkuFullReductionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.sms.service.SmsSkuLadderService;
import com.skywalker.to.SkuCouponTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSkuFullReductionServiceImpl
 * @Description TODO
 */
@Service
public class SmsSkuFullReductionServiceImpl implements SmsSkuFullReductionService {

    @Autowired
    private SmsSkuFullReductionMapper smsSkuFullReductionMapper;

    @Autowired
    private SmsSkuLadderService smsSkuLadderService;

    @Autowired
    private SmsMemberPriceService smsMemberPriceService;


    /**
     * SmsSkuFullReduction条件+分页查询
     * @param smsSkuFullReduction 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsSkuFullReduction> findPage(SmsSkuFullReduction smsSkuFullReduction, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsSkuFullReduction);
        //执行搜索
        return new PageInfo<SmsSkuFullReduction>(smsSkuFullReductionMapper.selectByExample(example));
    }

    /**
     * SmsSkuFullReduction分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsSkuFullReduction> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsSkuFullReduction>(smsSkuFullReductionMapper.selectAll());
    }

    /**
     * SmsSkuFullReduction条件查询
     * @param smsSkuFullReduction
     * @return
     */
    @Override
    public List<SmsSkuFullReduction> findList(SmsSkuFullReduction smsSkuFullReduction){
        //构建查询条件
        Example example = createExample(smsSkuFullReduction);
        //根据构建的条件查询数据
        return smsSkuFullReductionMapper.selectByExample(example);
    }


    /**
     * SmsSkuFullReduction构建查询对象
     * @param smsSkuFullReduction
     * @return
     */
    public Example createExample(SmsSkuFullReduction smsSkuFullReduction){
        Example example=new Example(SmsSkuFullReduction.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsSkuFullReduction!=null){
            // id
            if(!StringUtils.isEmpty(smsSkuFullReduction.getId())){
                    criteria.andEqualTo("id",smsSkuFullReduction.getId());
            }
            // spu_id
            if(!StringUtils.isEmpty(smsSkuFullReduction.getSkuId())){
                    criteria.andEqualTo("skuId",smsSkuFullReduction.getSkuId());
            }
            // 满多少
            if(!StringUtils.isEmpty(smsSkuFullReduction.getFullPrice())){
                    criteria.andEqualTo("fullPrice",smsSkuFullReduction.getFullPrice());
            }
            // 减多少
            if(!StringUtils.isEmpty(smsSkuFullReduction.getReducePrice())){
                    criteria.andEqualTo("reducePrice",smsSkuFullReduction.getReducePrice());
            }
            // 是否参与其他优惠
            if(!StringUtils.isEmpty(smsSkuFullReduction.getAddOther())){
                    criteria.andEqualTo("addOther",smsSkuFullReduction.getAddOther());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        smsSkuFullReductionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsSkuFullReduction
     * @param smsSkuFullReduction
     */
    @Override
    public void update(SmsSkuFullReduction smsSkuFullReduction){
        smsSkuFullReductionMapper.updateByPrimaryKey(smsSkuFullReduction);
    }

    /**
     * 增加SmsSkuFullReduction
     * @param smsSkuFullReduction
     */
    @Override
    public void add(SmsSkuFullReduction smsSkuFullReduction){
        smsSkuFullReductionMapper.insert(smsSkuFullReduction);
    }

    /**
     * 根据ID查询SmsSkuFullReduction
     * @param id
     * @return
     */
    @Override
    public SmsSkuFullReduction findById(Long id){
        return  smsSkuFullReductionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsSkuFullReduction全部数据
     * @return
     */
    @Override
    public List<SmsSkuFullReduction> findAll() {
        return smsSkuFullReductionMapper.selectAll();
    }

    /**
     * 添加商品时, sku对应的优惠满减信息
     *
     * @param skuCouponTo
     */
    @Transactional
    @Override
    public void addSkuCouponInfo(SkuCouponTo skuCouponTo) {
        SmsSkuFullReduction smsSkuFullReduction = new SmsSkuFullReduction();
        BeanUtils.copyProperties(skuCouponTo, smsSkuFullReduction);
        this.add(smsSkuFullReduction);

        SmsSkuLadder smsSkuLadder = new SmsSkuLadder();
        BeanUtils.copyProperties(skuCouponTo, smsSkuLadder);
        smsSkuLadder.setAddOther(skuCouponTo.getCountStatus());
//        smsSkuLadder.setPrice();
        smsSkuLadderService.add(smsSkuLadder);

        skuCouponTo.getMemberPrice().forEach(item -> {
            SmsMemberPrice smsMemberPrice = new SmsMemberPrice();
            smsMemberPrice.setSkuId(skuCouponTo.getSkuId());
            smsMemberPrice.setMemberPrice(item.getPrice());
            smsMemberPrice.setMemberLevelId(item.getId());
            smsMemberPrice.setMemberLevelName(item.getLevel());
            smsMemberPrice.setAddOther(1);
            smsMemberPriceService.add(smsMemberPrice);
        });

    }
}
