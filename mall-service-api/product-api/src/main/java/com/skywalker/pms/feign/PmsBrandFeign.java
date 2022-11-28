package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsBrand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsBrandFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsBrand", path = "/pmsBrand")
public interface PmsBrandFeign {

    /***
     * PmsBrand分页条件搜索实现
     * @param pmsBrand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsBrand pmsBrand, @PathVariable int page, @PathVariable int size);

    /***
     * PmsBrand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsBrand
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsBrand pmsBrand);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsBrand数据
     * @param pmsBrand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsBrand pmsBrand,@PathVariable Long id);

    /***
     * 新增PmsBrand数据
     * @param pmsBrand
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsBrand pmsBrand);

    /***
     * 根据ID查询PmsBrand数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsBrand全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}