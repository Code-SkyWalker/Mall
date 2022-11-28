package com.skywalker.oms.service;

import com.github.pagehelper.PageInfo;
import com.skywalker.oms.pojo.OmsOrderItem;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderItemService
 * @Description TODO
 */
public interface OmsOrderItemService {

    /***
     * OmsOrderItem多条件分页查询
     * @param omsOrderItem
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderItem> findPage(OmsOrderItem omsOrderItem, int page, int size);

    /***
     * OmsOrderItem分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderItem> findPage(int page, int size);

    /***
     * OmsOrderItem多条件搜索方法
     * @param omsOrderItem
     * @return
     */
    List<OmsOrderItem> findList(OmsOrderItem omsOrderItem);

    /***
     * 删除OmsOrderItem
     * @param id
     */
    void delete(Long id);

    /***
     * 修改OmsOrderItem数据
     * @param omsOrderItem
     */
    void update(OmsOrderItem omsOrderItem);

    /***
     * 新增OmsOrderItem
     * @param omsOrderItem
     */
    void add(OmsOrderItem omsOrderItem);

    /**
     * 根据ID查询OmsOrderItem
     * @param id
     * @return
     */
     OmsOrderItem findById(Long id);

    /***
     * 查询所有OmsOrderItem
     * @return
     */
    List<OmsOrderItem> findAll();
}
