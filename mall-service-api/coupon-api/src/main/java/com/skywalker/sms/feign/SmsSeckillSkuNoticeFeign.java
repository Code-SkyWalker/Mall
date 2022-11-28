package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsSeckillSkuNotice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuNoticeFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsSeckillSkuNotice", path = "/smsSeckillSkuNotice")
public interface SmsSeckillSkuNoticeFeign {

    /***
     * SmsSeckillSkuNotice分页条件搜索实现
     * @param smsSeckillSkuNotice
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsSeckillSkuNotice smsSeckillSkuNotice, @PathVariable int page, @PathVariable int size);

    /***
     * SmsSeckillSkuNotice分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsSeckillSkuNotice
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsSeckillSkuNotice smsSeckillSkuNotice);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsSeckillSkuNotice数据
     * @param smsSeckillSkuNotice
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsSeckillSkuNotice smsSeckillSkuNotice,@PathVariable Long id);

    /***
     * 新增SmsSeckillSkuNotice数据
     * @param smsSeckillSkuNotice
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsSeckillSkuNotice smsSeckillSkuNotice);

    /***
     * 根据ID查询SmsSeckillSkuNotice数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsSeckillSkuNotice全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}