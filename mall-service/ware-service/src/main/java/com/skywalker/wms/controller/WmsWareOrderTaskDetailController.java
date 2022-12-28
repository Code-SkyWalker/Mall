package com.skywalker.wms.controller;
import com.skywalker.wms.pojo.WmsWareOrderTaskDetail;
import com.skywalker.wms.service.WmsWareOrderTaskDetailService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskDetailController
 * @Description TODO
 */

@RestController
@RequestMapping("/wareOrderTaskDetail")
public class WmsWareOrderTaskDetailController {

    @Autowired
    private WmsWareOrderTaskDetailService wmsWareOrderTaskDetailService;

    /***
     * WmsWareOrderTaskDetail分页条件搜索实现
     * @param wmsWareOrderTaskDetail
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  WmsWareOrderTaskDetail wmsWareOrderTaskDetail, @PathVariable  int page, @PathVariable  int size){
        //调用WmsWareOrderTaskDetailService实现分页条件查询WmsWareOrderTaskDetail
        PageInfo<WmsWareOrderTaskDetail> pageInfo = wmsWareOrderTaskDetailService.findPage(wmsWareOrderTaskDetail, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * WmsWareOrderTaskDetail分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WmsWareOrderTaskDetailService实现分页查询WmsWareOrderTaskDetail
        PageInfo<WmsWareOrderTaskDetail> pageInfo = wmsWareOrderTaskDetailService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wmsWareOrderTaskDetail
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  WmsWareOrderTaskDetail wmsWareOrderTaskDetail){
        //调用WmsWareOrderTaskDetailService实现条件查询WmsWareOrderTaskDetail
        List<WmsWareOrderTaskDetail> list = wmsWareOrderTaskDetailService.findList(wmsWareOrderTaskDetail);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WmsWareOrderTaskDetailService实现根据主键删除
        wmsWareOrderTaskDetailService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改WmsWareOrderTaskDetail数据
     * @param wmsWareOrderTaskDetail
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  WmsWareOrderTaskDetail wmsWareOrderTaskDetail,@PathVariable Long id){
        //设置主键值
        wmsWareOrderTaskDetail.setId(id);
        //调用WmsWareOrderTaskDetailService实现修改WmsWareOrderTaskDetail
        wmsWareOrderTaskDetailService.update(wmsWareOrderTaskDetail);
        return Result.ok("修改成功");
    }

    /***
     * 新增WmsWareOrderTaskDetail数据
     * @param wmsWareOrderTaskDetail
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   WmsWareOrderTaskDetail wmsWareOrderTaskDetail){
        //调用WmsWareOrderTaskDetailService实现添加WmsWareOrderTaskDetail
        wmsWareOrderTaskDetailService.add(wmsWareOrderTaskDetail);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询WmsWareOrderTaskDetail数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用WmsWareOrderTaskDetailService实现根据主键查询WmsWareOrderTaskDetail
        WmsWareOrderTaskDetail wmsWareOrderTaskDetail = wmsWareOrderTaskDetailService.findById(id);
        return Result.ok("查询成功", wmsWareOrderTaskDetail);
    }

    /***
     * 查询WmsWareOrderTaskDetail全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用WmsWareOrderTaskDetailService实现查询所有WmsWareOrderTaskDetail
        List<WmsWareOrderTaskDetail> list = wmsWareOrderTaskDetailService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
