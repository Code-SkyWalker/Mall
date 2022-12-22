package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.pojo.PmsAttrAttrgroupRelation;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsAttrAttrgroupRelationService
 * @Description TODO
 */
public interface PmsAttrAttrgroupRelationService {

    /***
     * PmsAttrAttrgroupRelation多条件分页查询
     * @param pmsAttrAttrgroupRelation
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsAttrAttrgroupRelation> findPage(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation, int page, int size);

    /***
     * PmsAttrAttrgroupRelation分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsAttrAttrgroupRelation> findPage(int page, int size);

    /***
     * PmsAttrAttrgroupRelation多条件搜索方法
     * @param pmsAttrAttrgroupRelation
     * @return
     */
    List<PmsAttrAttrgroupRelation> findList(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 通过分组ID查询 属性
     * @param groupIds
     * @return
     */
    List<PmsAttrAttrgroupRelation> findListByGroupIds(List<Long> groupIds);

    /***
     * 删除PmsAttrAttrgroupRelation
     * @param id
     */
    void delete(Long id);

    /**
     * 删除 属性分组下的属性
     * @param ids 属性(多选)
     * @param attrGroupId 属性分组ID
     */
    void deleteByGroupIdAndAttrIds(List<Long> ids, Long attrGroupId);

    /***
     * 修改PmsAttrAttrgroupRelation数据
     * @param pmsAttrAttrgroupRelation
     */
    void update(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /***
     * 新增PmsAttrAttrgroupRelation
     * @param pmsAttrAttrgroupRelation
     */
    void add(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 新增PmsAttrAttrgroupRelation
     * @param attrGroupId 属性分组ID
     * @param attrIds 属性ID
     */
    void addAsList(Long attrGroupId, List<Long> attrIds);


    /**
     * 根据ID查询PmsAttrAttrgroupRelation
     * @param id
     * @return
     */
     PmsAttrAttrgroupRelation findById(Long id);

    /***
     * 查询所有PmsAttrAttrgroupRelation
     * @return
     */
    List<PmsAttrAttrgroupRelation> findAll();

    /**
     * 根据 属性分组的AttrGroupID 查询该分组下的 所有属性
     *
     * @param attrGroupId 属性分组ID
     * @param attrName
     * @param page        页码
     * @param size        每页数据数
     * @return /
     */
    List<PmsAttr> getRelatedAttr(Long attrGroupId, String attrName, int page, int size);

    /**
     * 根据 属性分组的AttrGroupID 查询该分组下的 所有属性 的数量
     * @param attrGroupId 属性分组ID
     * @return /
     */
    int relatedAttrCount(Long attrGroupId);

}
