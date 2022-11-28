package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsCouponHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsCouponHistoryFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsCouponHistory", path = "/smsCouponHistory")
public interface SmsCouponHistoryFeign {

    /***
     * SmsCouponHistory分页条件搜索实现
     * @param smsCouponHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsCouponHistory smsCouponHistory, @PathVariable int page, @PathVariable int size);

    /***
     * SmsCouponHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsCouponHistory
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsCouponHistory smsCouponHistory);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsCouponHistory数据
     * @param smsCouponHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsCouponHistory smsCouponHistory,@PathVariable Long id);

    /***
     * 新增SmsCouponHistory数据
     * @param smsCouponHistory
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsCouponHistory smsCouponHistory);

    /***
     * 根据ID查询SmsCouponHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsCouponHistory全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}