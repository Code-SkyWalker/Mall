package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsAttrGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrGroupFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsAttrGroup", path = "/pmsAttrGroup")
public interface PmsAttrGroupFeign {

    /***
     * PmsAttrGroup分页条件搜索实现
     * @param pmsAttrGroup
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsAttrGroup pmsAttrGroup, @PathVariable int page, @PathVariable int size);

    /***
     * PmsAttrGroup分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsAttrGroup
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsAttrGroup pmsAttrGroup);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsAttrGroup数据
     * @param pmsAttrGroup
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsAttrGroup pmsAttrGroup,@PathVariable Long id);

    /***
     * 新增PmsAttrGroup数据
     * @param pmsAttrGroup
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsAttrGroup pmsAttrGroup);

    /***
     * 根据ID查询PmsAttrGroup数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsAttrGroup全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}