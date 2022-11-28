package com.skywalker.oms.controller;

import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderReturnApply;
import com.skywalker.oms.service.OmsOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnApplyController
 * @Description TODO
 */

@RestController
@RequestMapping("/omsOrderReturnApply")
@CrossOrigin
public class OmsOrderReturnApplyController {

    @Autowired
    private OmsOrderReturnApplyService omsOrderReturnApplyService;

    /***
     * OmsOrderReturnApply分页条件搜索实现
     * @param omsOrderReturnApply
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false) OmsOrderReturnApply omsOrderReturnApply, @PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderReturnApplyService实现分页条件查询OmsOrderReturnApply
        PageInfo pageInfo = omsOrderReturnApplyService.findPage(omsOrderReturnApply, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * OmsOrderReturnApply分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderReturnApplyService实现分页查询OmsOrderReturnApply
        PageInfo<OmsOrderReturnApply> pageInfo = omsOrderReturnApplyService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param omsOrderReturnApply
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  OmsOrderReturnApply omsOrderReturnApply){
        //调用OmsOrderReturnApplyService实现条件查询OmsOrderReturnApply
        List<OmsOrderReturnApply> list = omsOrderReturnApplyService.findList(omsOrderReturnApply);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用OmsOrderReturnApplyService实现根据主键删除
        omsOrderReturnApplyService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改OmsOrderReturnApply数据
     * @param omsOrderReturnApply
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  OmsOrderReturnApply omsOrderReturnApply,@PathVariable Long id){
        //设置主键值
        omsOrderReturnApply.setId(id);
        //调用OmsOrderReturnApplyService实现修改OmsOrderReturnApply
        omsOrderReturnApplyService.update(omsOrderReturnApply);
        return Result.ok("修改成功");
    }

    /***
     * 新增OmsOrderReturnApply数据
     * @param omsOrderReturnApply
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OmsOrderReturnApply omsOrderReturnApply){
        //调用OmsOrderReturnApplyService实现添加OmsOrderReturnApply
        omsOrderReturnApplyService.add(omsOrderReturnApply);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询OmsOrderReturnApply数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用OmsOrderReturnApplyService实现根据主键查询OmsOrderReturnApply
        OmsOrderReturnApply omsOrderReturnApply = omsOrderReturnApplyService.findById(id);
        return Result.ok("查询成功", omsOrderReturnApply);
    }

    /***
     * 查询OmsOrderReturnApply全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用OmsOrderReturnApplyService实现查询所有OmsOrderReturnApply
        List<OmsOrderReturnApply> list = omsOrderReturnApplyService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
