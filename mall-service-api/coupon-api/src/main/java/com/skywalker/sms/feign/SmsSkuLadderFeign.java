package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsSkuLadder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsSkuLadderFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsSkuLadder", path = "/smsSkuLadder")
public interface SmsSkuLadderFeign {

    /***
     * SmsSkuLadder分页条件搜索实现
     * @param smsSkuLadder
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsSkuLadder smsSkuLadder, @PathVariable int page, @PathVariable int size);

    /***
     * SmsSkuLadder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsSkuLadder
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsSkuLadder smsSkuLadder);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsSkuLadder数据
     * @param smsSkuLadder
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsSkuLadder smsSkuLadder,@PathVariable Long id);

    /***
     * 新增SmsSkuLadder数据
     * @param smsSkuLadder
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsSkuLadder smsSkuLadder);

    /***
     * 根据ID查询SmsSkuLadder数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsSkuLadder全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}