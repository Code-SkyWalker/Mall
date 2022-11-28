package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsCouponSpuRelationMapper;
import com.skywalker.sms.pojo.SmsCouponSpuRelation;
import com.skywalker.sms.service.SmsCouponSpuRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuRelationServiceImpl
 * @Description TODO
 */
@Service
public class SmsCouponSpuRelationServiceImpl implements SmsCouponSpuRelationService {

    @Autowired
    private SmsCouponSpuRelationMapper smsCouponSpuRelationMapper;


    /**
     * SmsCouponSpuRelation条件+分页查询
     * @param smsCouponSpuRelation 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsCouponSpuRelation> findPage(SmsCouponSpuRelation smsCouponSpuRelation, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsCouponSpuRelation);
        //执行搜索
        return new PageInfo<SmsCouponSpuRelation>(smsCouponSpuRelationMapper.selectByExample(example));
    }

    /**
     * SmsCouponSpuRelation分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsCouponSpuRelation> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsCouponSpuRelation>(smsCouponSpuRelationMapper.selectAll());
    }

    /**
     * SmsCouponSpuRelation条件查询
     * @param smsCouponSpuRelation
     * @return
     */
    @Override
    public List<SmsCouponSpuRelation> findList(SmsCouponSpuRelation smsCouponSpuRelation){
        //构建查询条件
        Example example = createExample(smsCouponSpuRelation);
        //根据构建的条件查询数据
        return smsCouponSpuRelationMapper.selectByExample(example);
    }


    /**
     * SmsCouponSpuRelation构建查询对象
     * @param smsCouponSpuRelation
     * @return
     */
    public Example createExample(SmsCouponSpuRelation smsCouponSpuRelation){
        Example example=new Example(SmsCouponSpuRelation.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsCouponSpuRelation!=null){
            // id
            if(!StringUtils.isEmpty(smsCouponSpuRelation.getId())){
                    criteria.andEqualTo("id",smsCouponSpuRelation.getId());
            }
            // 优惠券id
            if(!StringUtils.isEmpty(smsCouponSpuRelation.getCouponId())){
                    criteria.andEqualTo("couponId",smsCouponSpuRelation.getCouponId());
            }
            // spu_id
            if(!StringUtils.isEmpty(smsCouponSpuRelation.getSpuId())){
                    criteria.andEqualTo("spuId",smsCouponSpuRelation.getSpuId());
            }
            // spu_name
            if(!StringUtils.isEmpty(smsCouponSpuRelation.getSpuName())){
                    criteria.andEqualTo("spuName",smsCouponSpuRelation.getSpuName());
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
        smsCouponSpuRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsCouponSpuRelation
     * @param smsCouponSpuRelation
     */
    @Override
    public void update(SmsCouponSpuRelation smsCouponSpuRelation){
        smsCouponSpuRelationMapper.updateByPrimaryKey(smsCouponSpuRelation);
    }

    /**
     * 增加SmsCouponSpuRelation
     * @param smsCouponSpuRelation
     */
    @Override
    public void add(SmsCouponSpuRelation smsCouponSpuRelation){
        smsCouponSpuRelationMapper.insert(smsCouponSpuRelation);
    }

    /**
     * 根据ID查询SmsCouponSpuRelation
     * @param id
     * @return
     */
    @Override
    public SmsCouponSpuRelation findById(Long id){
        return  smsCouponSpuRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsCouponSpuRelation全部数据
     * @return
     */
    @Override
    public List<SmsCouponSpuRelation> findAll() {
        return smsCouponSpuRelationMapper.selectAll();
    }
}
