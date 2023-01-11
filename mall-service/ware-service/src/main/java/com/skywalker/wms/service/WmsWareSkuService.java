package com.skywalker.wms.service;
import com.skywalker.entity.Result;
import com.skywalker.wms.pojo.WmsWareSku;
import com.github.pagehelper.PageInfo;
import com.skywalker.wms.vo.HasStockVo;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsWareSkuService
 * @Description TODO
 */
public interface WmsWareSkuService {

    /***
     * WmsWareSku多条件分页查询
     * @param wmsWareSku
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsWareSku> findPage(WmsWareSku wmsWareSku, int page, int size);

    /***
     * WmsWareSku分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsWareSku> findPage(int page, int size);

    /***
     * WmsWareSku多条件搜索方法
     * @param wmsWareSku
     * @return
     */
    List<WmsWareSku> findList(WmsWareSku wmsWareSku);

    /***
     * 删除WmsWareSku
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WmsWareSku数据
     * @param wmsWareSku
     */
    void update(WmsWareSku wmsWareSku);

    /***
     * 新增WmsWareSku
     * @param wmsWareSku
     */
    void add(WmsWareSku wmsWareSku);

    /**
     * 根据ID查询WmsWareSku
     * @param id
     * @return
     */
     WmsWareSku findById(Long id);

    /***
     * 查询所有WmsWareSku
     * @return
     */
    List<WmsWareSku> findAll();

    /**
     * sku库存添加库存数量
     * @param wareId 仓库Id
     * @param skuId skuId
     * @param Stock 增加的库存数量
     */
    void addStock(Long wareId, Long skuId, Integer Stock);

    /**
     * sku 查询 ware_sku 是否存在sku
     * @param wareId wareId
     * @param skuId skuId
     * @return /
     */
    WmsWareSku findBySkuIdAndWareId(Long wareId, Long skuId);

    /**
     * 查询库存
     * @param skuIds List<skuIds>
     * @return wmsWareSku
     */
    List<HasStockVo> getSkuHasStock(List<Long> skuIds);
}
