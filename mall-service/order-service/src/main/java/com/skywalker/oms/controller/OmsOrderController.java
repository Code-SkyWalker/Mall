package com.skywalker.oms.controller;

import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrder;
import com.skywalker.oms.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderController
 * @Description TODO
 */

@RestController
@RequestMapping("/omsOrder")
@CrossOrigin
public class OmsOrderController {

    @Autowired
    private OmsOrderService omsOrderService;

    /***
     * OmsOrder分页条件搜索实现
     * @param omsOrder
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  OmsOrder omsOrder, @PathVariable int page, @PathVariable  int size){
        //调用OmsOrderService实现分页条件查询OmsOrder
        PageInfo pageInfo = omsOrderService.findPage(omsOrder, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * OmsOrder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OmsOrderService实现分页查询OmsOrder
        PageInfo<OmsOrder> pageInfo = omsOrderService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param omsOrder
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  OmsOrder omsOrder){
        //调用OmsOrderService实现条件查询OmsOrder
        List<OmsOrder> list = omsOrderService.findList(omsOrder);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用OmsOrderService实现根据主键删除
        omsOrderService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改OmsOrder数据
     * @param omsOrder
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody OmsOrder omsOrder,@PathVariable Long id){
        //设置主键值
        omsOrder.setId(id);
        //调用OmsOrderService实现修改OmsOrder
        omsOrderService.update(omsOrder);
        return Result.ok("修改成功");
    }

    /***
     * 新增OmsOrder数据
     * @param omsOrder
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   OmsOrder omsOrder){
        //调用OmsOrderService实现添加OmsOrder
        omsOrderService.add(omsOrder);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询OmsOrder数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用OmsOrderService实现根据主键查询OmsOrder
        OmsOrder omsOrder = omsOrderService.findById(id);
        return Result.ok("查询成功", omsOrder);
    }

    /***
     * 查询OmsOrder全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用OmsOrderService实现查询所有OmsOrder
        List<OmsOrder> list = omsOrderService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
