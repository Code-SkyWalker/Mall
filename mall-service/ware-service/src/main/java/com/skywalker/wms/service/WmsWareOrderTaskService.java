package com.skywalker.wms.service;
import com.skywalker.wms.pojo.WmsWareOrderTask;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskService
 * @Description TODO
 */
public interface WmsWareOrderTaskService {

    /***
     * WmsWareOrderTask多条件分页查询
     * @param wmsWareOrderTask
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsWareOrderTask> findPage(WmsWareOrderTask wmsWareOrderTask, int page, int size);

    /***
     * WmsWareOrderTask分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsWareOrderTask> findPage(int page, int size);

    /***
     * WmsWareOrderTask多条件搜索方法
     * @param wmsWareOrderTask
     * @return
     */
    List<WmsWareOrderTask> findList(WmsWareOrderTask wmsWareOrderTask);

    /***
     * 删除WmsWareOrderTask
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WmsWareOrderTask数据
     * @param wmsWareOrderTask
     */
    void update(WmsWareOrderTask wmsWareOrderTask);

    /***
     * 新增WmsWareOrderTask
     * @param wmsWareOrderTask
     */
    void add(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 根据ID查询WmsWareOrderTask
     * @param id
     * @return
     */
     WmsWareOrderTask findById(Long id);

    /***
     * 查询所有WmsWareOrderTask
     * @return
     */
    List<WmsWareOrderTask> findAll();
}
