package com.skywalker.oms.controller;

import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsRefundInfo;
import com.skywalker.oms.service.OmsRefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname OmsRefundInfoController
 * @Description TODO
 */

@RestController
@RequestMapping("/omsRefundInfo")
@CrossOrigin
public class OmsRefundInfoController {

    @Autowired
    private OmsRefundInfoService omsRefundInfoService;

    /***
     * OmsRefundInfo分页条件搜索实现
     * @param omsRefundInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  OmsRefundInfo omsRefundInfo, @PathVariable  int page, @PathVariable  int size){
        //调用OmsRefundInfoService实现分页条件查询OmsRefundInfo
        PageInfo<OmsRefundInfo> pageInfo = omsRefundInfoService.findPage(omsRefundInfo, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * OmsRefundInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OmsRefundInfoService实现分页查询OmsRefundInfo
        PageInfo<OmsRefundInfo> pageInfo = omsRefundInfoService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param omsRefundInfo
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  OmsRefundInfo omsRefundInfo){
        //调用OmsRefundInfoService实现条件查询OmsRefundInfo
        List<OmsRefundInfo> list = omsRefundInfoService.findList(omsRefundInfo);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用OmsRefundInfoService实现根据主键删除
        omsRefundInfoService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改OmsRefundInfo数据
     * @param omsRefundInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OmsRefundInfo omsRefundInfo,@PathVariable Long id){
        //设置主键值
        omsRefundInfo.setId(id);
        //调用OmsRefundInfoService实现修改OmsRefundInfo
        omsRefundInfoService.update(omsRefundInfo);
        return Result.ok("修改成功");
    }

    /***
     * 新增OmsRefundInfo数据
     * @param omsRefundInfo
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OmsRefundInfo omsRefundInfo){
        //调用OmsRefundInfoService实现添加OmsRefundInfo
        omsRefundInfoService.add(omsRefundInfo);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询OmsRefundInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用OmsRefundInfoService实现根据主键查询OmsRefundInfo
        OmsRefundInfo omsRefundInfo = omsRefundInfoService.findById(id);
        return Result.ok("查询成功", omsRefundInfo);
    }

    /***
     * 查询OmsRefundInfo全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用OmsRefundInfoService实现查询所有OmsRefundInfo
        List<OmsRefundInfo> list = omsRefundInfoService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
