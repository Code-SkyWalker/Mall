package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsGrowthChangeHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsGrowthChangeHistoryFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsGrowthChangeHistory", path = "/umsGrowthChangeHistory")
public interface UmsGrowthChangeHistoryFeign {

    /***
     * UmsGrowthChangeHistory分页条件搜索实现
     * @param umsGrowthChangeHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsGrowthChangeHistory umsGrowthChangeHistory, @PathVariable int page, @PathVariable int size);

    /***
     * UmsGrowthChangeHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsGrowthChangeHistory
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsGrowthChangeHistory umsGrowthChangeHistory);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsGrowthChangeHistory数据
     * @param umsGrowthChangeHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsGrowthChangeHistory umsGrowthChangeHistory,@PathVariable Long id);

    /***
     * 新增UmsGrowthChangeHistory数据
     * @param umsGrowthChangeHistory
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsGrowthChangeHistory umsGrowthChangeHistory);

    /***
     * 根据ID查询UmsGrowthChangeHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsGrowthChangeHistory全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}