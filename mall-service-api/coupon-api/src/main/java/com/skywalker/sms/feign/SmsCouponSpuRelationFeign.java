package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsCouponSpuRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuRelationFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsCouponSpuRelation", path = "/smsCouponSpuRelation")
public interface SmsCouponSpuRelationFeign {

    /***
     * SmsCouponSpuRelation分页条件搜索实现
     * @param smsCouponSpuRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsCouponSpuRelation smsCouponSpuRelation, @PathVariable int page, @PathVariable int size);

    /***
     * SmsCouponSpuRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsCouponSpuRelation
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsCouponSpuRelation smsCouponSpuRelation);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsCouponSpuRelation数据
     * @param smsCouponSpuRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsCouponSpuRelation smsCouponSpuRelation,@PathVariable Long id);

    /***
     * 新增SmsCouponSpuRelation数据
     * @param smsCouponSpuRelation
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsCouponSpuRelation smsCouponSpuRelation);

    /***
     * 根据ID查询SmsCouponSpuRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsCouponSpuRelation全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}