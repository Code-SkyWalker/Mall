package com.skywalker.sms.feign;

import com.skywalker.entity.Result;
import com.skywalker.sms.pojo.SmsCouponSpuCategoryRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuCategoryRelationFeign
 * @Description TODO
 */
@FeignClient(name="sms", contextId = "smsCouponSpuCategoryRelation", path = "/smsCouponSpuCategoryRelation")
public interface SmsCouponSpuCategoryRelationFeign {

    /***
     * SmsCouponSpuCategoryRelation分页条件搜索实现
     * @param smsCouponSpuCategoryRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation, @PathVariable int page, @PathVariable int size);

    /***
     * SmsCouponSpuCategoryRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param smsCouponSpuCategoryRelation
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改SmsCouponSpuCategoryRelation数据
     * @param smsCouponSpuCategoryRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation,@PathVariable Long id);

    /***
     * 新增SmsCouponSpuCategoryRelation数据
     * @param smsCouponSpuCategoryRelation
     * @return
     */
    @PostMapping
    Result add(@RequestBody SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /***
     * 根据ID查询SmsCouponSpuCategoryRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询SmsCouponSpuCategoryRelation全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}