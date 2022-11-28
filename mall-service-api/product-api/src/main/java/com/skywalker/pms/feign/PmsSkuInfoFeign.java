package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsSkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsSkuInfoFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsSkuInfo", path = "/pmsSkuInfo")
public interface PmsSkuInfoFeign {

    /***
     * PmsSkuInfo分页条件搜索实现
     * @param pmsSkuInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsSkuInfo pmsSkuInfo, @PathVariable int page, @PathVariable int size);

    /***
     * PmsSkuInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsSkuInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsSkuInfo pmsSkuInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsSkuInfo数据
     * @param pmsSkuInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsSkuInfo pmsSkuInfo,@PathVariable Long id);

    /***
     * 新增PmsSkuInfo数据
     * @param pmsSkuInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsSkuInfo pmsSkuInfo);

    /***
     * 根据ID查询PmsSkuInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsSkuInfo全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}