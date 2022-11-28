package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsSpuImages;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuImagesService
 * @Description TODO
 */
public interface PmsSpuImagesService {

    /***
     * PmsSpuImages多条件分页查询
     * @param pmsSpuImages
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSpuImages> findPage(PmsSpuImages pmsSpuImages, int page, int size);

    /***
     * PmsSpuImages分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSpuImages> findPage(int page, int size);

    /***
     * PmsSpuImages多条件搜索方法
     * @param pmsSpuImages
     * @return
     */
    List<PmsSpuImages> findList(PmsSpuImages pmsSpuImages);

    /***
     * 删除PmsSpuImages
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsSpuImages数据
     * @param pmsSpuImages
     */
    void update(PmsSpuImages pmsSpuImages);

    /***
     * 新增PmsSpuImages
     * @param pmsSpuImages
     */
    void add(PmsSpuImages pmsSpuImages);

    /**
     * 根据ID查询PmsSpuImages
     * @param id
     * @return
     */
     PmsSpuImages findById(Long id);

    /***
     * 查询所有PmsSpuImages
     * @return
     */
    List<PmsSpuImages> findAll();
}
