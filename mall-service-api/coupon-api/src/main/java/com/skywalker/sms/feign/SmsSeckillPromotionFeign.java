package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsSeckillPromotion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillPromotionFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsSeckillPromotion", path = "/smsSeckillPromotion")
public interface SmsSeckillPromotionFeign {

    /***
     * SmsSeckillPromotion分页条件搜索实现
     * @param smsSeckillPromotion
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsSeckillPromotion smsSeckillPromotion, @PathVariable int page, @PathVariable int size);

    /***
     * SmsSeckillPromotion分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsSeckillPromotion
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsSeckillPromotion smsSeckillPromotion);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsSeckillPromotion数据
     * @param smsSeckillPromotion
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsSeckillPromotion smsSeckillPromotion,@PathVariable Long id);

    /***
     * 新增SmsSeckillPromotion数据
     * @param smsSeckillPromotion
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsSeckillPromotion smsSeckillPromotion);

    /***
     * 根据ID查询SmsSeckillPromotion数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsSeckillPromotion全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}