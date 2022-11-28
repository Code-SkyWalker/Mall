package com.skywalker.oms.feign;

import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderReturnApply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnApplyFeign
 * @Description TODO
 */
@FeignClient(name="oms", contextId = "omsOrderReturnApply", path = "/omsOrderReturnApply")
public interface OmsOrderReturnApplyFeign {

    /***
     * OmsOrderReturnApply分页条件搜索实现
     * @param omsOrderReturnApply
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) OmsOrderReturnApply omsOrderReturnApply, @PathVariable int page, @PathVariable int size);

    /***
     * OmsOrderReturnApply分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param omsOrderReturnApply
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) OmsOrderReturnApply omsOrderReturnApply);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改OmsOrderReturnApply数据
     * @param omsOrderReturnApply
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OmsOrderReturnApply omsOrderReturnApply,@PathVariable Long id);

    /***
     * 新增OmsOrderReturnApply数据
     * @param omsOrderReturnApply
     * @return
     */
    @PostMapping
    Result add(@RequestBody OmsOrderReturnApply omsOrderReturnApply);

    /***
     * 根据ID查询OmsOrderReturnApply数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询OmsOrderReturnApply全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}