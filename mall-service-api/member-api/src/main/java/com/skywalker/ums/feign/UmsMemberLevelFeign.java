package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsMemberLevel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLevelFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsMemberLevel", path = "/umsMemberLevel")
public interface UmsMemberLevelFeign {

    /***
     * UmsMemberLevel分页条件搜索实现
     * @param umsMemberLevel
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsMemberLevel umsMemberLevel, @PathVariable int page, @PathVariable int size);

    /***
     * UmsMemberLevel分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsMemberLevel
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsMemberLevel umsMemberLevel);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsMemberLevel数据
     * @param umsMemberLevel
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsMemberLevel umsMemberLevel,@PathVariable Long id);

    /***
     * 新增UmsMemberLevel数据
     * @param umsMemberLevel
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsMemberLevel umsMemberLevel);

    /***
     * 根据ID查询UmsMemberLevel数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsMemberLevel全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}