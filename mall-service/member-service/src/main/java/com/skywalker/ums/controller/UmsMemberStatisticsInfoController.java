package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsMemberStatisticsInfo;
import com.skywalker.ums.service.UmsMemberStatisticsInfoService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberStatisticsInfoController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsMemberStatisticsInfo")
public class UmsMemberStatisticsInfoController {

    @Autowired
    private UmsMemberStatisticsInfoService umsMemberStatisticsInfoService;

    /***
     * UmsMemberStatisticsInfo分页条件搜索实现
     * @param umsMemberStatisticsInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsMemberStatisticsInfo umsMemberStatisticsInfo, @PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberStatisticsInfoService实现分页条件查询UmsMemberStatisticsInfo
        PageInfo<UmsMemberStatisticsInfo> pageInfo = umsMemberStatisticsInfoService.findPage(umsMemberStatisticsInfo, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsMemberStatisticsInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberStatisticsInfoService实现分页查询UmsMemberStatisticsInfo
        PageInfo<UmsMemberStatisticsInfo> pageInfo = umsMemberStatisticsInfoService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsMemberStatisticsInfo
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsMemberStatisticsInfo umsMemberStatisticsInfo){
        //调用UmsMemberStatisticsInfoService实现条件查询UmsMemberStatisticsInfo
        List<UmsMemberStatisticsInfo> list = umsMemberStatisticsInfoService.findList(umsMemberStatisticsInfo);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsMemberStatisticsInfoService实现根据主键删除
        umsMemberStatisticsInfoService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsMemberStatisticsInfo数据
     * @param umsMemberStatisticsInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsMemberStatisticsInfo umsMemberStatisticsInfo,@PathVariable Long id){
        //设置主键值
        umsMemberStatisticsInfo.setId(id);
        //调用UmsMemberStatisticsInfoService实现修改UmsMemberStatisticsInfo
        umsMemberStatisticsInfoService.update(umsMemberStatisticsInfo);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsMemberStatisticsInfo数据
     * @param umsMemberStatisticsInfo
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsMemberStatisticsInfo umsMemberStatisticsInfo){
        //调用UmsMemberStatisticsInfoService实现添加UmsMemberStatisticsInfo
        umsMemberStatisticsInfoService.add(umsMemberStatisticsInfo);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsMemberStatisticsInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsMemberStatisticsInfoService实现根据主键查询UmsMemberStatisticsInfo
        UmsMemberStatisticsInfo umsMemberStatisticsInfo = umsMemberStatisticsInfoService.findById(id);
        return Result.ok("查询成功", umsMemberStatisticsInfo);
    }

    /***
     * 查询UmsMemberStatisticsInfo全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsMemberStatisticsInfoService实现查询所有UmsMemberStatisticsInfo
        List<UmsMemberStatisticsInfo> list = umsMemberStatisticsInfoService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
