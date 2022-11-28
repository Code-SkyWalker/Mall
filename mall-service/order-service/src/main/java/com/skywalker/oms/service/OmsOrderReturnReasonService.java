package com.skywalker.oms.service;

import com.github.pagehelper.PageInfo;
import com.skywalker.oms.pojo.OmsOrderReturnReason;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnReasonService
 * @Description TODO
 */
public interface OmsOrderReturnReasonService {

    /***
     * OmsOrderReturnReason多条件分页查询
     * @param omsOrderReturnReason
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderReturnReason> findPage(OmsOrderReturnReason omsOrderReturnReason, int page, int size);

    /***
     * OmsOrderReturnReason分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderReturnReason> findPage(int page, int size);

    /***
     * OmsOrderReturnReason多条件搜索方法
     * @param omsOrderReturnReason
     * @return
     */
    List<OmsOrderReturnReason> findList(OmsOrderReturnReason omsOrderReturnReason);

    /***
     * 删除OmsOrderReturnReason
     * @param id
     */
    void delete(Long id);

    /***
     * 修改OmsOrderReturnReason数据
     * @param omsOrderReturnReason
     */
    void update(OmsOrderReturnReason omsOrderReturnReason);

    /***
     * 新增OmsOrderReturnReason
     * @param omsOrderReturnReason
     */
    void add(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 根据ID查询OmsOrderReturnReason
     * @param id
     * @return
     */
     OmsOrderReturnReason findById(Long id);

    /***
     * 查询所有OmsOrderReturnReason
     * @return
     */
    List<OmsOrderReturnReason> findAll();
}
