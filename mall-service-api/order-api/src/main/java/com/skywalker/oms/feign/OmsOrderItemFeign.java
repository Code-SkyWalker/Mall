package com.skywalker.oms.feign;

import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderItemFeign
 * @Description TODO
 */
@FeignClient(name="oms", contextId = "omsOrderItem", path = "/omsOrderItem")
public interface OmsOrderItemFeign {

    /***
     * OmsOrderItem分页条件搜索实现
     * @param omsOrderItem
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) OmsOrderItem omsOrderItem, @PathVariable int page, @PathVariable int size);

    /***
     * OmsOrderItem分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param omsOrderItem
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) OmsOrderItem omsOrderItem);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改OmsOrderItem数据
     * @param omsOrderItem
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OmsOrderItem omsOrderItem,@PathVariable Long id);

    /***
     * 新增OmsOrderItem数据
     * @param omsOrderItem
     * @return
     */
    @PostMapping
    Result add(@RequestBody OmsOrderItem omsOrderItem);

    /***
     * 根据ID查询OmsOrderItem数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询OmsOrderItem全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}