package com.skywalker.wms.service;
import com.skywalker.wms.pojo.WmsWareOrderTaskDetail;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskDetailService
 * @Description TODO
 */
public interface WmsWareOrderTaskDetailService {

    /***
     * WmsWareOrderTaskDetail多条件分页查询
     * @param wmsWareOrderTaskDetail
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsWareOrderTaskDetail> findPage(WmsWareOrderTaskDetail wmsWareOrderTaskDetail, int page, int size);

    /***
     * WmsWareOrderTaskDetail分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsWareOrderTaskDetail> findPage(int page, int size);

    /***
     * WmsWareOrderTaskDetail多条件搜索方法
     * @param wmsWareOrderTaskDetail
     * @return
     */
    List<WmsWareOrderTaskDetail> findList(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /***
     * 删除WmsWareOrderTaskDetail
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WmsWareOrderTaskDetail数据
     * @param wmsWareOrderTaskDetail
     */
    void update(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /***
     * 新增WmsWareOrderTaskDetail
     * @param wmsWareOrderTaskDetail
     */
    void add(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 根据ID查询WmsWareOrderTaskDetail
     * @param id
     * @return
     */
     WmsWareOrderTaskDetail findById(Long id);

    /***
     * 查询所有WmsWareOrderTaskDetail
     * @return
     */
    List<WmsWareOrderTaskDetail> findAll();
}
