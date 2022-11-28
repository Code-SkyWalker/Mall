package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsAttr;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsAttrService
 * @Description TODO
 */
public interface PmsAttrService {

    /***
     * PmsAttr多条件分页查询
     * @param pmsAttr
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsAttr> findPage(PmsAttr pmsAttr, int page, int size);

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
}
