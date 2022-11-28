package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsSeckillSkuRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuRelationFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsSeckillSkuRelation", path = "/smsSeckillSkuRelation")
public interface SmsSeckillSkuRelationFeign {

    /***
     * SmsSeckillSkuRelation分页条件搜索实现
     * @param smsSeckillSkuRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsSeckillSkuRelation smsSeckillSkuRelation, @PathVariable int page, @PathVariable int size);

    /***
     * SmsSeckillSkuRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsSeckillSkuRelation
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsSeckillSkuRelation smsSeckillSkuRelation);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsSeckillSkuRelation数据
     * @param smsSeckillSkuRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsSeckillSkuRelation smsSeckillSkuRelation,@PathVariable Long id);

    /***
     * 新增SmsSeckillSkuRelation数据
     * @param smsSeckillSkuRelation
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsSeckillSkuRelation smsSeckillSkuRelation);

    /***
     * 根据ID查询SmsSeckillSkuRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsSeckillSkuRelation全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}