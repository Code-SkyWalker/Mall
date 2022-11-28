package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsCategoryBrandRelationMapper;
import com.skywalker.pms.pojo.PmsCategoryBrandRelation;
import com.skywalker.pms.service.PmsCategoryBrandRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryBrandRelationServiceImpl
 * @Description TODO
 */
@Service
public class PmsCategoryBrandRelationServiceImpl implements PmsCategoryBrandRelationService {

    @Autowired
    private PmsCategoryBrandRelationMapper pmsCategoryBrandRelationMapper;


    /**
     * PmsCategoryBrandRelation条件+分页查询
     * @param pmsCategoryBrandRelation 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsCategoryBrandRelation> findPage(PmsCategoryBrandRelation pmsCategoryBrandRelation, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsCategoryBrandRelation);
        //执行搜索
        return new PageInfo<PmsCategoryBrandRelation>(pmsCategoryBrandRelationMapper.selectByExample(example));
    }

    /**
     * PmsCategoryBrandRelation分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsCategoryBrandRelation> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsCategoryBrandRelation>(pmsCategoryBrandRelationMapper.selectAll());
    }

    /**
     * PmsCategoryBrandRelation条件查询
     * @param pmsCategoryBrandRelation
     * @return
     */
    @Override
    public List<PmsCategoryBrandRelation> findList(PmsCategoryBrandRelation pmsCategoryBrandRelation){
        //构建查询条件
        Example example = createExample(pmsCategoryBrandRelation);
        //根据构建的条件查询数据
        return pmsCategoryBrandRelationMapper.selectByExample(example);
    }


    /**
     * PmsCategoryBrandRelation构建查询对象
     * @param pmsCategoryBrandRelation
     * @return
     */
    public Example createExample(PmsCategoryBrandRelation pmsCategoryBrandRelation){
        Example example=new Example(PmsCategoryBrandRelation.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsCategoryBrandRelation!=null){
            // 
            if(!StringUtils.isEmpty(pmsCategoryBrandRelation.getId())){
                    criteria.andEqualTo("id",pmsCategoryBrandRelation.getId());
            }
            // 品牌id
            if(!StringUtils.isEmpty(pmsCategoryBrandRelation.getBrandId())){
                    criteria.andEqualTo("brandId",pmsCategoryBrandRelation.getBrandId());
            }
            // 分类id
            if(!StringUtils.isEmpty(pmsCategoryBrandRelation.getCatelogId())){
                    criteria.andEqualTo("catelogId",pmsCategoryBrandRelation.getCatelogId());
            }
            // 
            if(!StringUtils.isEmpty(pmsCategoryBrandRelation.getBrandName())){
                    criteria.andEqualTo("brandName",pmsCategoryBrandRelation.getBrandName());
            }
            // 
            if(!StringUtils.isEmpty(pmsCategoryBrandRelation.getCatelogName())){
                    criteria.andEqualTo("catelogName",pmsCategoryBrandRelation.getCatelogName());
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
        pmsCategoryBrandRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsCategoryBrandRelation
     * @param pmsCategoryBrandRelation
     */
    @Override
    public void update(PmsCategoryBrandRelation pmsCategoryBrandRelation){
        pmsCategoryBrandRelationMapper.updateByPrimaryKey(pmsCategoryBrandRelation);
    }

    /**
     * 增加PmsCategoryBrandRelation
     * @param pmsCategoryBrandRelation
     */
    @Override
    public void add(PmsCategoryBrandRelation pmsCategoryBrandRelation){
        pmsCategoryBrandRelationMapper.insert(pmsCategoryBrandRelation);
    }

    /**
     * 根据ID查询PmsCategoryBrandRelation
     * @param id
     * @return
     */
    @Override
    public PmsCategoryBrandRelation findById(Long id){
        return  pmsCategoryBrandRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsCategoryBrandRelation全部数据
     * @return
     */
    @Override
    public List<PmsCategoryBrandRelation> findAll() {
        return pmsCategoryBrandRelationMapper.selectAll();
    }
}
