package com.skywalker.oms.service;

import com.github.pagehelper.PageInfo;
import com.skywalker.oms.pojo.OmsOrder;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderService
 * @Description TODO
 */
public interface OmsOrderService {

    /***
     * OmsOrder多条件分页查询
     * @param omsOrder
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrder> findPage(OmsOrder omsOrder, int page, int size);

    /***
     * OmsOrder分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrder> findPage(int page, int size);

    /***
     * OmsOrder多条件搜索方法
     * @param omsOrder
     * @return
     */
    List<OmsOrder> findList(OmsOrder omsOrder);

    /***
     * 删除OmsOrder
     * @param id
     */
    void delete(Long id);

    /***
     * 修改OmsOrder数据
     * @param omsOrder
     */
    void update(OmsOrder omsOrder);

    /***
     * 新增OmsOrder
     * @param omsOrder
     */
    void add(OmsOrder omsOrder);

    /**
     * 根据ID查询OmsOrder
     * @param id
     * @return
     */
     OmsOrder findById(Long id);

    /***
     * 查询所有OmsOrder
     * @return
     */
    List<OmsOrder> findAll();
}
