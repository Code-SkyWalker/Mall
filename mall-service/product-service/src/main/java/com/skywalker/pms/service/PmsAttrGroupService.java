package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsAttrGroup;
import com.github.pagehelper.PageInfo;
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
     * @param pmsAttrGroup
     * @return
     */
    List<PmsAttrGroup> findList(PmsAttrGroup pmsAttrGroup);

    /***
     * 删除PmsAttrGroup
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsAttrGroup数据
     * @param pmsAttrGroup
     */
    void update(PmsAttrGroup pmsAttrGroup);

    /***
     * 新增PmsAttrGroup
     * @param pmsAttrGroup
     */
    void add(PmsAttrGroup pmsAttrGroup);

    /**
     * 根据ID查询PmsAttrGroup
     * @param id
     * @return
     */
     PmsAttrGroup findById(Long id);

    /***
     * 查询所有PmsAttrGroup
     * @return
     */
    List<PmsAttrGroup> findAll();
}