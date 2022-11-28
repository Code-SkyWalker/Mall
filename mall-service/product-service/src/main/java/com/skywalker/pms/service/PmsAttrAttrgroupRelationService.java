package com.skywalker.pms.service;
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

    /***
     * 删除PmsAttrAttrgroupRelation
     * @param id
     */
    void delete(Long id);

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
}
