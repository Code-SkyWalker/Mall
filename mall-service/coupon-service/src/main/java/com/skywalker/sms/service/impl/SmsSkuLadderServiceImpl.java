package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsSkuLadderMapper;
import com.skywalker.sms.pojo.SmsSkuLadder;
import com.skywalker.sms.service.SmsSkuLadderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSkuLadderServiceImpl
 * @Description TODO
 */
@Service
public class SmsSkuLadderServiceImpl implements SmsSkuLadderService {

    @Autowired
    private SmsSkuLadderMapper smsSkuLadderMapper;


    /**
     * SmsSkuLadder条件+分页查询
     * @param smsSkuLadder 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsSkuLadder> findPage(SmsSkuLadder smsSkuLadder, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsSkuLadder);
        //执行搜索
        return new PageInfo<SmsSkuLadder>(smsSkuLadderMapper.selectByExample(example));
    }

    /**
     * SmsSkuLadder分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsSkuLadder> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsSkuLadder>(smsSkuLadderMapper.selectAll());
    }

    /**
     * SmsSkuLadder条件查询
     * @param smsSkuLadder
     * @return
     */
    @Override
    public List<SmsSkuLadder> findList(SmsSkuLadder smsSkuLadder){
        //构建查询条件
        Example example = createExample(smsSkuLadder);
        //根据构建的条件查询数据
        return smsSkuLadderMapper.selectByExample(example);
    }


    /**
     * SmsSkuLadder构建查询对象
     * @param smsSkuLadder
     * @return
     */
    public Example createExample(SmsSkuLadder smsSkuLadder){
        Example example=new Example(SmsSkuLadder.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsSkuLadder!=null){
            // id
            if(!StringUtils.isEmpty(smsSkuLadder.getId())){
                    criteria.andEqualTo("id",smsSkuLadder.getId());
            }
            // spu_id
            if(!StringUtils.isEmpty(smsSkuLadder.getSkuId())){
                    criteria.andEqualTo("skuId",smsSkuLadder.getSkuId());
            }
            // 满几件
            if(!StringUtils.isEmpty(smsSkuLadder.getFullCount())){
                    criteria.andEqualTo("fullCount",smsSkuLadder.getFullCount());
            }
            // 打几折
            if(!StringUtils.isEmpty(smsSkuLadder.getDiscount())){
                    criteria.andEqualTo("discount",smsSkuLadder.getDiscount());
            }
            // 折后价
            if(!StringUtils.isEmpty(smsSkuLadder.getPrice())){
                    criteria.andEqualTo("price",smsSkuLadder.getPrice());
            }
            // 是否叠加其他优惠[0-不可叠加，1-可叠加]
            if(!StringUtils.isEmpty(smsSkuLadder.getAddOther())){
                    criteria.andEqualTo("addOther",smsSkuLadder.getAddOther());
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
        smsSkuLadderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsSkuLadder
     * @param smsSkuLadder
     */
    @Override
    public void update(SmsSkuLadder smsSkuLadder){
        smsSkuLadderMapper.updateByPrimaryKey(smsSkuLadder);
    }

    /**
     * 增加SmsSkuLadder
     * @param smsSkuLadder
     */
    @Override
    public void add(SmsSkuLadder smsSkuLadder){
        smsSkuLadderMapper.insert(smsSkuLadder);
    }

    /**
     * 根据ID查询SmsSkuLadder
     * @param id
     * @return
     */
    @Override
    public SmsSkuLadder findById(Long id){
        return  smsSkuLadderMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsSkuLadder全部数据
     * @return
     */
    @Override
    public List<SmsSkuLadder> findAll() {
        return smsSkuLadderMapper.selectAll();
    }
}
