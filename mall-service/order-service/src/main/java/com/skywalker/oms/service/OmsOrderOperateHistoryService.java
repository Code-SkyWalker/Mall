package com.skywalker.oms.service;

import com.github.pagehelper.PageInfo;
import com.skywalker.oms.pojo.OmsOrderOperateHistory;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderOperateHistoryService
 * @Description TODO
 */
public interface OmsOrderOperateHistoryService {

    /***
     * OmsOrderOperateHistory多条件分页查询
     * @param omsOrderOperateHistory
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderOperateHistory> findPage(OmsOrderOperateHistory omsOrderOperateHistory, int page, int size);

    /***
     * OmsOrderOperateHistory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderOperateHistory> findPage(int page, int size);

    /***
     * OmsOrderOperateHistory多条件搜索方法
     * @param omsOrderOperateHistory
     * @return
     */
    List<OmsOrderOperateHistory> findList(OmsOrderOperateHistory omsOrderOperateHistory);

    /***
     * 删除OmsOrderOperateHistory
     * @param id
     */
    void delete(Long id);

    /***
     * 修改OmsOrderOperateHistory数据
     * @param omsOrderOperateHistory
     */
    void update(OmsOrderOperateHistory omsOrderOperateHistory);

    /***
     * 新增OmsOrderOperateHistory
     * @param omsOrderOperateHistory
     */
    void add(OmsOrderOperateHistory omsOrderOperateHistory);

    /**
     * 根据ID查询OmsOrderOperateHistory
     * @param id
     * @return
     */
     OmsOrderOperateHistory findById(Long id);

    /***
     * 查询所有OmsOrderOperateHistory
     * @return
     */
    List<OmsOrderOperateHistory> findAll();
}
