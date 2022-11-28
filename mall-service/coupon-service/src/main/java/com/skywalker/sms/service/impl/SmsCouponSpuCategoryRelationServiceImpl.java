package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsCouponSpuCategoryRelationMapper;
import com.skywalker.sms.pojo.SmsCouponSpuCategoryRelation;
import com.skywalker.sms.service.SmsCouponSpuCategoryRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuCategoryRelationServiceImpl
 * @Description TODO
 */
@Service
public class SmsCouponSpuCategoryRelationServiceImpl implements SmsCouponSpuCategoryRelationService {

    @Autowired
    private SmsCouponSpuCategoryRelationMapper smsCouponSpuCategoryRelationMapper;


    /**
     * SmsCouponSpuCategoryRelation条件+分页查询
     * @param smsCouponSpuCategoryRelation 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsCouponSpuCategoryRelation> findPage(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsCouponSpuCategoryRelation);
        //执行搜索
        return new PageInfo<SmsCouponSpuCategoryRelation>(smsCouponSpuCategoryRelationMapper.selectByExample(example));
    }

    /**
     * SmsCouponSpuCategoryRelation分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsCouponSpuCategoryRelation> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsCouponSpuCategoryRelation>(smsCouponSpuCategoryRelationMapper.selectAll());
    }

    /**
     * SmsCouponSpuCategoryRelation条件查询
     * @param smsCouponSpuCategoryRelation
     * @return
     */
    @Override
    public List<SmsCouponSpuCategoryRelation> findList(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation){
        //构建查询条件
        Example example = createExample(smsCouponSpuCategoryRelation);
        //根据构建的条件查询数据
        return smsCouponSpuCategoryRelationMapper.selectByExample(example);
    }


    /**
     * SmsCouponSpuCategoryRelation构建查询对象
     * @param smsCouponSpuCategoryRelation
     * @return
     */
    public Example createExample(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation){
        Example example=new Example(SmsCouponSpuCategoryRelation.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsCouponSpuCategoryRelation!=null){
            // id
            if(!StringUtils.isEmpty(smsCouponSpuCategoryRelation.getId())){
                    criteria.andEqualTo("id",smsCouponSpuCategoryRelation.getId());
            }
            // 优惠券id
            if(!StringUtils.isEmpty(smsCouponSpuCategoryRelation.getCouponId())){
                    criteria.andEqualTo("couponId",smsCouponSpuCategoryRelation.getCouponId());
            }
            // 产品分类id
            if(!StringUtils.isEmpty(smsCouponSpuCategoryRelation.getCategoryId())){
                    criteria.andEqualTo("categoryId",smsCouponSpuCategoryRelation.getCategoryId());
            }
            // 产品分类名称
            if(!StringUtils.isEmpty(smsCouponSpuCategoryRelation.getCategoryName())){
                    criteria.andEqualTo("categoryName",smsCouponSpuCategoryRelation.getCategoryName());
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
        smsCouponSpuCategoryRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsCouponSpuCategoryRelation
     * @param smsCouponSpuCategoryRelation
     */
    @Override
    public void update(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation){
        smsCouponSpuCategoryRelationMapper.updateByPrimaryKey(smsCouponSpuCategoryRelation);
    }

    /**
     * 增加SmsCouponSpuCategoryRelation
     * @param smsCouponSpuCategoryRelation
     */
    @Override
    public void add(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation){
        smsCouponSpuCategoryRelationMapper.insert(smsCouponSpuCategoryRelation);
    }

    /**
     * 根据ID查询SmsCouponSpuCategoryRelation
     * @param id
     * @return
     */
    @Override
    public SmsCouponSpuCategoryRelation findById(Long id){
        return  smsCouponSpuCategoryRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsCouponSpuCategoryRelation全部数据
     * @return
     */
    @Override
    public List<SmsCouponSpuCategoryRelation> findAll() {
        return smsCouponSpuCategoryRelationMapper.selectAll();
    }
}
