package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsGrowthChangeHistory;
import com.skywalker.ums.service.UmsGrowthChangeHistoryService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsGrowthChangeHistoryController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsGrowthChangeHistory")
@CrossOrigin
public class UmsGrowthChangeHistoryController {

    @Autowired
    private UmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    /***
     * UmsGrowthChangeHistory分页条件搜索实现
     * @param umsGrowthChangeHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsGrowthChangeHistory umsGrowthChangeHistory, @PathVariable  int page, @PathVariable  int size){
        //调用UmsGrowthChangeHistoryService实现分页条件查询UmsGrowthChangeHistory
        PageInfo<UmsGrowthChangeHistory> pageInfo = umsGrowthChangeHistoryService.findPage(umsGrowthChangeHistory, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsGrowthChangeHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsGrowthChangeHistoryService实现分页查询UmsGrowthChangeHistory
        PageInfo<UmsGrowthChangeHistory> pageInfo = umsGrowthChangeHistoryService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsGrowthChangeHistory
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsGrowthChangeHistory umsGrowthChangeHistory){
        //调用UmsGrowthChangeHistoryService实现条件查询UmsGrowthChangeHistory
        List<UmsGrowthChangeHistory> list = umsGrowthChangeHistoryService.findList(umsGrowthChangeHistory);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsGrowthChangeHistoryService实现根据主键删除
        umsGrowthChangeHistoryService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsGrowthChangeHistory数据
     * @param umsGrowthChangeHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsGrowthChangeHistory umsGrowthChangeHistory,@PathVariable Long id){
        //设置主键值
        umsGrowthChangeHistory.setId(id);
        //调用UmsGrowthChangeHistoryService实现修改UmsGrowthChangeHistory
        umsGrowthChangeHistoryService.update(umsGrowthChangeHistory);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsGrowthChangeHistory数据
     * @param umsGrowthChangeHistory
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsGrowthChangeHistory umsGrowthChangeHistory){
        //调用UmsGrowthChangeHistoryService实现添加UmsGrowthChangeHistory
        umsGrowthChangeHistoryService.add(umsGrowthChangeHistory);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsGrowthChangeHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsGrowthChangeHistoryService实现根据主键查询UmsGrowthChangeHistory
        UmsGrowthChangeHistory umsGrowthChangeHistory = umsGrowthChangeHistoryService.findById(id);
        return Result.ok("查询成功", umsGrowthChangeHistory);
    }

    /***
     * 查询UmsGrowthChangeHistory全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsGrowthChangeHistoryService实现查询所有UmsGrowthChangeHistory
        List<UmsGrowthChangeHistory> list = umsGrowthChangeHistoryService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
