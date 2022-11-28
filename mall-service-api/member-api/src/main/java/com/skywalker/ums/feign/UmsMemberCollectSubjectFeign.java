package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsMemberCollectSubject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSubjectFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsMemberCollectSubject", path = "/umsMemberCollectSubject")
public interface UmsMemberCollectSubjectFeign {

    /***
     * UmsMemberCollectSubject分页条件搜索实现
     * @param umsMemberCollectSubject
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsMemberCollectSubject umsMemberCollectSubject, @PathVariable int page, @PathVariable int size);

    /***
     * UmsMemberCollectSubject分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsMemberCollectSubject
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsMemberCollectSubject umsMemberCollectSubject);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsMemberCollectSubject数据
     * @param umsMemberCollectSubject
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsMemberCollectSubject umsMemberCollectSubject,@PathVariable Long id);

    /***
     * 新增UmsMemberCollectSubject数据
     * @param umsMemberCollectSubject
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsMemberCollectSubject umsMemberCollectSubject);

    /***
     * 根据ID查询UmsMemberCollectSubject数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsMemberCollectSubject全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}