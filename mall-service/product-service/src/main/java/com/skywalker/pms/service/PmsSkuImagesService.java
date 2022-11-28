package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsSkuImages;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSkuImagesService
 * @Description TODO
 */
public interface PmsSkuImagesService {

    /***
     * PmsSkuImages多条件分页查询
     * @param pmsSkuImages
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSkuImages> findPage(PmsSkuImages pmsSkuImages, int page, int size);

    /***
     * PmsSkuImages分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSkuImages> findPage(int page, int size);

    /***
     * PmsSkuImages多条件搜索方法
     * @param pmsSkuImages
     * @return
     */
    List<PmsSkuImages> findList(PmsSkuImages pmsSkuImages);

    /***
     * 删除PmsSkuImages
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsSkuImages数据
     * @param pmsSkuImages
     */
    void update(PmsSkuImages pmsSkuImages);

    /***
     * 新增PmsSkuImages
     * @param pmsSkuImages
     */
    void add(PmsSkuImages pmsSkuImages);

    /**
     * 根据ID查询PmsSkuImages
     * @param id
     * @return
     */
     PmsSkuImages findById(Long id);

    /***
     * 查询所有PmsSkuImages
     * @return
     */
    List<PmsSkuImages> findAll();
}
