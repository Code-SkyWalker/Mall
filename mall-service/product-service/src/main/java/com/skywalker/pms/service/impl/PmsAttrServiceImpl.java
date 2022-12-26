package com.skywalker.pms.service.impl;

import com.skywalker.constant.ProductConstant;
import com.skywalker.pms.dao.PmsAttrMapper;
import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.pojo.PmsAttrAttrgroupRelation;
import com.skywalker.pms.pojo.PmsAttrGroup;
import com.skywalker.pms.service.PmsAttrAttrgroupRelationService;
import com.skywalker.pms.service.PmsAttrGroupService;
import com.skywalker.pms.service.PmsAttrService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.pms.vo.AttrGroupsAndAttrs;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrServiceImpl
 * @Description TODO
 */
@Service
public class PmsAttrServiceImpl implements PmsAttrService {

    @Resource
    private PmsAttrMapper pmsAttrMapper;

    @Autowired
    private PmsAttrGroupService pmsAttrGroupService;

    @Autowired
    private PmsAttrAttrgroupRelationService pmsAttrAttrgroupRelationService;

    @Autowired
    private PmsAttrService pmsAttrService;


    /**
     * PmsAttr条件+分页查询
     *
     * @param attrType
     * @param pmsAttr  查询条件
     * @param page     页码
     * @param size     页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsAttr> findPage(String attrType, PmsAttr pmsAttr, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(pmsAttr, attrType);
        //执行搜索
        return new PageInfo<>(pmsAttrMapper.selectByExample(example));
    }

    /**
     * PmsAttr分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsAttr> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<>(pmsAttrMapper.selectAll());
    }

    /**
     * PmsAttr条件查询
     *
     * @param pmsAttr
     * @return
     */
    @Override
    public List<PmsAttr> findList(PmsAttr pmsAttr) {
        //构建查询条件
        Example example = createExample(pmsAttr);
        //根据构建的条件查询数据
        return pmsAttrMapper.selectByExample(example);
    }


    /**
     * PmsAttr构建查询对象
     *
     * @param attrType
     * @param pmsAttr
     * @return
     */
    public Example createExample(PmsAttr pmsAttr, String... attrType) {
        Example example = new Example(PmsAttr.class);
        Example.Criteria criteria = example.createCriteria();
        if (pmsAttr != null) {
            // 属性id
            if (!StringUtils.isEmpty(pmsAttr.getAttrId())) {
                criteria.andEqualTo("attrId", pmsAttr.getAttrId());
            }
            // 属性名
            if (!StringUtils.isEmpty(pmsAttr.getAttrName())) {
                criteria.andLike("attrName", "%" + pmsAttr.getAttrName() + "%");
            }
            // 是否需要检索[0-不需要，1-需要]
            if (!StringUtils.isEmpty(pmsAttr.getSearchType())) {
                criteria.andEqualTo("searchType", pmsAttr.getSearchType());
            }
            // 属性图标
            if (!StringUtils.isEmpty(pmsAttr.getIcon())) {
                criteria.andEqualTo("icon", pmsAttr.getIcon());
            }
            // 可选值列表[用逗号分隔]
            if (!StringUtils.isEmpty(pmsAttr.getValueSelect())) {
                criteria.andEqualTo("valueSelect", pmsAttr.getValueSelect());
            }
            // 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
            if (!StringUtils.isEmpty(pmsAttr.getAttrType())) {
                criteria.andEqualTo("attrType", pmsAttr.getAttrType());
            }
            // 属性类型
            if (!Arrays.isNullOrEmpty(attrType)) {
                if (attrType[0].equals("base")) {
                    criteria.andEqualTo("attrType", 0);
                } else {
                    criteria.andNotEqualTo("attrType", 0);
                }
            }
            // 启用状态[0 - 禁用，1 - 启用]
            if (!StringUtils.isEmpty(pmsAttr.getEnable())) {
                criteria.andEqualTo("enable", pmsAttr.getEnable());
            }
            // 所属分类
            if (!StringUtils.isEmpty(pmsAttr.getCatelogId())) {
                criteria.andEqualTo("catelogId", pmsAttr.getCatelogId());
            }
            // 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
            if (!StringUtils.isEmpty(pmsAttr.getShowDesc())) {
                criteria.andEqualTo("showDesc", pmsAttr.getShowDesc());
            }
        }
        return example;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        pmsAttrMapper.deleteByPrimaryKey(id);
    }

