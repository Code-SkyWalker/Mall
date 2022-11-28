package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsSeckillSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSessionFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsSeckillSession", path = "/smsSeckillSession")
public interface SmsSeckillSessionFeign {

    /***
     * SmsSeckillSession分页条件搜索实现
     * @param smsSeckillSession
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsSeckillSession smsSeckillSession, @PathVariable int page, @PathVariable int size);

    /***
     * SmsSeckillSession分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsSeckillSession
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsSeckillSession smsSeckillSession);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsSeckillSession数据
     * @param smsSeckillSession
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsSeckillSession smsSeckillSession,@PathVariable Long id);

    /***
     * 新增SmsSeckillSession数据
     * @param smsSeckillSession
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsSeckillSession smsSeckillSession);

    /***
     * 根据ID查询SmsSeckillSession数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsSeckillSession全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}