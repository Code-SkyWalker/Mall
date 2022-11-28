package com.skywalker.wms.controller;
import com.skywalker.wms.pojo.WmsWareInfo;
import com.skywalker.wms.service.WmsWareInfoService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareInfoController
 * @Description TODO
 */

@RestController
@RequestMapping("/wmsWareInfo")
@CrossOrigin
public class WmsWareInfoController {

    @Autowired
    private WmsWareInfoService wmsWareInfoService;

    /***
     * WmsWareInfo分页条件搜索实现
     * @param wmsWareInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  WmsWareInfo wmsWareInfo, @PathVariable  int page, @PathVariable  int size){
        //调用WmsWareInfoService实现分页条件查询WmsWareInfo
        PageInfo<WmsWareInfo> pageInfo = wmsWareInfoService.findPage(wmsWareInfo, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * WmsWareInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WmsWareInfoService实现分页查询WmsWareInfo
        PageInfo<WmsWareInfo> pageInfo = wmsWareInfoService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wmsWareInfo
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  WmsWareInfo wmsWareInfo){
        //调用WmsWareInfoService实现条件查询WmsWareInfo
        List<WmsWareInfo> list = wmsWareInfoService.findList(wmsWareInfo);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WmsWareInfoService实现根据主键删除
        wmsWareInfoService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改WmsWareInfo数据
     * @param wmsWareInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  WmsWareInfo wmsWareInfo,@PathVariable Long id){
        //设置主键值
        wmsWareInfo.setId(id);
        //调用WmsWareInfoService实现修改WmsWareInfo
        wmsWareInfoService.update(wmsWareInfo);
        return Result.ok("修改成功");
    }

    /***
     * 新增WmsWareInfo数据
     * @param wmsWareInfo
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   WmsWareInfo wmsWareInfo){
        //调用WmsWareInfoService实现添加WmsWareInfo
        wmsWareInfoService.add(wmsWareInfo);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询WmsWareInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用WmsWareInfoService实现根据主键查询WmsWareInfo
        WmsWareInfo wmsWareInfo = wmsWareInfoService.findById(id);
        return Result.ok("查询成功", wmsWareInfo);
    }

    /***
     * 查询WmsWareInfo全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用WmsWareInfoService实现查询所有WmsWareInfo
        List<WmsWareInfo> list = wmsWareInfoService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
