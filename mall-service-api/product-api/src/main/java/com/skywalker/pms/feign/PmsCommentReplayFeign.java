package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsCommentReplay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsCommentReplayFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsCommentReplay", path = "/pmsCommentReplay")
public interface PmsCommentReplayFeign {

    /***
     * PmsCommentReplay分页条件搜索实现
     * @param pmsCommentReplay
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsCommentReplay pmsCommentReplay, @PathVariable int page, @PathVariable int size);

    /***
     * PmsCommentReplay分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsCommentReplay
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsCommentReplay pmsCommentReplay);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsCommentReplay数据
     * @param pmsCommentReplay
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsCommentReplay pmsCommentReplay,@PathVariable Long id);

    /***
     * 新增PmsCommentReplay数据
     * @param pmsCommentReplay
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsCommentReplay pmsCommentReplay);

    /***
     * 根据ID查询PmsCommentReplay数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsCommentReplay全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}