package com.skywalker.wms.service;
import com.skywalker.wms.pojo.WmsWareInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsWareInfoService
 * @Description TODO
 */
public interface WmsWareInfoService {

    /***
     * WmsWareInfo多条件分页查询
     * @param wmsWareInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsWareInfo> findPage(WmsWareInfo wmsWareInfo, int page, int size);

    /***
     * WmsWareInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsWareInfo> findPage(int page, int size);

    /***
     * WmsWareInfo多条件搜索方法
     * @param wmsWareInfo
     * @return
     */
    List<WmsWareInfo> findList(WmsWareInfo wmsWareInfo);

    /***
     * 删除WmsWareInfo
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WmsWareInfo数据
     * @param wmsWareInfo
     */
    void update(WmsWareInfo wmsWareInfo);

    /***
     * 新增WmsWareInfo
     * @param wmsWareInfo
     */
    void add(WmsWareInfo wmsWareInfo);

    /**
     * 根据ID查询WmsWareInfo
     * @param id
     * @return
     */
     WmsWareInfo findById(Long id);

    /***
     * 查询所有WmsWareInfo
     * @return
     */
    List<WmsWareInfo> findAll();
}
