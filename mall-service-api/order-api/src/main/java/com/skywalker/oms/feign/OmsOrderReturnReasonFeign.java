package com.skywalker.oms.feign;

import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderReturnReason;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnReasonFeign
 * @Description TODO
 */
@FeignClient(name="oms", contextId = "omsOrderReturnReason", path = "/omsOrderReturnReason")
public interface OmsOrderReturnReasonFeign {

    /***
     * OmsOrderReturnReason分页条件搜索实现
     * @param omsOrderReturnReason
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) OmsOrderReturnReason omsOrderReturnReason, @PathVariable int page, @PathVariable int size);

    /***
     * OmsOrderReturnReason分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param omsOrderReturnReason
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) OmsOrderReturnReason omsOrderReturnReason);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改OmsOrderReturnReason数据
     * @param omsOrderReturnReason
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OmsOrderReturnReason omsOrderReturnReason,@PathVariable Long id);

    /***
     * 新增OmsOrderReturnReason数据
     * @param omsOrderReturnReason
     * @return
     */
    @PostMapping
    Result add(@RequestBody OmsOrderReturnReason omsOrderReturnReason);

    /***
     * 根据ID查询OmsOrderReturnReason数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询OmsOrderReturnReason全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}