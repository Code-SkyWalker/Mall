package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsAttr;
import com.github.pagehelper.PageInfo;
import com.skywalker.pms.vo.AttrGroupsAndAttrs;

import java.util.List;
import java.util.Map;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrService
 * @Description TODO
 */
public interface PmsAttrService {

    /***
     * PmsAttr多条件分页查询
     *
     * @param attrType
     * @param pmsAttr
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsAttr> findPage(String attrType, PmsAttr pmsAttr, int page, int size);

    /***
     * PmsAttr分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsAttr> findPage(int page, int size);

    /***
     * PmsAttr多条件搜索方法
     * @param pmsAttr
     * @return
     */
    List<PmsAttr> findList(PmsAttr pmsAttr);

    /***
     * 删除PmsAttr
     * @param id
     */
    void delete(Long id);

    /***
     * 批量删除PmsAttr
     * @param ids
     */
    void delete(List<Long> ids);

    /***
     * 修改PmsAttr数据
     * @param pmsAttr
     */
    void update(PmsAttr pmsAttr);

    /***
     * 新增PmsAttr
     * @param pmsAttr
     */
    void add(PmsAttr pmsAttr);

    /**
     * 根据ID查询PmsAttr
     * @param id
     * @return
     */
     PmsAttr findById(Long id);

    /***
     * 查询所有PmsAttr
     * @return
     */
    List<PmsAttr> findAll();

    /**
     * 根据 categoryID 查询该分类下所有 PmsAttr
     *
     * @param attrType
     * @param categoryId 分类ID
     * @param page       页码
     * @param size       数据大小
     * @return /
     */
    List<PmsAttr> findAttrByCategoryId(String attrType, Long categoryId, int page, int size);

    /**
     * 根据 categoryID 查询该分类下所有 PmsAttr 的数量
     *
     * @param attrType
     * @param categoryId 分类ID
     * @return /
     */
    int findAttrByCategoryIdCount(String attrType, Long categoryId);

    /**
     * 获取当前分组没有关联的所有属性
     *
     * @param attrGroupId
     * @param attrName
     * @return
     */
    PageInfo<PmsAttr> getNotRelationAttr(Long attrGroupId, String attrName, int page, int size);

    /**
     * 根据属性ID查询属性
     *
     * @param attrIds  List<Long>
     * @param attrName
     * @return
     */
    List<PmsAttr> findAttrByCategoryIdAndAttrIds(Long catelogId, List<Long> attrIds, String attrName, int page, int size);

    /**
     * 根据 关联的分组 查询该分组下所有 属性
     * @param attrGroupId 分组ID
     * @return /
     */
    List<PmsAttr> findAttrByRelatedAttrGroup(Long attrGroupId);

}
