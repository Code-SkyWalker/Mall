package com.skywalker.oms.feign;

import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderOperateHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderOperateHistoryFeign
 * @Description TODO
 */
@FeignClient(name="oms", contextId = "omsOrderOperateHistory", path = "/omsOrderOperateHistory")
public interface OmsOrderOperateHistoryFeign {

    /***
     * OmsOrderOperateHistory分页条件搜索实现
     * @param omsOrderOperateHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) OmsOrderOperateHistory omsOrderOperateHistory, @PathVariable int page, @PathVariable int size);

    /***
     * OmsOrderOperateHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param omsOrderOperateHistory
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) OmsOrderOperateHistory omsOrderOperateHistory);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改OmsOrderOperateHistory数据
     * @param omsOrderOperateHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OmsOrderOperateHistory omsOrderOperateHistory,@PathVariable Long id);

    /***
     * 新增OmsOrderOperateHistory数据
     * @param omsOrderOperateHistory
     * @return
     */
    @PostMapping
    Result add(@RequestBody OmsOrderOperateHistory omsOrderOperateHistory);

    /***
     * 根据ID查询OmsOrderOperateHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询OmsOrderOperateHistory全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}