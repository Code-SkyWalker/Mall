package com.skywalker.wms.feign;

import com.skywalker.entity.Result;
import com.skywalker.wms.pojo.WmsPurchaseDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseDetailFeign
 * @Description TODO
 */
@FeignClient(name="wms", contextId = "wmsPurchaseDetail", path = "/wmsPurchaseDetail")
public interface WmsPurchaseDetailFeign {

    /***
     * WmsPurchaseDetail分页条件搜索实现
     * @param wmsPurchaseDetail
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) WmsPurchaseDetail wmsPurchaseDetail, @PathVariable int page, @PathVariable int size);

    /***
     * WmsPurchaseDetail分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param wmsPurchaseDetail
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) WmsPurchaseDetail wmsPurchaseDetail);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改WmsPurchaseDetail数据
     * @param wmsPurchaseDetail
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody WmsPurchaseDetail wmsPurchaseDetail,@PathVariable Long id);

    /***
     * 新增WmsPurchaseDetail数据
     * @param wmsPurchaseDetail
     * @return
     */
    @PostMapping
    Result add(@RequestBody WmsPurchaseDetail wmsPurchaseDetail);

    /***
     * 根据ID查询WmsPurchaseDetail数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询WmsPurchaseDetail全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}