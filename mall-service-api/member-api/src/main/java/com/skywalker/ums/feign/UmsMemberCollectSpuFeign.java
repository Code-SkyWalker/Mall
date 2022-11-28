package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsMemberCollectSpu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSpuFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsMemberCollectSpu", path = "/umsMemberCollectSpu")
public interface UmsMemberCollectSpuFeign {

    /***
     * UmsMemberCollectSpu分页条件搜索实现
     * @param umsMemberCollectSpu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsMemberCollectSpu umsMemberCollectSpu, @PathVariable int page, @PathVariable int size);

    /***
     * UmsMemberCollectSpu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsMemberCollectSpu
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsMemberCollectSpu umsMemberCollectSpu);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsMemberCollectSpu数据
     * @param umsMemberCollectSpu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsMemberCollectSpu umsMemberCollectSpu,@PathVariable Long id);

    /***
     * 新增UmsMemberCollectSpu数据
     * @param umsMemberCollectSpu
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsMemberCollectSpu umsMemberCollectSpu);

    /***
     * 根据ID查询UmsMemberCollectSpu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsMemberCollectSpu全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}