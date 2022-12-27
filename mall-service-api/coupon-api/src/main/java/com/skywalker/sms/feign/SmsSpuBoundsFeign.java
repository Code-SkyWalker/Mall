package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsSpuBounds;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsSpuBoundsFeign
 * @Description TODO
 */
@FeignClient(name="conpon-service", contextId = "smsSpuBounds", path = "/spuBounds")
public interface SmsSpuBoundsFeign {

    /***
     * SmsSpuBounds分页条件搜索实现
     * @param smsSpuBounds
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsSpuBounds smsSpuBounds, @PathVariable int page, @PathVariable int size);

    /***
     * SmsSpuBounds分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsSpuBounds
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsSpuBounds smsSpuBounds);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsSpuBounds数据
     * @param smsSpuBounds
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsSpuBounds smsSpuBounds,@PathVariable Long id);

    /***
     * 新增SmsSpuBounds数据
     * @param smsSpuBounds
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsSpuBounds smsSpuBounds);

    /***
     * 根据ID查询SmsSpuBounds数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsSpuBounds全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}