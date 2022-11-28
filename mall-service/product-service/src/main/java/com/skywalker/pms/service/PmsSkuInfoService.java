package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsSkuInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSkuInfoService
 * @Description TODO
 */
public interface PmsSkuInfoService {

    /***
     * PmsSkuInfo多条件分页查询
     * @param pmsSkuInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSkuInfo> findPage(PmsSkuInfo pmsSkuInfo, int page, int size);

    /***
     * PmsSkuInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSkuInfo> findPage(int page, int size);

    /***
     * PmsSkuInfo多条件搜索方法
     * @param pmsSkuInfo
     * @return
     */
    List<PmsSkuInfo> findList(PmsSkuInfo pmsSkuInfo);

    /***
     * 删除PmsSkuInfo
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsSkuInfo数据
     * @param pmsSkuInfo
     */
    void update(PmsSkuInfo pmsSkuInfo);

    /***
     * 新增PmsSkuInfo
     * @param pmsSkuInfo
     */
    void add(PmsSkuInfo pmsSkuInfo);

    /**
     * 根据ID查询PmsSkuInfo
     * @param id
     * @return
     */
     PmsSkuInfo findById(Long id);

    /***
     * 查询所有PmsSkuInfo
     * @return
     */
    List<PmsSkuInfo> findAll();
}
