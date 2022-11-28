package com.skywalker.oms.controller;

import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderReturnReason;
import com.skywalker.oms.service.OmsOrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnReasonController
 * @Description TODO
 */

@RestController
@RequestMapping("/omsOrderReturnReason")
@CrossOrigin
public class OmsOrderReturnReasonController {

    @Autowired
    private OmsOrderReturnReasonService omsOrderReturnReasonService;

    /***
     * OmsOrderReturnReason分页条件搜索实现
     * @param omsOrderReturnReason
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  OmsOrderReturnReason omsOrderReturnReason, @PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderReturnReasonService实现分页条件查询OmsOrderReturnReason
        PageInfo pageInfo = omsOrderReturnReasonService.findPage(omsOrderReturnReason, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * OmsOrderReturnReason分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderReturnReasonService实现分页查询OmsOrderReturnReason
        PageInfo<OmsOrderReturnReason> pageInfo = omsOrderReturnReasonService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param omsOrderReturnReason
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  OmsOrderReturnReason omsOrderReturnReason){
        //调用OmsOrderReturnReasonService实现条件查询OmsOrderReturnReason
        List<OmsOrderReturnReason> list = omsOrderReturnReasonService.findList(omsOrderReturnReason);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用OmsOrderReturnReasonService实现根据主键删除
        omsOrderReturnReasonService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改OmsOrderReturnReason数据
     * @param omsOrderReturnReason
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OmsOrderReturnReason omsOrderReturnReason,@PathVariable Long id){
        //设置主键值
        omsOrderReturnReason.setId(id);
        //调用OmsOrderReturnReasonService实现修改OmsOrderReturnReason
        omsOrderReturnReasonService.update(omsOrderReturnReason);
        return Result.ok("修改成功");
    }

    /***
     * 新增OmsOrderReturnReason数据
     * @param omsOrderReturnReason
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OmsOrderReturnReason omsOrderReturnReason){
        //调用OmsOrderReturnReasonService实现添加OmsOrderReturnReason
        omsOrderReturnReasonService.add(omsOrderReturnReason);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询OmsOrderReturnReason数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用OmsOrderReturnReasonService实现根据主键查询OmsOrderReturnReason
        OmsOrderReturnReason omsOrderReturnReason = omsOrderReturnReasonService.findById(id);
        return Result.ok("查询成功", omsOrderReturnReason);
    }

    /***
     * 查询OmsOrderReturnReason全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用OmsOrderReturnReasonService实现查询所有OmsOrderReturnReason
        List<OmsOrderReturnReason> list = omsOrderReturnReasonService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
