package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsMember", path = "/umsMember")
public interface UmsMemberFeign {

    /***
     * UmsMember分页条件搜索实现
     * @param umsMember
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsMember umsMember, @PathVariable int page, @PathVariable int size);

    /***
     * UmsMember分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsMember
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsMember umsMember);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsMember数据
     * @param umsMember
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsMember umsMember,@PathVariable Long id);

    /***
     * 新增UmsMember数据
     * @param umsMember
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsMember umsMember);

    /***
     * 根据ID查询UmsMember数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsMember全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}