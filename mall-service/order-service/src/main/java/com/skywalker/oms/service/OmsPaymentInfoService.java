package com.skywalker.oms.service;

import com.github.pagehelper.PageInfo;
import com.skywalker.oms.pojo.OmsPaymentInfo;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsPaymentInfoService
 * @Description TODO
 */
public interface OmsPaymentInfoService {

    /***
     * OmsPaymentInfo多条件分页查询
     * @param omsPaymentInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsPaymentInfo> findPage(OmsPaymentInfo omsPaymentInfo, int page, int size);

    /***
     * OmsPaymentInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsPaymentInfo> findPage(int page, int size);

    /***
     * OmsPaymentInfo多条件搜索方法
     * @param omsPaymentInfo
     * @return
     */
    List<OmsPaymentInfo> findList(OmsPaymentInfo omsPaymentInfo);

    /***
     * 删除OmsPaymentInfo
     * @param id
     */
    void delete(Long id);

    /***
     * 修改OmsPaymentInfo数据
     * @param omsPaymentInfo
     */
    void update(OmsPaymentInfo omsPaymentInfo);

    /***
     * 新增OmsPaymentInfo
     * @param omsPaymentInfo
     */
    void add(OmsPaymentInfo omsPaymentInfo);

    /**
     * 根据ID查询OmsPaymentInfo
     * @param id
     * @return
     */
     OmsPaymentInfo findById(Long id);

    /***
     * 查询所有OmsPaymentInfo
     * @return
     */
    List<OmsPaymentInfo> findAll();
}
