package com.skywalker.wms.controller;
import com.skywalker.wms.pojo.WmsWareSku;
import com.skywalker.wms.service.WmsWareSkuService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareSkuController
 * @Description TODO
 */

@RestController
@RequestMapping("/wareSku")
public class WmsWareSkuController {

    @Autowired
    private WmsWareSkuService wmsWareSkuService;

    /***
     * WmsWareSku分页条件搜索实现
     * @param wmsWareSku
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  WmsWareSku wmsWareSku, @PathVariable  int page, @PathVariable  int size){
        //调用WmsWareSkuService实现分页条件查询WmsWareSku
        PageInfo<WmsWareSku> pageInfo = wmsWareSkuService.findPage(wmsWareSku, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * WmsWareSku分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WmsWareSkuService实现分页查询WmsWareSku
        PageInfo<WmsWareSku> pageInfo = wmsWareSkuService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wmsWareSku
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  WmsWareSku wmsWareSku){
        //调用WmsWareSkuService实现条件查询WmsWareSku
        List<WmsWareSku> list = wmsWareSkuService.findList(wmsWareSku);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WmsWareSkuService实现根据主键删除
        wmsWareSkuService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改WmsWareSku数据
     * @param wmsWareSku
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  WmsWareSku wmsWareSku,@PathVariable Long id){
        //设置主键值
        wmsWareSku.setId(id);
        //调用WmsWareSkuService实现修改WmsWareSku
        wmsWareSkuService.update(wmsWareSku);
        return Result.ok("修改成功");
    }

    /***
     * 新增WmsWareSku数据
     * @param wmsWareSku
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   WmsWareSku wmsWareSku){
        //调用WmsWareSkuService实现添加WmsWareSku
        wmsWareSkuService.add(wmsWareSku);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询WmsWareSku数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用WmsWareSkuService实现根据主键查询WmsWareSku
        WmsWareSku wmsWareSku = wmsWareSkuService.findById(id);
        return Result.ok("查询成功", wmsWareSku);
    }

    /***
     * 查询WmsWareSku全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用WmsWareSkuService实现查询所有WmsWareSku
        List<WmsWareSku> list = wmsWareSkuService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
