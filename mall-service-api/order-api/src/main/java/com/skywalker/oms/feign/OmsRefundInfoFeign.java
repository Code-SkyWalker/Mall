package com.skywalker.oms.feign;

import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsRefundInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname OmsRefundInfoFeign
 * @Description TODO
 */
@FeignClient(name="oms", contextId = "omsRefundInfo", path = "/omsRefundInfo")
public interface OmsRefundInfoFeign {

    /***
     * OmsRefundInfo分页条件搜索实现
     * @param omsRefundInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) OmsRefundInfo omsRefundInfo, @PathVariable int page, @PathVariable int size);

    /***
     * OmsRefundInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param omsRefundInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) OmsRefundInfo omsRefundInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改OmsRefundInfo数据
     * @param omsRefundInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OmsRefundInfo omsRefundInfo,@PathVariable Long id);

    /***
     * 新增OmsRefundInfo数据
     * @param omsRefundInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody OmsRefundInfo omsRefundInfo);

    /***
     * 根据ID查询OmsRefundInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询OmsRefundInfo全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}