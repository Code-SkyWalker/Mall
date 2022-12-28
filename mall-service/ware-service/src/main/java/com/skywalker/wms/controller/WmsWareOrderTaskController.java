package com.skywalker.wms.controller;
import com.skywalker.wms.pojo.WmsWareOrderTask;
import com.skywalker.wms.service.WmsWareOrderTaskService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskController
 * @Description TODO
 */

@RestController
@RequestMapping("/wareOrderTask")
public class WmsWareOrderTaskController {

    @Autowired
    private WmsWareOrderTaskService wmsWareOrderTaskService;

    /***
     * WmsWareOrderTask分页条件搜索实现
     * @param wmsWareOrderTask
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  WmsWareOrderTask wmsWareOrderTask, @PathVariable  int page, @PathVariable  int size){
        //调用WmsWareOrderTaskService实现分页条件查询WmsWareOrderTask
        PageInfo<WmsWareOrderTask> pageInfo = wmsWareOrderTaskService.findPage(wmsWareOrderTask, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * WmsWareOrderTask分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WmsWareOrderTaskService实现分页查询WmsWareOrderTask
        PageInfo<WmsWareOrderTask> pageInfo = wmsWareOrderTaskService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wmsWareOrderTask
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  WmsWareOrderTask wmsWareOrderTask){
        //调用WmsWareOrderTaskService实现条件查询WmsWareOrderTask
        List<WmsWareOrderTask> list = wmsWareOrderTaskService.findList(wmsWareOrderTask);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WmsWareOrderTaskService实现根据主键删除
        wmsWareOrderTaskService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改WmsWareOrderTask数据
     * @param wmsWareOrderTask
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  WmsWareOrderTask wmsWareOrderTask,@PathVariable Long id){
        //设置主键值
        wmsWareOrderTask.setId(id);
        //调用WmsWareOrderTaskService实现修改WmsWareOrderTask
        wmsWareOrderTaskService.update(wmsWareOrderTask);
        return Result.ok("修改成功");
    }

    /***
     * 新增WmsWareOrderTask数据
     * @param wmsWareOrderTask
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   WmsWareOrderTask wmsWareOrderTask){
        //调用WmsWareOrderTaskService实现添加WmsWareOrderTask
        wmsWareOrderTaskService.add(wmsWareOrderTask);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询WmsWareOrderTask数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用WmsWareOrderTaskService实现根据主键查询WmsWareOrderTask
        WmsWareOrderTask wmsWareOrderTask = wmsWareOrderTaskService.findById(id);
        return Result.ok("查询成功", wmsWareOrderTask);
    }

    /***
     * 查询WmsWareOrderTask全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用WmsWareOrderTaskService实现查询所有WmsWareOrderTask
        List<WmsWareOrderTask> list = wmsWareOrderTaskService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
