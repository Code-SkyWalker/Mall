package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsHomeAdv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsHomeAdvFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsHomeAdv", path = "/smsHomeAdv")
public interface SmsHomeAdvFeign {

    /***
     * SmsHomeAdv分页条件搜索实现
     * @param smsHomeAdv
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsHomeAdv smsHomeAdv, @PathVariable int page, @PathVariable int size);

    /***
     * SmsHomeAdv分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsHomeAdv
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsHomeAdv smsHomeAdv);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsHomeAdv数据
     * @param smsHomeAdv
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsHomeAdv smsHomeAdv,@PathVariable Long id);

    /***
     * 新增SmsHomeAdv数据
     * @param smsHomeAdv
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsHomeAdv smsHomeAdv);

    /***
     * 根据ID查询SmsHomeAdv数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsHomeAdv全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}