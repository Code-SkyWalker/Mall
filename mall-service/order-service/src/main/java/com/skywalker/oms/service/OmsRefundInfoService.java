package com.skywalker.oms.service;

import com.github.pagehelper.PageInfo;
import com.skywalker.oms.pojo.OmsRefundInfo;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsRefundInfoService
 * @Description TODO
 */
public interface OmsRefundInfoService {

    /***
     * OmsRefundInfo多条件分页查询
     * @param omsRefundInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsRefundInfo> findPage(OmsRefundInfo omsRefundInfo, int page, int size);

    /***
     * OmsRefundInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsRefundInfo> findPage(int page, int size);

    /***
     * OmsRefundInfo多条件搜索方法
     * @param omsRefundInfo
     * @return
     */
    List<OmsRefundInfo> findList(OmsRefundInfo omsRefundInfo);

    /***
     * 删除OmsRefundInfo
     * @param id
     */
    void delete(Long id);

    /***
     * 修改OmsRefundInfo数据
     * @param omsRefundInfo
     */
    void update(OmsRefundInfo omsRefundInfo);

    /***
     * 新增OmsRefundInfo
     * @param omsRefundInfo
     */
    void add(OmsRefundInfo omsRefundInfo);

    /**
     * 根据ID查询OmsRefundInfo
     * @param id
     * @return
     */
     OmsRefundInfo findById(Long id);

    /***
     * 查询所有OmsRefundInfo
     * @return
     */
    List<OmsRefundInfo> findAll();
}
