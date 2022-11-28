package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsCategory;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryService
 * @Description TODO
 */
public interface PmsCategoryService {

    /***
     * PmsCategory多条件分页查询
     * @param pmsCategory
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsCategory> findPage(PmsCategory pmsCategory, int page, int size);

    /***
     * PmsCategory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsCategory> findPage(int page, int size);

    /***
     * PmsCategory多条件搜索方法
     * @param pmsCategory
     * @return
     */
    List<PmsCategory> findList(PmsCategory pmsCategory);

    /***
     * 删除PmsCategory
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsCategory数据
     * @param pmsCategory
     */
    void update(PmsCategory pmsCategory);

    /***
     * 新增PmsCategory
     * @param pmsCategory
     */
    void add(PmsCategory pmsCategory);

    /**
     * 根据ID查询PmsCategory
     * @param id
     * @return
     */
     PmsCategory findById(Long id);

    /***
     * 查询所有PmsCategory
     * @return
     */
    List<PmsCategory> findAll();
}
