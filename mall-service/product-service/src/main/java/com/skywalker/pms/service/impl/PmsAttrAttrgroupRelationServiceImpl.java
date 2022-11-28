package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsAttrAttrgroupRelationMapper;
import com.skywalker.pms.pojo.PmsAttrAttrgroupRelation;
import com.skywalker.pms.service.PmsAttrAttrgroupRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsAttrAttrgroupRelationServiceImpl
 * @Description TODO
 */
@Service
public class PmsAttrAttrgroupRelationServiceImpl implements PmsAttrAttrgroupRelationService {

    @Autowired
    private PmsAttrAttrgroupRelationMapper pmsAttrAttrgroupRelationMapper;


    /**
     * PmsAttrAttrgroupRelation条件+分页查询
     * @param pmsAttrAttrgroupRelation 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsAttrAttrgroupRelation> findPage(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsAttrAttrgroupRelation);
        //执行搜索
        return new PageInfo<PmsAttrAttrgroupRelation>(pmsAttrAttrgroupRelationMapper.selectByExample(example));
    }

    /**
     * PmsAttrAttrgroupRelation分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsAttrAttrgroupRelation> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsAttrAttrgroupRelation>(pmsAttrAttrgroupRelationMapper.selectAll());
    }

    /**
     * PmsAttrAttrgroupRelation条件查询
     * @param pmsAttrAttrgroupRelation
     * @return
     */
    @Override
    public List<PmsAttrAttrgroupRelation> findList(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation){
        //构建查询条件
        Example example = createExample(pmsAttrAttrgroupRelation);
        //根据构建的条件查询数据
        return pmsAttrAttrgroupRelationMapper.selectByExample(example);
    }


    /**
     * PmsAttrAttrgroupRelation构建查询对象
     * @param pmsAttrAttrgroupRelation
     * @return
     */
    public Example createExample(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation){
        Example example=new Example(PmsAttrAttrgroupRelation.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsAttrAttrgroupRelation!=null){
            // id
            if(!StringUtils.isEmpty(pmsAttrAttrgroupRelation.getId())){
                    criteria.andEqualTo("id",pmsAttrAttrgroupRelation.getId());
            }
            // 属性id
            if(!StringUtils.isEmpty(pmsAttrAttrgroupRelation.getAttrId())){
                    criteria.andEqualTo("attrId",pmsAttrAttrgroupRelation.getAttrId());
            }
            // 属性分组id
            if(!StringUtils.isEmpty(pmsAttrAttrgroupRelation.getAttrGroupId())){
                    criteria.andEqualTo("attrGroupId",pmsAttrAttrgroupRelation.getAttrGroupId());
            }
            // 属性组内排序
            if(!StringUtils.isEmpty(pmsAttrAttrgroupRelation.getAttrSort())){
                    criteria.andEqualTo("attrSort",pmsAttrAttrgroupRelation.getAttrSort());
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
        pmsAttrAttrgroupRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsAttrAttrgroupRelation
     * @param pmsAttrAttrgroupRelation
     */
    @Override
    public void update(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation){
        pmsAttrAttrgroupRelationMapper.updateByPrimaryKey(pmsAttrAttrgroupRelation);
    }

    /**
     * 增加PmsAttrAttrgroupRelation
     * @param pmsAttrAttrgroupRelation
     */
    @Override
    public void add(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation){
        pmsAttrAttrgroupRelationMapper.insert(pmsAttrAttrgroupRelation);
    }

    /**
     * 根据ID查询PmsAttrAttrgroupRelation
     * @param id
     * @return
     */
    @Override
    public PmsAttrAttrgroupRelation findById(Long id){
        return  pmsAttrAttrgroupRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsAttrAttrgroupRelation全部数据
     * @return
     */
    @Override
    public List<PmsAttrAttrgroupRelation> findAll() {
        return pmsAttrAttrgroupRelationMapper.selectAll();
    }
}
