package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsMemberLoginLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLoginLogFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsMemberLoginLog", path = "/umsMemberLoginLog")
public interface UmsMemberLoginLogFeign {

    /***
     * UmsMemberLoginLog分页条件搜索实现
     * @param umsMemberLoginLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsMemberLoginLog umsMemberLoginLog, @PathVariable int page, @PathVariable int size);

    /***
     * UmsMemberLoginLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsMemberLoginLog
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsMemberLoginLog umsMemberLoginLog);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsMemberLoginLog数据
     * @param umsMemberLoginLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsMemberLoginLog umsMemberLoginLog,@PathVariable Long id);

    /***
     * 新增UmsMemberLoginLog数据
     * @param umsMemberLoginLog
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsMemberLoginLog umsMemberLoginLog);

    /***
     * 根据ID查询UmsMemberLoginLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsMemberLoginLog全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}