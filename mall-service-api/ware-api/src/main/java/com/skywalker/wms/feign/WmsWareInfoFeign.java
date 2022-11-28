package com.skywalker.wms.feign;

import com.skywalker.entity.Result;
import com.skywalker.wms.pojo.WmsWareInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareInfoFeign
 * @Description TODO
 */
@FeignClient(name="wms", contextId = "wmsWareInfo", path = "/wmsWareInfo")
public interface WmsWareInfoFeign {

    /***
     * WmsWareInfo分页条件搜索实现
     * @param wmsWareInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) WmsWareInfo wmsWareInfo, @PathVariable int page, @PathVariable int size);

    /***
     * WmsWareInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param wmsWareInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) WmsWareInfo wmsWareInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改WmsWareInfo数据
     * @param wmsWareInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody WmsWareInfo wmsWareInfo,@PathVariable Long id);

    /***
     * 新增WmsWareInfo数据
     * @param wmsWareInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody WmsWareInfo wmsWareInfo);

    /***
     * 根据ID查询WmsWareInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询WmsWareInfo全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}