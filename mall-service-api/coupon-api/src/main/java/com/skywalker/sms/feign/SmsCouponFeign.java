package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsCoupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsCouponFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsCoupon", path = "/smsCoupon")
public interface SmsCouponFeign {

    /***
     * SmsCoupon分页条件搜索实现
     * @param smsCoupon
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsCoupon smsCoupon, @PathVariable int page, @PathVariable int size);

    /***
     * SmsCoupon分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsCoupon
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsCoupon smsCoupon);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsCoupon数据
     * @param smsCoupon
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsCoupon smsCoupon,@PathVariable Long id);

    /***
     * 新增SmsCoupon数据
     * @param smsCoupon
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsCoupon smsCoupon);

    /***
     * 根据ID查询SmsCoupon数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsCoupon全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}