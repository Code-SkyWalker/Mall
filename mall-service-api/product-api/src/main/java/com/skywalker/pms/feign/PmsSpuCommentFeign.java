package com.skywalker.pms.feign;

import com.skywalker.entity.Result;
import com.skywalker.pms.pojo.PmsSpuComment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname PmsSpuCommentFeign
 * @Description TODO
 */
@FeignClient(name="pms", contextId = "pmsSpuComment", path = "/pmsSpuComment")
public interface PmsSpuCommentFeign {

    /***
     * PmsSpuComment分页条件搜索实现
     * @param pmsSpuComment
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) PmsSpuComment pmsSpuComment, @PathVariable int page, @PathVariable int size);

    /***
     * PmsSpuComment分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pmsSpuComment
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) PmsSpuComment pmsSpuComment);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改PmsSpuComment数据
     * @param pmsSpuComment
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody PmsSpuComment pmsSpuComment,@PathVariable Long id);

    /***
     * 新增PmsSpuComment数据
     * @param pmsSpuComment
     * @return
     */
    @PostMapping
    Result add(@RequestBody PmsSpuComment pmsSpuComment);

    /***
     * 根据ID查询PmsSpuComment数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询PmsSpuComment全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}