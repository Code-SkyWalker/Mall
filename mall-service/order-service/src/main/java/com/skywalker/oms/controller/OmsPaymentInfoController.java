package com.skywalker.oms.controller;

import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsPaymentInfo;
import com.skywalker.oms.service.OmsPaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname OmsPaymentInfoController
 * @Description TODO
 */

@RestController
@RequestMapping("/omsPaymentInfo")
@CrossOrigin
public class OmsPaymentInfoController {

    @Autowired
    private OmsPaymentInfoService omsPaymentInfoService;

    /***
     * OmsPaymentInfo分页条件搜索实现
     * @param omsPaymentInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  OmsPaymentInfo omsPaymentInfo, @PathVariable  int page, @PathVariable  int size){
        //调用OmsPaymentInfoService实现分页条件查询OmsPaymentInfo
        PageInfo pageInfo = omsPaymentInfoService.findPage(omsPaymentInfo, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * OmsPaymentInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OmsPaymentInfoService实现分页查询OmsPaymentInfo
        PageInfo<OmsPaymentInfo> pageInfo = omsPaymentInfoService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param omsPaymentInfo
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  OmsPaymentInfo omsPaymentInfo){
        //调用OmsPaymentInfoService实现条件查询OmsPaymentInfo
        List<OmsPaymentInfo> list = omsPaymentInfoService.findList(omsPaymentInfo);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用OmsPaymentInfoService实现根据主键删除
        omsPaymentInfoService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改OmsPaymentInfo数据
     * @param omsPaymentInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OmsPaymentInfo omsPaymentInfo,@PathVariable Long id){
        //设置主键值
        omsPaymentInfo.setId(id);
        //调用OmsPaymentInfoService实现修改OmsPaymentInfo
        omsPaymentInfoService.update(omsPaymentInfo);
        return Result.ok("修改成功");
    }

    /***
     * 新增OmsPaymentInfo数据
     * @param omsPaymentInfo
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OmsPaymentInfo omsPaymentInfo){
        //调用OmsPaymentInfoService实现添加OmsPaymentInfo
        omsPaymentInfoService.add(omsPaymentInfo);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询OmsPaymentInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用OmsPaymentInfoService实现根据主键查询OmsPaymentInfo
        OmsPaymentInfo omsPaymentInfo = omsPaymentInfoService.findById(id);
        return Result.ok("查询成功", omsPaymentInfo);
    }

    /***
     * 查询OmsPaymentInfo全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用OmsPaymentInfoService实现查询所有OmsPaymentInfo
        List<OmsPaymentInfo> list = omsPaymentInfoService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
