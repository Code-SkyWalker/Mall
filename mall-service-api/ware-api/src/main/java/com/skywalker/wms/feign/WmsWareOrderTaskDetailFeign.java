package com.skywalker.wms.feign;

import com.skywalker.entity.Result;
import com.skywalker.wms.pojo.WmsWareOrderTaskDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskDetailFeign
 * @Description TODO
 */
@FeignClient(name="wms", contextId = "wmsWareOrderTaskDetail", path = "/wmsWareOrderTaskDetail")
public interface WmsWareOrderTaskDetailFeign {

    /***
     * WmsWareOrderTaskDetail分页条件搜索实现
     * @param wmsWareOrderTaskDetail
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) WmsWareOrderTaskDetail wmsWareOrderTaskDetail, @PathVariable int page, @PathVariable int size);

    /***
     * WmsWareOrderTaskDetail分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param wmsWareOrderTaskDetail
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改WmsWareOrderTaskDetail数据
     * @param wmsWareOrderTaskDetail
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody WmsWareOrderTaskDetail wmsWareOrderTaskDetail,@PathVariable Long id);

    /***
     * 新增WmsWareOrderTaskDetail数据
     * @param wmsWareOrderTaskDetail
     * @return
     */
    @PostMapping
    Result add(@RequestBody WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /***
     * 根据ID查询WmsWareOrderTaskDetail数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询WmsWareOrderTaskDetail全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}