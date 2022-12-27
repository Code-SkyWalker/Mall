package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsIntegrationChangeHistory;
import com.skywalker.ums.service.UmsIntegrationChangeHistoryService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsIntegrationChangeHistoryController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsIntegrationChangeHistory")
public class UmsIntegrationChangeHistoryController {

    @Autowired
    private UmsIntegrationChangeHistoryService umsIntegrationChangeHistoryService;

    /***
     * UmsIntegrationChangeHistory分页条件搜索实现
     * @param umsIntegrationChangeHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsIntegrationChangeHistory umsIntegrationChangeHistory, @PathVariable  int page, @PathVariable  int size){
        //调用UmsIntegrationChangeHistoryService实现分页条件查询UmsIntegrationChangeHistory
        PageInfo<UmsIntegrationChangeHistory> pageInfo = umsIntegrationChangeHistoryService.findPage(umsIntegrationChangeHistory, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsIntegrationChangeHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsIntegrationChangeHistoryService实现分页查询UmsIntegrationChangeHistory
        PageInfo<UmsIntegrationChangeHistory> pageInfo = umsIntegrationChangeHistoryService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsIntegrationChangeHistory
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsIntegrationChangeHistory umsIntegrationChangeHistory){
        //调用UmsIntegrationChangeHistoryService实现条件查询UmsIntegrationChangeHistory
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.findList(umsIntegrationChangeHistory);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsIntegrationChangeHistoryService实现根据主键删除
        umsIntegrationChangeHistoryService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsIntegrationChangeHistory数据
     * @param umsIntegrationChangeHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsIntegrationChangeHistory umsIntegrationChangeHistory,@PathVariable Long id){
        //设置主键值
        umsIntegrationChangeHistory.setId(id);
        //调用UmsIntegrationChangeHistoryService实现修改UmsIntegrationChangeHistory
        umsIntegrationChangeHistoryService.update(umsIntegrationChangeHistory);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsIntegrationChangeHistory数据
     * @param umsIntegrationChangeHistory
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsIntegrationChangeHistory umsIntegrationChangeHistory){
        //调用UmsIntegrationChangeHistoryService实现添加UmsIntegrationChangeHistory
        umsIntegrationChangeHistoryService.add(umsIntegrationChangeHistory);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsIntegrationChangeHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsIntegrationChangeHistoryService实现根据主键查询UmsIntegrationChangeHistory
        UmsIntegrationChangeHistory umsIntegrationChangeHistory = umsIntegrationChangeHistoryService.findById(id);
        return Result.ok("查询成功", umsIntegrationChangeHistory);
    }

    /***
     * 查询UmsIntegrationChangeHistory全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsIntegrationChangeHistoryService实现查询所有UmsIntegrationChangeHistory
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
