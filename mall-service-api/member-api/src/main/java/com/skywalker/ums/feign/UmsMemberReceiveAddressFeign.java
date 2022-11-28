package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsMemberReceiveAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberReceiveAddressFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsMemberReceiveAddress", path = "/umsMemberReceiveAddress")
public interface UmsMemberReceiveAddressFeign {

    /***
     * UmsMemberReceiveAddress分页条件搜索实现
     * @param umsMemberReceiveAddress
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsMemberReceiveAddress umsMemberReceiveAddress, @PathVariable int page, @PathVariable int size);

    /***
     * UmsMemberReceiveAddress分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsMemberReceiveAddress
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsMemberReceiveAddress umsMemberReceiveAddress);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsMemberReceiveAddress数据
     * @param umsMemberReceiveAddress
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress,@PathVariable Long id);

    /***
     * 新增UmsMemberReceiveAddress数据
     * @param umsMemberReceiveAddress
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress);

    /***
     * 根据ID查询UmsMemberReceiveAddress数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsMemberReceiveAddress全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}