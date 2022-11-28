package com.skywalker.wms.feign;

import com.skywalker.entity.Result;
import com.skywalker.wms.pojo.WmsWareOrderTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskFeign
 * @Description TODO
 */
@FeignClient(name="wms", contextId = "wmsWareOrderTask", path = "/wmsWareOrderTask")
public interface WmsWareOrderTaskFeign {

    /***
     * WmsWareOrderTask分页条件搜索实现
     * @param wmsWareOrderTask
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) WmsWareOrderTask wmsWareOrderTask, @PathVariable int page, @PathVariable int size);

    /***
     * WmsWareOrderTask分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param wmsWareOrderTask
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) WmsWareOrderTask wmsWareOrderTask);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改WmsWareOrderTask数据
     * @param wmsWareOrderTask
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody WmsWareOrderTask wmsWareOrderTask,@PathVariable Long id);

    /***
     * 新增WmsWareOrderTask数据
     * @param wmsWareOrderTask
     * @return
     */
    @PostMapping
    Result add(@RequestBody WmsWareOrderTask wmsWareOrderTask);

    /***
     * 根据ID查询WmsWareOrderTask数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询WmsWareOrderTask全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}