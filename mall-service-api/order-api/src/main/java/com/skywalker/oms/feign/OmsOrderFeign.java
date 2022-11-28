package com.skywalker.oms.feign;

import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderFeign
 * @Description TODO
 */
@FeignClient(name="oms", contextId = "omsOrder", path = "/omsOrder")
public interface OmsOrderFeign {

    /***
     * OmsOrder分页条件搜索实现
     * @param omsOrder
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) OmsOrder omsOrder, @PathVariable int page, @PathVariable int size);

    /***
     * OmsOrder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param omsOrder
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) OmsOrder omsOrder);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改OmsOrder数据
     * @param omsOrder
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OmsOrder omsOrder,@PathVariable Long id);

    /***
     * 新增OmsOrder数据
     * @param omsOrder
     * @return
     */
    @PostMapping
    Result add(@RequestBody OmsOrder omsOrder);

    /***
     * 根据ID查询OmsOrder数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询OmsOrder全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}