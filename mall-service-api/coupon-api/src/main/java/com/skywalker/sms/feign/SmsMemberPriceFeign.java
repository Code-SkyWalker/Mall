package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsMemberPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsMemberPriceFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsMemberPrice", path = "/smsMemberPrice")
public interface SmsMemberPriceFeign {

    /***
     * SmsMemberPrice分页条件搜索实现
     * @param smsMemberPrice
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsMemberPrice smsMemberPrice, @PathVariable int page, @PathVariable int size);

    /***
     * SmsMemberPrice分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsMemberPrice
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsMemberPrice smsMemberPrice);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsMemberPrice数据
     * @param smsMemberPrice
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsMemberPrice smsMemberPrice,@PathVariable Long id);

    /***
     * 新增SmsMemberPrice数据
     * @param smsMemberPrice
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsMemberPrice smsMemberPrice);

    /***
     * 根据ID查询SmsMemberPrice数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsMemberPrice全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}