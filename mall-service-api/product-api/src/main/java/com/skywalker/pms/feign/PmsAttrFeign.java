package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsAttr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsAttr", path = "/pmsAttr")
public interface PmsAttrFeign {

    /***
     * PmsAttr分页条件搜索实现
     * @param pmsAttr
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsAttr pmsAttr, @PathVariable int page, @PathVariable int size);

    /***
     * PmsAttr分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsAttr
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsAttr pmsAttr);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsAttr数据
     * @param pmsAttr
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsAttr pmsAttr,@PathVariable Long id);

    /***
     * 新增PmsAttr数据
     * @param pmsAttr
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsAttr pmsAttr);

    /***
     * 根据ID查询PmsAttr数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsAttr全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}