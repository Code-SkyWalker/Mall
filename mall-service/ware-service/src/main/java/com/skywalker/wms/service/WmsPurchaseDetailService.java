package com.skywalker.wms.service;
import com.skywalker.wms.pojo.WmsPurchaseDetail;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseDetailService
 * @Description TODO
 */
public interface WmsPurchaseDetailService {

    /***
     * WmsPurchaseDetail多条件分页查询
     * @param wmsPurchaseDetail
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsPurchaseDetail> findPage(WmsPurchaseDetail wmsPurchaseDetail, int page, int size);

    /***
     * WmsPurchaseDetail分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsPurchaseDetail> findPage(int page, int size);

    /***
     * WmsPurchaseDetail多条件搜索方法
     * @param wmsPurchaseDetail
     * @return
     */
    List<WmsPurchaseDetail> findList(WmsPurchaseDetail wmsPurchaseDetail);

    /***
     * 删除WmsPurchaseDetail
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WmsPurchaseDetail数据
     * @param wmsPurchaseDetail
     */
    void update(WmsPurchaseDetail wmsPurchaseDetail);

    /***
     * 新增WmsPurchaseDetail
     * @param wmsPurchaseDetail
     */
    void add(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 根据ID查询WmsPurchaseDetail
     * @param id
     * @return
     */
     WmsPurchaseDetail findById(Long id);

    /***
     * 查询所有WmsPurchaseDetail
     * @return
     */
    List<WmsPurchaseDetail> findAll();

    /**
     * 根据 采购ID 查询 PurchaseDetail
     * @param purchaseIds 采购ID
     * @return /
     */
    void updateStatusByPurchaseIds(List<Long> purchaseIds, WmsPurchaseDetail wmsPurchaseDetail);
}
