package com.skywalker.wms.service;
import com.skywalker.wms.pojo.WmsPurchase;
import com.github.pagehelper.PageInfo;
import com.skywalker.wms.vo.WarePurchaseDoneVo;
import com.skywalker.wms.vo.WarePurchaseMergeVo;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseService
 * @Description TODO
 */
public interface WmsPurchaseService {

    /***
     * WmsPurchase多条件分页查询
     * @param wmsPurchase
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsPurchase> findPage(WmsPurchase wmsPurchase, int page, int size);

    /***
     * WmsPurchase分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsPurchase> findPage(int page, int size);

    /***
     * WmsPurchase多条件搜索方法
     * @param wmsPurchase
     * @return
     */
    List<WmsPurchase> findList(WmsPurchase wmsPurchase);

    /***
     * 删除WmsPurchase
     * @param id
     */
    void delete(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /***
     * 修改WmsPurchase数据
     * @param wmsPurchase
     */
    void update(WmsPurchase wmsPurchase);

    /***
     * 新增WmsPurchase
     * @param wmsPurchase
     */
    void add(WmsPurchase wmsPurchase);

    /**
     * 根据ID查询WmsPurchase
     * @param id
     * @return /
     */
     WmsPurchase findById(Long id);

    /***
     * 查询所有WmsPurchase
     * @return /
     */
    List<WmsPurchase> findAll();

    /**
     * 查询还未采购(新建, 已分配)状态下的 采购单
     * @return /
     */
    List<WmsPurchase> findPerchaseUnrecevied();

    /**
     * 合并采购单
     * @param warePurchaseMergeVo 采购单vo
     */
    void marge(WarePurchaseMergeVo warePurchaseMergeVo) throws Exception;

    /**
     * 采购员领取采购单
     * @param purchaseIds 采购单ID
     */
    void receive(List<Long> purchaseIds) throws Exception;

    /**
     * 批量查询
     * @param purchaseIds List<purchase>
     * @return /
     */
    List<WmsPurchase> findPurchaseByIds(List<Long> purchaseIds);

    /**
     * 采购完成
     * @param warePurchaseDoneVo /
     */
    void done(WarePurchaseDoneVo warePurchaseDoneVo);
}
