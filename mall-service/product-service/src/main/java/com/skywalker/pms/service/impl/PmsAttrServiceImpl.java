package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsAttrMapper;
import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.service.PmsAttrService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsAttrServiceImpl
 * @Description TODO
 */
@Service
public class PmsAttrServiceImpl implements PmsAttrService {

    @Autowired
    private PmsAttrMapper pmsAttrMapper;


    /**
     * PmsAttr条件+分页查询
     * @param pmsAttr 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsAttr> findPage(PmsAttr pmsAttr, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsAttr);
        //执行搜索
        return new PageInfo<PmsAttr>(pmsAttrMapper.selectByExample(example));
    }

    /**
     * PmsAttr分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsAttr> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsAttr>(pmsAttrMapper.selectAll());
    }

    /**
     * PmsAttr条件查询
     * @param pmsAttr
     * @return
     */
    @Override
    public List<PmsAttr> findList(PmsAttr pmsAttr){
        //构建查询条件
        Example example = createExample(pmsAttr);
        //根据构建的条件查询数据
        return pmsAttrMapper.selectByExample(example);
    }


    /**
     * PmsAttr构建查询对象
     * @param pmsAttr
     * @return
     */
    public Example createExample(PmsAttr pmsAttr){
        Example example=new Example(PmsAttr.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsAttr!=null){
            // 属性id
            if(!StringUtils.isEmpty(pmsAttr.getAttrId())){
                    criteria.andEqualTo("attrId",pmsAttr.getAttrId());
            }
            // 属性名
            if(!StringUtils.isEmpty(pmsAttr.getAttrName())){
                    criteria.andEqualTo("attrName",pmsAttr.getAttrName());
            }
            // 是否需要检索[0-不需要，1-需要]
            if(!StringUtils.isEmpty(pmsAttr.getSearchType())){
                    criteria.andEqualTo("searchType",pmsAttr.getSearchType());
            }
            // 属性图标
            if(!StringUtils.isEmpty(pmsAttr.getIcon())){
                    criteria.andEqualTo("icon",pmsAttr.getIcon());
            }
            // 可选值列表[用逗号分隔]
            if(!StringUtils.isEmpty(pmsAttr.getValueSelect())){
                    criteria.andEqualTo("valueSelect",pmsAttr.getValueSelect());
            }
            // 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
            if(!StringUtils.isEmpty(pmsAttr.getAttrType())){
                    criteria.andEqualTo("attrType",pmsAttr.getAttrType());
            }
            // 启用状态[0 - 禁用，1 - 启用]
            if(!StringUtils.isEmpty(pmsAttr.getEnable())){
                    criteria.andEqualTo("enable",pmsAttr.getEnable());
            }
            // 所属分类
            if(!StringUtils.isEmpty(pmsAttr.getCatelogId())){
                    criteria.andEqualTo("catelogId",pmsAttr.getCatelogId());
            }
            // 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
            if(!StringUtils.isEmpty(pmsAttr.getShowDesc())){
                    criteria.andEqualTo("showDesc",pmsAttr.getShowDesc());
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
        pmsAttrMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsAttr
     * @param pmsAttr
     */
    @Override
    public void update(PmsAttr pmsAttr){
        pmsAttrMapper.updateByPrimaryKey(pmsAttr);
    }

    /**
     * 增加PmsAttr
     * @param pmsAttr
     */
    @Override
    public void add(PmsAttr pmsAttr){
        pmsAttrMapper.insert(pmsAttr);
    }

    /**
     * 根据ID查询PmsAttr
     * @param id
     * @return
     */
    @Override
    public PmsAttr findById(Long id){
        return  pmsAttrMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsAttr全部数据
     * @return
     */
    @Override
    public List<PmsAttr> findAll() {
        return pmsAttrMapper.selectAll();
    }
}
