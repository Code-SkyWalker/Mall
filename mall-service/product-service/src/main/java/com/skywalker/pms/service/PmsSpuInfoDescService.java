package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsSpuInfoDesc;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoDescService
 * @Description TODO
 */
public interface PmsSpuInfoDescService {

    /***
     * PmsSpuInfoDesc多条件分页查询
     * @param pmsSpuInfoDesc
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSpuInfoDesc> findPage(PmsSpuInfoDesc pmsSpuInfoDesc, int page, int size);

    /***
     * PmsSpuInfoDesc分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSpuInfoDesc> findPage(int page, int size);

    /***
     * PmsSpuInfoDesc多条件搜索方法
     * @param pmsSpuInfoDesc
     * @return
     */
    List<PmsSpuInfoDesc> findList(PmsSpuInfoDesc pmsSpuInfoDesc);

    /***
     * 删除PmsSpuInfoDesc
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsSpuInfoDesc数据
     * @param pmsSpuInfoDesc
     */
    void update(PmsSpuInfoDesc pmsSpuInfoDesc);

    /***
     * 新增PmsSpuInfoDesc
     * @param pmsSpuInfoDesc
     */
    void add(PmsSpuInfoDesc pmsSpuInfoDesc);

    /**
     * 根据ID查询PmsSpuInfoDesc
     * @param id
     * @return
     */
     PmsSpuInfoDesc findById(Long id);

    /***
     * 查询所有PmsSpuInfoDesc
     * @return
     */
    List<PmsSpuInfoDesc> findAll();
}
