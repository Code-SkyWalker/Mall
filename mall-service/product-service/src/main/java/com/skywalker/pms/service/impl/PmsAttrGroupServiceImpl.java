package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsAttrGroupMapper;
import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.pojo.PmsAttrGroup;
import com.skywalker.pms.service.PmsAttrGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.pms.service.PmsAttrService;
import com.skywalker.pms.vo.AttrGroupsAndAttrs;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrGroupServiceImpl
 * @Description TODO
 */
@Service
public class PmsAttrGroupServiceImpl implements PmsAttrGroupService {

    @Resource
    private PmsAttrGroupMapper pmsAttrGroupMapper;

    @Autowired
    @Lazy
    private PmsAttrService pmsAttrService;


    /**
     * PmsAttrGroup条件+分页查询
     * @param pmsAttrGroup 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsAttrGroup> findPage(PmsAttrGroup pmsAttrGroup, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsAttrGroup);
        //执行搜索
        return new PageInfo<PmsAttrGroup>(pmsAttrGroupMapper.selectByExample(example));
    }

    /**
     * PmsAttrGroup分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsAttrGroup> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsAttrGroup>(pmsAttrGroupMapper.selectAll());
    }

    /**
     * PmsAttrGroup条件查询
     * @param pmsAttrGroup
     * @return
     */
    @Override
    public List<PmsAttrGroup> findList(PmsAttrGroup pmsAttrGroup){
        //构建查询条件
        Example example = createExample(pmsAttrGroup);
        //根据构建的条件查询数据
        return pmsAttrGroupMapper.selectByExample(example);
    }


    /**
     * PmsAttrGroup构建查询对象
     * @param pmsAttrGroup
     * @return
     */
    public Example createExample(PmsAttrGroup pmsAttrGroup){
        Example example=new Example(PmsAttrGroup.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsAttrGroup!=null){
            // 分组id
            if(!StringUtils.isEmpty(pmsAttrGroup.getAttrGroupId())){
                    criteria.andEqualTo("attrGroupId",pmsAttrGroup.getAttrGroupId());
            }
            // 组名
            if(!StringUtils.isEmpty(pmsAttrGroup.getAttrGroupName())){
                    criteria.andEqualTo("attrGroupName",pmsAttrGroup.getAttrGroupName());
            }
            // 排序
            if(!StringUtils.isEmpty(pmsAttrGroup.getSort())){
                    criteria.andEqualTo("sort",pmsAttrGroup.getSort());
            }
            // 描述
            if(!StringUtils.isEmpty(pmsAttrGroup.getDescript())){
                    criteria.andEqualTo("descript",pmsAttrGroup.getDescript());
            }
            // 组图标
            if(!StringUtils.isEmpty(pmsAttrGroup.getIcon())){
                    criteria.andEqualTo("icon",pmsAttrGroup.getIcon());
            }
            // 所属分类id
            if(!StringUtils.isEmpty(pmsAttrGroup.getCatelogId())){
                    criteria.andEqualTo("catelogId",pmsAttrGroup.getCatelogId());
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
        pmsAttrGroupMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteByIds(List<Long> ids) {
        Example example = new Example(PmsAttrGroup.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("attrGroupId", ids);
        pmsAttrGroupMapper.deleteByExample(example);
    }

    /**
     * 修改PmsAttrGroup
     * @param pmsAttrGroup
     */
    @Override
    public void update(PmsAttrGroup pmsAttrGroup){
        pmsAttrGroupMapper.updateByPrimaryKey(pmsAttrGroup);
    }

    /**
     * 增加PmsAttrGroup
     * @param pmsAttrGroup
     */
    @Override
    public void add(PmsAttrGroup pmsAttrGroup){
        pmsAttrGroupMapper.insert(pmsAttrGroup);
    }

    /**
     * 根据ID查询PmsAttrGroup
     * @param id
     * @return
     */
    @Override
    public PmsAttrGroup findById(Long id){
        return  pmsAttrGroupMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsAttrGroup全部数据
     * @return
     */
    @Override
    public List<PmsAttrGroup> findAll() {
        return pmsAttrGroupMapper.selectAll();
    }

    /**
     * 根据分类ID查询 attrGroup
     *
     * @param catId 分类ID
     * @param page
     * @param size
     * @return /
     */
    @Override
    public List<PmsAttrGroup> findAttrGroupByCategoryId(Long catId, int page, int size) {
        return pmsAttrGroupMapper.findAttrGroupByCategoryId(catId, (page - 1) * size, size);
    }

    /**
     * 根据分类ID查询 attrGroup
     *
     * @param catId
     * @return
     */
    @Override
    public List<PmsAttrGroup> findAttrGroupByCategoryId(Long catId) {
        if (Objects.isNull(catId)) return null;
        Example example = new Example(PmsAttrGroup.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catelogId", catId);
        return pmsAttrGroupMapper.selectByExample(example);
    }

    /**
     * 查询该分类下所有 属性组 的数量
     *
     * @param catId 分类ID
     * @return count
     */
    @Override
    public int findBrandByCategoryIdCount(Long catId) {
        return pmsAttrGroupMapper.findBrandByCategoryIdCount(catId);
    }

    /**
     * 根据 分类ID查询 该分类下所有 分类
     * @param categoryId
     * @return
     */
    public List<PmsAttrGroup> findAttrGroupsByCategory(Long categoryId) {
        Example example = new Example(PmsAttrGroup.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catelogId", categoryId);
        return pmsAttrGroupMapper.selectByExample(example);
    }

    /**
     * 根据 分类ID 查询属性分组及其分组下所有属性
     *
     * @param categoryId /
     * @return /
     */
    @Override
    public List<AttrGroupsAndAttrs> findAttrGroupsWithAttrsByCategoryId(Long categoryId) {
        // 查询所有属性分组
        List<PmsAttrGroup> attrGroupsByCategory = this.findAttrGroupsByCategory(categoryId);
        // 查询所有属性
        return attrGroupsByCategory.stream().map(group -> {
            AttrGroupsAndAttrs attrGroupsAndAttrs = new AttrGroupsAndAttrs();
            BeanUtils.copyProperties(group, attrGroupsAndAttrs);

            // 查询该分组下 所有属性
            attrGroupsAndAttrs.setAttrs(pmsAttrService.findAttrByRelatedAttrGroup(group.getAttrGroupId()));
            return attrGroupsAndAttrs;
        }).collect(Collectors.toList());
    }
}
