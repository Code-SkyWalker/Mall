package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsCategory", path = "/pmsCategory")
public interface PmsCategoryFeign {

    /***
     * PmsCategory分页条件搜索实现
     * @param pmsCategory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsCategory pmsCategory, @PathVariable int page, @PathVariable int size);

    /***
     * PmsCategory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsCategory
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsCategory pmsCategory);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsCategory数据
     * @param pmsCategory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsCategory pmsCategory,@PathVariable Long id);

    /***
     * 新增PmsCategory数据
     * @param pmsCategory
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsCategory pmsCategory);

    /***
     * 根据ID查询PmsCategory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsCategory全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}