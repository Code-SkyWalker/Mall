package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsBrand;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsBrandService
 * @Description TODO
 */
public interface PmsBrandService {

    /***
     * PmsBrand多条件分页查询
     * @param pmsBrand
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsBrand> findPage(PmsBrand pmsBrand, int page, int size);

    /***
     * PmsBrand分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsBrand> findPage(int page, int size);

    /***
     * PmsBrand多条件搜索方法
     * @param pmsBrand
     * @return
     */
    List<PmsBrand> findList(PmsBrand pmsBrand);

    /***
     * 删除PmsBrand
     * @param id
     */
    void delete(Long id);

    /***
     * 批量删除PmsBrand
     * @param ids
     */
    void deleteByIds(List<Long> ids);


    /***
     * 修改PmsBrand数据
     * @param pmsBrand
     */
    void update(PmsBrand pmsBrand);

    /***
     * 新增PmsBrand
     * @param pmsBrand
     */
    void add(PmsBrand pmsBrand);

    /**
     * 根据ID查询PmsBrand
     * @param id
     * @return
     */
     PmsBrand findById(Long id);

    /***
     * 查询所有PmsBrand
     * @return
     */
    List<PmsBrand> findAll();

    /**
     * 根据 categoryID 查询 品牌
     *
     * @param categoryId
     * @param page
     * @param size
     * @return
     */
    List<PmsBrand> findBrandByCategoryId(Long categoryId, int page, int size);

    /**
     * 根据 categoryID 查询 品牌 获取总数
     *
     * @param categoryId
     * @return /
     */
    int findBrandByCategoryIdCount(Long categoryId);
}
