package com.skywalker.wms.feign;

import com.skywalker.entity.Result;
import com.skywalker.wms.pojo.WmsPurchase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseFeign
 * @Description TODO
 */
@FeignClient(name="wms", contextId = "wmsPurchase", path = "/wmsPurchase")
public interface WmsPurchaseFeign {

    /***
     * WmsPurchase分页条件搜索实现
     * @param wmsPurchase
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) WmsPurchase wmsPurchase, @PathVariable int page, @PathVariable int size);

    /***
     * WmsPurchase分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param wmsPurchase
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) WmsPurchase wmsPurchase);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改WmsPurchase数据
     * @param wmsPurchase
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody WmsPurchase wmsPurchase,@PathVariable Long id);

    /***
     * 新增WmsPurchase数据
     * @param wmsPurchase
     * @return
     */
    @PostMapping
    Result add(@RequestBody WmsPurchase wmsPurchase);

    /***
     * 根据ID查询WmsPurchase数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询WmsPurchase全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}