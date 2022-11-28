package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsSpuInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoService
 * @Description TODO
 */
public interface PmsSpuInfoService {

    /***
     * PmsSpuInfo多条件分页查询
     * @param pmsSpuInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSpuInfo> findPage(PmsSpuInfo pmsSpuInfo, int page, int size);

    /***
     * PmsSpuInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSpuInfo> findPage(int page, int size);

    /***
     * PmsSpuInfo多条件搜索方法
     * @param pmsSpuInfo
     * @return
     */
    List<PmsSpuInfo> findList(PmsSpuInfo pmsSpuInfo);

    /***
     * 删除PmsSpuInfo
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsSpuInfo数据
     * @param pmsSpuInfo
     */
    void update(PmsSpuInfo pmsSpuInfo);

    /***
     * 新增PmsSpuInfo
     * @param pmsSpuInfo
     */
    void add(PmsSpuInfo pmsSpuInfo);

    /**
     * 根据ID查询PmsSpuInfo
     * @param id
     * @return
     */
     PmsSpuInfo findById(Long id);

    /***
     * 查询所有PmsSpuInfo
     * @return
     */
    List<PmsSpuInfo> findAll();
}
