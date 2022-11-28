package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsMemberPriceMapper;
import com.skywalker.sms.pojo.SmsMemberPrice;
import com.skywalker.sms.service.SmsMemberPriceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsMemberPriceServiceImpl
 * @Description TODO
 */
@Service
public class SmsMemberPriceServiceImpl implements SmsMemberPriceService {

    @Autowired
    private SmsMemberPriceMapper smsMemberPriceMapper;


    /**
     * SmsMemberPrice条件+分页查询
     * @param smsMemberPrice 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsMemberPrice> findPage(SmsMemberPrice smsMemberPrice, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsMemberPrice);
        //执行搜索
        return new PageInfo<SmsMemberPrice>(smsMemberPriceMapper.selectByExample(example));
    }

    /**
     * SmsMemberPrice分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsMemberPrice> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsMemberPrice>(smsMemberPriceMapper.selectAll());
    }

    /**
     * SmsMemberPrice条件查询
     * @param smsMemberPrice
     * @return
     */
    @Override
    public List<SmsMemberPrice> findList(SmsMemberPrice smsMemberPrice){
        //构建查询条件
        Example example = createExample(smsMemberPrice);
        //根据构建的条件查询数据
        return smsMemberPriceMapper.selectByExample(example);
    }


    /**
     * SmsMemberPrice构建查询对象
     * @param smsMemberPrice
     * @return
     */
    public Example createExample(SmsMemberPrice smsMemberPrice){
        Example example=new Example(SmsMemberPrice.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsMemberPrice!=null){
            // id
            if(!StringUtils.isEmpty(smsMemberPrice.getId())){
                    criteria.andEqualTo("id",smsMemberPrice.getId());
            }
            // sku_id
            if(!StringUtils.isEmpty(smsMemberPrice.getSkuId())){
                    criteria.andEqualTo("skuId",smsMemberPrice.getSkuId());
            }
            // 会员等级id
            if(!StringUtils.isEmpty(smsMemberPrice.getMemberLevelId())){
                    criteria.andEqualTo("memberLevelId",smsMemberPrice.getMemberLevelId());
            }
            // 会员等级名
            if(!StringUtils.isEmpty(smsMemberPrice.getMemberLevelName())){
                    criteria.andEqualTo("memberLevelName",smsMemberPrice.getMemberLevelName());
            }
            // 会员对应价格
            if(!StringUtils.isEmpty(smsMemberPrice.getMemberPrice())){
                    criteria.andEqualTo("memberPrice",smsMemberPrice.getMemberPrice());
            }
            // 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
            if(!StringUtils.isEmpty(smsMemberPrice.getAddOther())){
                    criteria.andEqualTo("addOther",smsMemberPrice.getAddOther());
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
        smsMemberPriceMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsMemberPrice
     * @param smsMemberPrice
     */
    @Override
    public void update(SmsMemberPrice smsMemberPrice){
        smsMemberPriceMapper.updateByPrimaryKey(smsMemberPrice);
    }

    /**
     * 增加SmsMemberPrice
     * @param smsMemberPrice
     */
    @Override
    public void add(SmsMemberPrice smsMemberPrice){
        smsMemberPriceMapper.insert(smsMemberPrice);
    }

    /**
     * 根据ID查询SmsMemberPrice
     * @param id
     * @return
     */
    @Override
    public SmsMemberPrice findById(Long id){
        return  smsMemberPriceMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsMemberPrice全部数据
     * @return
     */
    @Override
    public List<SmsMemberPrice> findAll() {
        return smsMemberPriceMapper.selectAll();
    }
}
