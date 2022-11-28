package com.skywalker.ums.feign;

import com.skywalker.entity.Result;
import com.skywalker.ums.pojo.UmsMemberStatisticsInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberStatisticsInfoFeign
 * @Description TODO
 */
@FeignClient(name="ums", contextId = "umsMemberStatisticsInfo", path = "/umsMemberStatisticsInfo")
public interface UmsMemberStatisticsInfoFeign {

    /***
     * UmsMemberStatisticsInfo分页条件搜索实现
     * @param umsMemberStatisticsInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result findPage(@RequestBody(required = false) UmsMemberStatisticsInfo umsMemberStatisticsInfo, @PathVariable int page, @PathVariable int size);

    /***
     * UmsMemberStatisticsInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param umsMemberStatisticsInfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result findList(@RequestBody(required = false) UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UmsMemberStatisticsInfo数据
     * @param umsMemberStatisticsInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo,@PathVariable Long id);

    /***
     * 新增UmsMemberStatisticsInfo数据
     * @param umsMemberStatisticsInfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /***
     * 根据ID查询UmsMemberStatisticsInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result findById(@PathVariable Long id);

    /***
     * 查询UmsMemberStatisticsInfo全部数据
     * @return
     */
    @GetMapping
    Result findAll();
}