    /***
     * 批量删除PmsAttr
     * @param ids
     */
    @Override
    public void delete(List<Long> ids) {
        Example example = new Example(PmsAttr.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("attrId", ids);
        pmsAttrMapper.deleteByExample(example);
    }

    /**
     * 修改PmsAttr
     *
     * @param pmsAttr
     */
    @Override
    public void update(PmsAttr pmsAttr) {
        pmsAttrMapper.updateByPrimaryKey(pmsAttr);
    }

    /**
     * 增加PmsAttr
     *
     * @param pmsAttr
     */
    @Override
    public void add(PmsAttr pmsAttr) {
        pmsAttrMapper.insert(pmsAttr);
    }

    /**
     * 根据ID查询PmsAttr
     *
     * @param id
     * @return
     */
    @Override
    public PmsAttr findById(Long id) {
        return pmsAttrMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsAttr全部数据
     *
     * @return
     */
    @Override
    public List<PmsAttr> findAll() {
        return pmsAttrMapper.selectAll();
    }

    /**
     * 根据 categoryID 查询该分类下所有 PmsAttr
     *
     * @param attrType
     * @param categoryId 分类ID
     * @param page       页码
     * @param size       数据大小
     * @return /
     */
    @Override
    public List<PmsAttr> findAttrByCategoryId(String attrType, Long categoryId, int page, int size) {
        return pmsAttrMapper.findAttrByCategoryId(attrType, categoryId, (page - 1) * size, size);
    }

    /**
     * 根据 categoryID 查询该分类下所有 PmsAttr 的数量
     *
     * @param attrType
     * @param categoryId 分类ID
     * @return /
     */
    @Override
    public int findAttrByCategoryIdCount(String attrType, Long categoryId) {
        return pmsAttrMapper.findAttrByCategoryIdCount(attrType, categoryId);
    }

    /**
     * 根据属性ID查询属性
     *
     * @param attrIds  List<Long>
     * @param attrName
     * @return
     */
    @Override
    public List<PmsAttr> findAttrByCategoryIdAndAttrIds(Long catelogId, List<Long> attrIds, String attrName, int page, int size) {
        if (attrIds.isEmpty() || Objects.isNull(catelogId)) return null;

        PageHelper.startPage(page, size);
        Example example = new Example(PmsAttr.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotIn("attrId", attrIds);
        criteria.andEqualTo("catelogId", catelogId);
        if (!StringUtils.isEmpty(attrName)) criteria.andLike("attrName","%" + attrName + "%");
        return pmsAttrMapper.selectByExample(example);
    }

    /**
     * 获取当前分组没有关联的所有属性
     *
     * @param attrGroupId
     * @param attrName
     * @return
     */
    @Override
    public PageInfo<PmsAttr> getNotRelationAttr(Long attrGroupId, String attrName, int page, int size) {
        // 当前分组只能关联自己所属的分类里的所有属性, 获取当前分组中的 分类ID
        Long catelogId = this.pmsAttrGroupService.findById(attrGroupId).getCatelogId();

        // 当前分组只能关联别的分组所没有引用的属性
        //  当前分类下的其他分组
        List<Long> otherGroupIds = this.pmsAttrGroupService.findAttrGroupByCategoryId(catelogId)
                .stream().map(PmsAttrGroup::getAttrGroupId)
//                .filter(groupId -> !Objects.equals(groupId, attrGroupId))
                .collect(Collectors.toList());
        //  从当前分类的所有属性中移除这些属性
        List<Long> attrIds = this.pmsAttrAttrgroupRelationService.findListByGroupIds(otherGroupIds)
                .stream().map(PmsAttrAttrgroupRelation::getAttrId)
                .collect(Collectors.toList());

        if (attrIds.isEmpty()) return new PageInfo<>(Collections.emptyList());

        // 从attr表中根据attrIds查询attr
        List<PmsAttr> attrs = this.findAttrByCategoryIdAndAttrIds(catelogId, attrIds, attrName, page, size)
                .stream().filter(ele -> ele.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode())
                .collect(Collectors.toList());
        return new PageInfo<>(attrs);
    }

    /**
     * 根据 关联的分组 查询该分组下所有 属性
     *
     * @param attrGroupId 分组ID
     * @return /
     */
    @Override
    public List<PmsAttr> findAttrByRelatedAttrGroup(Long attrGroupId) {
        return pmsAttrMapper.findAttrByRelatedAttrGroup(attrGroupId);
    }
}
