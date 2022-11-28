package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsSpuImages;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsSpuImagesFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsSpuImages", path = "/pmsSpuImages")
public interface PmsSpuImagesFeign {

    /***
     * PmsSpuImages分页条件搜索实现
     * @param pmsSpuImages
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsSpuImages pmsSpuImages, @PathVariable int page, @PathVariable int size);

    /***
     * PmsSpuImages分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsSpuImages
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsSpuImages pmsSpuImages);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsSpuImages数据
     * @param pmsSpuImages
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsSpuImages pmsSpuImages,@PathVariable Long id);

    /***
     * 新增PmsSpuImages数据
     * @param pmsSpuImages
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsSpuImages pmsSpuImages);

    /***
     * 根据ID查询PmsSpuImages数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsSpuImages全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}