package com.skywalker.oms.controller;

import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderOperateHistory;
import com.skywalker.oms.service.OmsOrderOperateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderOperateHistoryController
 * @Description TODO
 */

@RestController
@RequestMapping("/omsOrderOperateHistory")
@CrossOrigin
public class OmsOrderOperateHistoryController {

    @Autowired
    private OmsOrderOperateHistoryService omsOrderOperateHistoryService;

    /***
     * OmsOrderOperateHistory分页条件搜索实现
     * @param omsOrderOperateHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false) OmsOrderOperateHistory omsOrderOperateHistory, @PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderOperateHistoryService实现分页条件查询OmsOrderOperateHistory
        PageInfo<OmsOrderOperateHistory> pageInfo = omsOrderOperateHistoryService.findPage(omsOrderOperateHistory, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * OmsOrderOperateHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderOperateHistoryService实现分页查询OmsOrderOperateHistory
        PageInfo<OmsOrderOperateHistory> pageInfo = omsOrderOperateHistoryService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param omsOrderOperateHistory
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  OmsOrderOperateHistory omsOrderOperateHistory){
        //调用OmsOrderOperateHistoryService实现条件查询OmsOrderOperateHistory
        List<OmsOrderOperateHistory> list = omsOrderOperateHistoryService.findList(omsOrderOperateHistory);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用OmsOrderOperateHistoryService实现根据主键删除
        omsOrderOperateHistoryService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改OmsOrderOperateHistory数据
     * @param omsOrderOperateHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OmsOrderOperateHistory omsOrderOperateHistory,@PathVariable Long id){
        //设置主键值
        omsOrderOperateHistory.setId(id);
        //调用OmsOrderOperateHistoryService实现修改OmsOrderOperateHistory
        omsOrderOperateHistoryService.update(omsOrderOperateHistory);
        return Result.ok("修改成功");
    }

    /***
     * 新增OmsOrderOperateHistory数据
     * @param omsOrderOperateHistory
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OmsOrderOperateHistory omsOrderOperateHistory){
        //调用OmsOrderOperateHistoryService实现添加OmsOrderOperateHistory
        omsOrderOperateHistoryService.add(omsOrderOperateHistory);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询OmsOrderOperateHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用OmsOrderOperateHistoryService实现根据主键查询OmsOrderOperateHistory
        OmsOrderOperateHistory omsOrderOperateHistory = omsOrderOperateHistoryService.findById(id);
        return Result.ok("查询成功", omsOrderOperateHistory);
    }

    /***
     * 查询OmsOrderOperateHistory全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用OmsOrderOperateHistoryService实现查询所有OmsOrderOperateHistory
        List<OmsOrderOperateHistory> list = omsOrderOperateHistoryService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
