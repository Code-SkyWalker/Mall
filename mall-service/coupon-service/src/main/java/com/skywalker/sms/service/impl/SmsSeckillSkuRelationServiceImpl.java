package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsSeckillSkuRelationMapper;
import com.skywalker.sms.pojo.SmsSeckillSkuRelation;
import com.skywalker.sms.service.SmsSeckillSkuRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuRelationServiceImpl
 * @Description TODO
 */
@Service
public class SmsSeckillSkuRelationServiceImpl implements SmsSeckillSkuRelationService {

    @Autowired
    private SmsSeckillSkuRelationMapper smsSeckillSkuRelationMapper;


    /**
     * SmsSeckillSkuRelation条件+分页查询
     * @param smsSeckillSkuRelation 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsSeckillSkuRelation> findPage(SmsSeckillSkuRelation smsSeckillSkuRelation, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsSeckillSkuRelation);
        //执行搜索
        return new PageInfo<SmsSeckillSkuRelation>(smsSeckillSkuRelationMapper.selectByExample(example));
    }

    /**
     * SmsSeckillSkuRelation分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsSeckillSkuRelation> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsSeckillSkuRelation>(smsSeckillSkuRelationMapper.selectAll());
    }

    /**
     * SmsSeckillSkuRelation条件查询
     * @param smsSeckillSkuRelation
     * @return
     */
    @Override
    public List<SmsSeckillSkuRelation> findList(SmsSeckillSkuRelation smsSeckillSkuRelation){
        //构建查询条件
        Example example = createExample(smsSeckillSkuRelation);
        //根据构建的条件查询数据
        return smsSeckillSkuRelationMapper.selectByExample(example);
    }


    /**
     * SmsSeckillSkuRelation构建查询对象
     * @param smsSeckillSkuRelation
     * @return
     */
    public Example createExample(SmsSeckillSkuRelation smsSeckillSkuRelation){
        Example example=new Example(SmsSeckillSkuRelation.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsSeckillSkuRelation!=null){
            // id
            if(!StringUtils.isEmpty(smsSeckillSkuRelation.getId())){
                    criteria.andEqualTo("id",smsSeckillSkuRelation.getId());
            }
            // 活动id
            if(!StringUtils.isEmpty(smsSeckillSkuRelation.getPromotionId())){
                    criteria.andEqualTo("promotionId",smsSeckillSkuRelation.getPromotionId());
            }
            // 活动场次id
            if(!StringUtils.isEmpty(smsSeckillSkuRelation.getPromotionSessionId())){
                    criteria.andEqualTo("promotionSessionId",smsSeckillSkuRelation.getPromotionSessionId());
            }
            // 商品id
            if(!StringUtils.isEmpty(smsSeckillSkuRelation.getSkuId())){
                    criteria.andEqualTo("skuId",smsSeckillSkuRelation.getSkuId());
            }
            // 秒杀价格
            if(!StringUtils.isEmpty(smsSeckillSkuRelation.getSeckillPrice())){
                    criteria.andEqualTo("seckillPrice",smsSeckillSkuRelation.getSeckillPrice());
            }
            // 秒杀总量
            if(!StringUtils.isEmpty(smsSeckillSkuRelation.getSeckillCount())){
                    criteria.andEqualTo("seckillCount",smsSeckillSkuRelation.getSeckillCount());
            }
            // 每人限购数量
            if(!StringUtils.isEmpty(smsSeckillSkuRelation.getSeckillLimit())){
                    criteria.andEqualTo("seckillLimit",smsSeckillSkuRelation.getSeckillLimit());
            }
            // 排序
            if(!StringUtils.isEmpty(smsSeckillSkuRelation.getSeckillSort())){
                    criteria.andEqualTo("seckillSort",smsSeckillSkuRelation.getSeckillSort());
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
        smsSeckillSkuRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsSeckillSkuRelation
     * @param smsSeckillSkuRelation
     */
    @Override
    public void update(SmsSeckillSkuRelation smsSeckillSkuRelation){
        smsSeckillSkuRelationMapper.updateByPrimaryKey(smsSeckillSkuRelation);
    }

    /**
     * 增加SmsSeckillSkuRelation
     * @param smsSeckillSkuRelation
     */
    @Override
    public void add(SmsSeckillSkuRelation smsSeckillSkuRelation){
        smsSeckillSkuRelationMapper.insert(smsSeckillSkuRelation);
    }

    /**
     * 根据ID查询SmsSeckillSkuRelation
     * @param id
     * @return
     */
    @Override
    public SmsSeckillSkuRelation findById(Long id){
        return  smsSeckillSkuRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsSeckillSkuRelation全部数据
     * @return
     */
    @Override
    public List<SmsSeckillSkuRelation> findAll() {
        return smsSeckillSkuRelationMapper.selectAll();
    }
}
