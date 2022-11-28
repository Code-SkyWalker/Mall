package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsAttrAttrgroupRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrAttrgroupRelationFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsAttrAttrgroupRelation", path = "/pmsAttrAttrgroupRelation")
public interface PmsAttrAttrgroupRelationFeign {

    /***
     * PmsAttrAttrgroupRelation分页条件搜索实现
     * @param pmsAttrAttrgroupRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation, @PathVariable int page, @PathVariable int size);

    /***
     * PmsAttrAttrgroupRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsAttrAttrgroupRelation
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsAttrAttrgroupRelation数据
     * @param pmsAttrAttrgroupRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation,@PathVariable Long id);

    /***
     * 新增PmsAttrAttrgroupRelation数据
     * @param pmsAttrAttrgroupRelation
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /***
     * 根据ID查询PmsAttrAttrgroupRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsAttrAttrgroupRelation全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}