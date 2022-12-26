package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.pojo.PmsAttrGroup;
import com.github.pagehelper.PageInfo;
import com.skywalker.pms.vo.AttrGroupsAndAttrs;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsAttrGroupService
 * @Description TODO
 */
public interface PmsAttrGroupService {

    /***
     * PmsAttrGroup多条件分页查询
     * @param pmsAttrGroup
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsAttrGroup> findPage(PmsAttrGroup pmsAttrGroup, int page, int size);

    /***
     * PmsAttrGroup分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsAttrGroup> findPage(int page, int size);

    /***
     * PmsAttrGroup多条件搜索方法
     * @param pmsAttrGroup /
     * @return /
     */
    List<PmsAttrGroup> findList(PmsAttrGroup pmsAttrGroup);

    /***
     * 删除PmsAttrGroup
     * @param id /
     */
    void delete(Long id);

    /**
     * 批量删除
     * @param ids /
     */
    void deleteByIds(List<Long> ids);

    /***
     * 修改PmsAttrGroup数据
     * @param pmsAttrGroup /
     */
    void update(PmsAttrGroup pmsAttrGroup);

    /***
     * 新增PmsAttrGroup
     * @param pmsAttrGroup /
     */
    void add(PmsAttrGroup pmsAttrGroup);

    /**
     * 根据ID查询PmsAttrGroup
     * @param id attrGroupId
     * @return /
     */
     PmsAttrGroup findById(Long id);

    /***
     * 查询所有PmsAttrGroup
     * @return /
     */
    List<PmsAttrGroup> findAll();

    /**
     * 根据分类ID查询 attrGroup
     *
     * @param catId 分类ID
     * @param page
     * @param size
     * @return /
     */
    List<PmsAttrGroup> findAttrGroupByCategoryId(Long catId, int page, int size);

    /**
     * 根据分类ID查询 attrGroup
     * @param catId
     * @return
     */
    List<PmsAttrGroup> findAttrGroupByCategoryId(Long catId);

    /**
     * 查询该分类下所有 属性组 的数量
     * @param catId 分类ID
     * @return count
     */
    int findBrandByCategoryIdCount(Long catId);

    /**
     * 根据 分类ID 查询属性分组及其分组下所有属性
     * @param categoryId /
     * @return /
     */
    List<AttrGroupsAndAttrs> findAttrGroupsWithAttrsByCategoryId(Long categoryId);
}
