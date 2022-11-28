package com.skywalker.oms.feign;

import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsPaymentInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname OmsPaymentInfoFeign
 * @Description TODO
 */
@FeignClient(name="oms", contextId = "omsPaymentInfo", path = "/omsPaymentInfo")
public interface OmsPaymentInfoFeign {

    /***
     * OmsPaymentInfo分页条件搜索实现
     * @param omsPaymentInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) OmsPaymentInfo omsPaymentInfo, @PathVariable int page, @PathVariable int size);

    /***
     * OmsPaymentInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param omsPaymentInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) OmsPaymentInfo omsPaymentInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改OmsPaymentInfo数据
     * @param omsPaymentInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OmsPaymentInfo omsPaymentInfo,@PathVariable Long id);

    /***
     * 新增OmsPaymentInfo数据
     * @param omsPaymentInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody OmsPaymentInfo omsPaymentInfo);

    /***
     * 根据ID查询OmsPaymentInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询OmsPaymentInfo全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}