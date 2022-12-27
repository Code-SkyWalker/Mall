package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsSkuFullReduction;
import com.skywalker.to.SkuCouponTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsSkuFullReductionFeign
 * @Description TODO
 */
@FeignClient(name="coupon-service", contextId = "smsSkuFullReduction", path = "/skuFullReduction")
public interface SmsSkuFullReductionFeign {

    /***
     * SmsSkuFullReduction分页条件搜索实现
     * @param smsSkuFullReduction
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsSkuFullReduction smsSkuFullReduction, @PathVariable int page, @PathVariable int size);

    /***
     * SmsSkuFullReduction分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsSkuFullReduction
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsSkuFullReduction smsSkuFullReduction);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsSkuFullReduction数据
     * @param smsSkuFullReduction
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsSkuFullReduction smsSkuFullReduction,@PathVariable Long id);

    /***
     * 新增SmsSkuFullReduction数据
     * @param smsSkuFullReduction
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsSkuFullReduction smsSkuFullReduction);

    /***
     * 根据ID查询SmsSkuFullReduction数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsSkuFullReduction全部数据
     * @return
     */
    @GetMapping
    Result findAll();

    @PostMapping("/skuCouponInfo/add")
    Result addSkuCouponInfo(@RequestBody SkuCouponTo skuCouponTo);
}