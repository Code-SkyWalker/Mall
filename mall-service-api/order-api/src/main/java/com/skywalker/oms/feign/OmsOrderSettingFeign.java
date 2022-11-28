package com.skywalker.oms.feign;

import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderSetting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderSettingFeign
 * @Description TODO
 */
@FeignClient(name="oms", contextId = "omsOrderSetting", path = "/omsOrderSetting")
public interface OmsOrderSettingFeign {

    /***
     * OmsOrderSetting分页条件搜索实现
     * @param omsOrderSetting
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) OmsOrderSetting omsOrderSetting, @PathVariable int page, @PathVariable int size);

    /***
     * OmsOrderSetting分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param omsOrderSetting
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) OmsOrderSetting omsOrderSetting);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改OmsOrderSetting数据
     * @param omsOrderSetting
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OmsOrderSetting omsOrderSetting,@PathVariable Long id);

    /***
     * 新增OmsOrderSetting数据
     * @param omsOrderSetting
     * @return
     */
    @PostMapping
    Result add(@RequestBody OmsOrderSetting omsOrderSetting);

    /***
     * 根据ID查询OmsOrderSetting数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询OmsOrderSetting全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}