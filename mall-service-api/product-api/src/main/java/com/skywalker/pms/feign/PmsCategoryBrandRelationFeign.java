package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsCategoryBrandRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryBrandRelationFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsCategoryBrandRelation", path = "/pmsCategoryBrandRelation")
public interface PmsCategoryBrandRelationFeign {

    /***
     * PmsCategoryBrandRelation分页条件搜索实现
     * @param pmsCategoryBrandRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsCategoryBrandRelation pmsCategoryBrandRelation, @PathVariable int page, @PathVariable int size);

    /***
     * PmsCategoryBrandRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsCategoryBrandRelation
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsCategoryBrandRelation数据
     * @param pmsCategoryBrandRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation,@PathVariable Long id);

    /***
     * 新增PmsCategoryBrandRelation数据
     * @param pmsCategoryBrandRelation
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /***
     * 根据ID查询PmsCategoryBrandRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsCategoryBrandRelation全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}