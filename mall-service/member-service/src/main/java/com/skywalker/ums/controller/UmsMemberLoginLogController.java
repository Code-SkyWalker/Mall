package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsMemberLoginLog;
import com.skywalker.ums.service.UmsMemberLoginLogService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLoginLogController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsMemberLoginLog")
@CrossOrigin
public class UmsMemberLoginLogController {

    @Autowired
    private UmsMemberLoginLogService umsMemberLoginLogService;

    /***
     * UmsMemberLoginLog分页条件搜索实现
     * @param umsMemberLoginLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsMemberLoginLog umsMemberLoginLog, @PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberLoginLogService实现分页条件查询UmsMemberLoginLog
        PageInfo<UmsMemberLoginLog> pageInfo = umsMemberLoginLogService.findPage(umsMemberLoginLog, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsMemberLoginLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberLoginLogService实现分页查询UmsMemberLoginLog
        PageInfo<UmsMemberLoginLog> pageInfo = umsMemberLoginLogService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsMemberLoginLog
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsMemberLoginLog umsMemberLoginLog){
        //调用UmsMemberLoginLogService实现条件查询UmsMemberLoginLog
        List<UmsMemberLoginLog> list = umsMemberLoginLogService.findList(umsMemberLoginLog);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsMemberLoginLogService实现根据主键删除
        umsMemberLoginLogService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsMemberLoginLog数据
     * @param umsMemberLoginLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsMemberLoginLog umsMemberLoginLog,@PathVariable Long id){
        //设置主键值
        umsMemberLoginLog.setId(id);
        //调用UmsMemberLoginLogService实现修改UmsMemberLoginLog
        umsMemberLoginLogService.update(umsMemberLoginLog);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsMemberLoginLog数据
     * @param umsMemberLoginLog
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsMemberLoginLog umsMemberLoginLog){
        //调用UmsMemberLoginLogService实现添加UmsMemberLoginLog
        umsMemberLoginLogService.add(umsMemberLoginLog);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsMemberLoginLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsMemberLoginLogService实现根据主键查询UmsMemberLoginLog
        UmsMemberLoginLog umsMemberLoginLog = umsMemberLoginLogService.findById(id);
        return Result.ok("查询成功", umsMemberLoginLog);
    }

    /***
     * 查询UmsMemberLoginLog全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsMemberLoginLogService实现查询所有UmsMemberLoginLog
        List<UmsMemberLoginLog> list = umsMemberLoginLogService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
