package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsIntegrationChangeHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsIntegrationChangeHistoryFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsIntegrationChangeHistory", path = "/umsIntegrationChangeHistory")
public interface UmsIntegrationChangeHistoryFeign {

    /***
     * UmsIntegrationChangeHistory分页条件搜索实现
     * @param umsIntegrationChangeHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsIntegrationChangeHistory umsIntegrationChangeHistory, @PathVariable int page, @PathVariable int size);

    /***
     * UmsIntegrationChangeHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsIntegrationChangeHistory
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsIntegrationChangeHistory数据
     * @param umsIntegrationChangeHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory,@PathVariable Long id);

    /***
     * 新增UmsIntegrationChangeHistory数据
     * @param umsIntegrationChangeHistory
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /***
     * 根据ID查询UmsIntegrationChangeHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsIntegrationChangeHistory全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}