package com.skywalker.oms.controller;

import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;
import com.skywalker.oms.pojo.OmsOrderItem;
import com.skywalker.oms.service.OmsOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderItemController
 * @Description TODO
 */

@RestController
@RequestMapping("/omsOrderItem")
@CrossOrigin
public class OmsOrderItemController {

    @Autowired
    private OmsOrderItemService omsOrderItemService;

    /***
     * OmsOrderItem分页条件搜索实现
     * @param omsOrderItem
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result findPage(@RequestBody(required = false) OmsOrderItem omsOrderItem, @PathVariable int page, @PathVariable int size) {
        //调用OmsOrderItemService实现分页条件查询OmsOrderItem
        PageInfo pageInfo = omsOrderItemService.findPage(omsOrderItem, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * OmsOrderItem分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result findPage(@PathVariable int page, @PathVariable int size) {
        //调用OmsOrderItemService实现分页查询OmsOrderItem
        PageInfo<OmsOrderItem> pageInfo = omsOrderItemService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param omsOrderItem
     * @return
     */
    @PostMapping(value = "/search")
    public Result findList(@RequestBody(required = false) OmsOrderItem omsOrderItem) {
        //调用OmsOrderItemService实现条件查询OmsOrderItem
        List<OmsOrderItem> list = omsOrderItemService.findList(omsOrderItem);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Long id) {
        //调用OmsOrderItemService实现根据主键删除
        omsOrderItemService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改OmsOrderItem数据
     * @param omsOrderItem
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody OmsOrderItem omsOrderItem, @PathVariable Long id) {
        //设置主键值
        omsOrderItem.setId(id);
        //调用OmsOrderItemService实现修改OmsOrderItem
        omsOrderItemService.update(omsOrderItem);
        return Result.ok("修改成功");
    }

    /***
     * 新增OmsOrderItem数据
     * @param omsOrderItem
     * @return
     */
    @PostMapping
    public Result add(@RequestBody OmsOrderItem omsOrderItem) {
        //调用OmsOrderItemService实现添加OmsOrderItem
        omsOrderItemService.add(omsOrderItem);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询OmsOrderItem数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id) {
        //调用OmsOrderItemService实现根据主键查询OmsOrderItem
        OmsOrderItem omsOrderItem = omsOrderItemService.findById(id);
        return Result.ok("查询成功", omsOrderItem);
    }

    /***
     * 查询OmsOrderItem全部数据
     * @return
     */
    @GetMapping
    public Result findAll() {
        //调用OmsOrderItemService实现查询所有OmsOrderItem
        List<OmsOrderItem> list = omsOrderItemService.findAll();
        return Result.ok("查询成功", list);
    }
}
