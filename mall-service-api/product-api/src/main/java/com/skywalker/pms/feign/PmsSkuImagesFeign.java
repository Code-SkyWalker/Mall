package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsSkuImages;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsSkuImagesFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsSkuImages", path = "/pmsSkuImages")
public interface PmsSkuImagesFeign {

    /***
     * PmsSkuImages分页条件搜索实现
     * @param pmsSkuImages
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsSkuImages pmsSkuImages, @PathVariable int page, @PathVariable int size);

    /***
     * PmsSkuImages分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsSkuImages
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsSkuImages pmsSkuImages);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsSkuImages数据
     * @param pmsSkuImages
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsSkuImages pmsSkuImages,@PathVariable Long id);

    /***
     * 新增PmsSkuImages数据
     * @param pmsSkuImages
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsSkuImages pmsSkuImages);

    /***
     * 根据ID查询PmsSkuImages数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsSkuImages全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}