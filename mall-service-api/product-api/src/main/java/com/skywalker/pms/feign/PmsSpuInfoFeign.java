package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsSpuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsSpuInfo", path = "/pmsSpuInfo")
public interface PmsSpuInfoFeign {

    /***
     * PmsSpuInfo分页条件搜索实现
     * @param pmsSpuInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsSpuInfo pmsSpuInfo, @PathVariable int page, @PathVariable int size);

    /***
     * PmsSpuInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsSpuInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsSpuInfo pmsSpuInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsSpuInfo数据
     * @param pmsSpuInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsSpuInfo pmsSpuInfo,@PathVariable Long id);

    /***
     * 新增PmsSpuInfo数据
     * @param pmsSpuInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsSpuInfo pmsSpuInfo);

    /***
     * 根据ID查询PmsSpuInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsSpuInfo全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}