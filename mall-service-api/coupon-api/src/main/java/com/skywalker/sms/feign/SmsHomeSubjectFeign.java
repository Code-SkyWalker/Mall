package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsHomeSubject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsHomeSubject", path = "/smsHomeSubject")
public interface SmsHomeSubjectFeign {

    /***
     * SmsHomeSubject分页条件搜索实现
     * @param smsHomeSubject
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsHomeSubject smsHomeSubject, @PathVariable int page, @PathVariable int size);

    /***
     * SmsHomeSubject分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsHomeSubject
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsHomeSubject smsHomeSubject);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsHomeSubject数据
     * @param smsHomeSubject
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsHomeSubject smsHomeSubject,@PathVariable Long id);

    /***
     * 新增SmsHomeSubject数据
     * @param smsHomeSubject
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsHomeSubject smsHomeSubject);

    /***
     * 根据ID查询SmsHomeSubject数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsHomeSubject全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}