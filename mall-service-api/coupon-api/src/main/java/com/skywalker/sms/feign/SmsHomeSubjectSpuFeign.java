package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsHomeSubjectSpu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectSpuFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsHomeSubjectSpu", path = "/smsHomeSubjectSpu")
public interface SmsHomeSubjectSpuFeign {

    /***
     * SmsHomeSubjectSpu分页条件搜索实现
     * @param smsHomeSubjectSpu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsHomeSubjectSpu smsHomeSubjectSpu, @PathVariable int page, @PathVariable int size);

    /***
     * SmsHomeSubjectSpu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsHomeSubjectSpu
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsHomeSubjectSpu smsHomeSubjectSpu);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsHomeSubjectSpu数据
     * @param smsHomeSubjectSpu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsHomeSubjectSpu smsHomeSubjectSpu,@PathVariable Long id);

    /***
     * 新增SmsHomeSubjectSpu数据
     * @param smsHomeSubjectSpu
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsHomeSubjectSpu smsHomeSubjectSpu);

    /***
     * 根据ID查询SmsHomeSubjectSpu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsHomeSubjectSpu全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}