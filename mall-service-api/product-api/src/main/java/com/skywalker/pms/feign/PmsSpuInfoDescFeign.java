package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsSpuInfoDesc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoDescFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsSpuInfoDesc", path = "/pmsSpuInfoDesc")
public interface PmsSpuInfoDescFeign {

    /***
     * PmsSpuInfoDesc分页条件搜索实现
     * @param pmsSpuInfoDesc
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsSpuInfoDesc pmsSpuInfoDesc, @PathVariable int page, @PathVariable int size);

    /***
     * PmsSpuInfoDesc分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsSpuInfoDesc
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsSpuInfoDesc pmsSpuInfoDesc);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsSpuInfoDesc数据
     * @param pmsSpuInfoDesc
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsSpuInfoDesc pmsSpuInfoDesc,@PathVariable Long id);

    /***
     * 新增PmsSpuInfoDesc数据
     * @param pmsSpuInfoDesc
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsSpuInfoDesc pmsSpuInfoDesc);

    /***
     * 根据ID查询PmsSpuInfoDesc数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsSpuInfoDesc全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}