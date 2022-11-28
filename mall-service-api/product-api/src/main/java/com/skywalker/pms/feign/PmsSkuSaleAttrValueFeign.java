package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsSkuSaleAttrValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsSkuSaleAttrValueFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsSkuSaleAttrValue", path = "/pmsSkuSaleAttrValue")
public interface PmsSkuSaleAttrValueFeign {

    /***
     * PmsSkuSaleAttrValue分页条件搜索实现
     * @param pmsSkuSaleAttrValue
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsSkuSaleAttrValue pmsSkuSaleAttrValue, @PathVariable int page, @PathVariable int size);

    /***
     * PmsSkuSaleAttrValue分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsSkuSaleAttrValue
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsSkuSaleAttrValue数据
     * @param pmsSkuSaleAttrValue
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsSkuSaleAttrValue pmsSkuSaleAttrValue,@PathVariable Long id);

    /***
     * 新增PmsSkuSaleAttrValue数据
     * @param pmsSkuSaleAttrValue
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /***
     * 根据ID查询PmsSkuSaleAttrValue数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsSkuSaleAttrValue全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}