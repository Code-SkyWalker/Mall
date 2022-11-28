package com.skywalker.oms.controller;

import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderSetting;
import com.skywalker.oms.service.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderSettingController
 * @Description TODO
 */

@RestController
@RequestMapping("/omsOrderSetting")
@CrossOrigin
public class OmsOrderSettingController {

    @Autowired
    private OmsOrderSettingService omsOrderSettingService;

    /***
     * OmsOrderSetting分页条件搜索实现
     * @param omsOrderSetting
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  OmsOrderSetting omsOrderSetting, @PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderSettingService实现分页条件查询OmsOrderSetting
        PageInfo pageInfo = omsOrderSettingService.findPage(omsOrderSetting, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * OmsOrderSetting分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderSettingService实现分页查询OmsOrderSetting
        PageInfo<OmsOrderSetting> pageInfo = omsOrderSettingService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param omsOrderSetting
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  OmsOrderSetting omsOrderSetting){
        //调用OmsOrderSettingService实现条件查询OmsOrderSetting
        List<OmsOrderSetting> list = omsOrderSettingService.findList(omsOrderSetting);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用OmsOrderSettingService实现根据主键删除
        omsOrderSettingService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改OmsOrderSetting数据
     * @param omsOrderSetting
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OmsOrderSetting omsOrderSetting,@PathVariable Long id){
        //设置主键值
        omsOrderSetting.setId(id);
        //调用OmsOrderSettingService实现修改OmsOrderSetting
        omsOrderSettingService.update(omsOrderSetting);
        return Result.ok("修改成功");
    }

    /***
     * 新增OmsOrderSetting数据
     * @param omsOrderSetting
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OmsOrderSetting omsOrderSetting){
        //调用OmsOrderSettingService实现添加OmsOrderSetting
        omsOrderSettingService.add(omsOrderSetting);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询OmsOrderSetting数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用OmsOrderSettingService实现根据主键查询OmsOrderSetting
        OmsOrderSetting omsOrderSetting = omsOrderSettingService.findById(id);
        return Result.ok("查询成功", omsOrderSetting);
    }

    /***
     * 查询OmsOrderSetting全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用OmsOrderSettingService实现查询所有OmsOrderSetting
        List<OmsOrderSetting> list = omsOrderSettingService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
