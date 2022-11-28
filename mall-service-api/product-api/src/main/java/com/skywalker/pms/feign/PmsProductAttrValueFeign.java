package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsProductAttrValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsProductAttrValueFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsProductAttrValue", path = "/pmsProductAttrValue")
public interface PmsProductAttrValueFeign {

    /***
     * PmsProductAttrValue分页条件搜索实现
     * @param pmsProductAttrValue
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsProductAttrValue pmsProductAttrValue, @PathVariable int page, @PathVariable int size);

    /***
     * PmsProductAttrValue分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsProductAttrValue
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsProductAttrValue pmsProductAttrValue);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsProductAttrValue数据
     * @param pmsProductAttrValue
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsProductAttrValue pmsProductAttrValue,@PathVariable Long id);

    /***
     * 新增PmsProductAttrValue数据
     * @param pmsProductAttrValue
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsProductAttrValue pmsProductAttrValue);

    /***
     * 根据ID查询PmsProductAttrValue数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsProductAttrValue全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}