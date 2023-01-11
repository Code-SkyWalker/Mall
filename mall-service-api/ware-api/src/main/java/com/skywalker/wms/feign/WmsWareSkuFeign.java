package com.skywalker.wms.feign;

import com.skywalker.entity.Result;
import com.skywalker.wms.pojo.WmsWareSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareSkuFeign
 * @Description TODO
 */
@FeignClient(name="ware-service", contextId = "wmsWareSku", path = "/wareSku")
public interface WmsWareSkuFeign {

    /***
     * WmsWareSku分页条件搜索实现
     * @param wmsWareSku
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) WmsWareSku wmsWareSku, @PathVariable int page, @PathVariable int size);

    /***
     * WmsWareSku分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param skuIds skuIds
     * @return
     */
    @PostMapping(value = "/hasStock")
    Result getSkuHasStock(@RequestBody List<Long> skuIds);

    /**
     * 查询 sku库存
     * @param SkuId skuId
     * @return Result
     */
    @PostMapping("/{skuId}")
    Result findOneBySkuId(@PathVariable(name = "skuId") Long SkuId);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改WmsWareSku数据
     * @param wmsWareSku
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody WmsWareSku wmsWareSku,@PathVariable Long id);

    /***
     * 新增WmsWareSku数据
     * @param wmsWareSku
     * @return
     */
    @PostMapping
    Result add(@RequestBody WmsWareSku wmsWareSku);

    /***
     * 根据ID查询WmsWareSku数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询WmsWareSku全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}