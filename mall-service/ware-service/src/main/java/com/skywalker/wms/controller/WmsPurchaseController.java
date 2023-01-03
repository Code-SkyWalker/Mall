package com.skywalker.wms.controller;
import com.skywalker.wms.pojo.WmsPurchase;
import com.skywalker.wms.service.WmsPurchaseService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import com.skywalker.wms.vo.WarePurchaseDoneVo;
import com.skywalker.wms.vo.WarePurchaseMergeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseController
 * @Description TODO
 */

@RestController
@RequestMapping("/purchase")
public class WmsPurchaseController {

    @Autowired
    private WmsPurchaseService wmsPurchaseService;

    /***
     * WmsPurchase分页条件搜索实现
     * @param wmsPurchase
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  WmsPurchase wmsPurchase, @PathVariable  int page, @PathVariable  int size){
        //调用WmsPurchaseService实现分页条件查询WmsPurchase
        PageInfo<WmsPurchase> pageInfo = wmsPurchaseService.findPage(wmsPurchase, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * WmsPurchase分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WmsPurchaseService实现分页查询WmsPurchase
        PageInfo<WmsPurchase> pageInfo = wmsPurchaseService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wmsPurchase
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  WmsPurchase wmsPurchase){
        //调用WmsPurchaseService实现条件查询WmsPurchase
        List<WmsPurchase> list = wmsPurchaseService.findList(wmsPurchase);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WmsPurchaseService实现根据主键删除
        wmsPurchaseService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 根据ID删除批量删除数据
     * @param ids
     * @return
     */
    @PostMapping(value = "/delete" )
    public Result delete(@RequestBody List<Long> ids){
        //调用WmsPurchaseService实现根据主键删除
        wmsPurchaseService.deleteByIds(ids);
        return Result.ok("删除成功");
    }

    /***
     * 修改WmsPurchase数据
     * @param wmsPurchase
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  WmsPurchase wmsPurchase,@PathVariable Long id){
        //设置主键值
        wmsPurchase.setId(id);
        //调用WmsPurchaseService实现修改WmsPurchase
        wmsPurchaseService.update(wmsPurchase);
        return Result.ok("修改成功");
    }

    /***
     * 新增WmsPurchase数据
     * @param wmsPurchase
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   WmsPurchase wmsPurchase){
        //调用WmsPurchaseService实现添加WmsPurchase
        wmsPurchaseService.add(wmsPurchase);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询WmsPurchase数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用WmsPurchaseService实现根据主键查询WmsPurchase
        WmsPurchase wmsPurchase = wmsPurchaseService.findById(id);
        return Result.ok("查询成功", wmsPurchase);
    }

    /***
     * 查询WmsPurchase全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用WmsPurchaseService实现查询所有WmsPurchase
        List<WmsPurchase> list = wmsPurchaseService.findAll();
        return Result.ok("查询成功", list) ;
    }

    /**
     * 获取未受领的的 采购单
     * @return
     */
    @GetMapping("/unreceive/list")
    public Result findPurchaseUnrecevied() {
        List<WmsPurchase> wmsPurchases = wmsPurchaseService.findPerchaseUnrecevied();
        return Result.ok("查询成功", wmsPurchases);
    }

    /**
     * 合并采购单
     * @param warePurchaseMergeVo 合并采购vo对象
     * @return  /
     */
    @PostMapping("/merge")
    public Result merge(@RequestBody WarePurchaseMergeVo warePurchaseMergeVo) throws Exception {
        wmsPurchaseService.marge(warePurchaseMergeVo);
        return Result.ok("合并成功");
    }

    /**
     * 采购员领取采购单接口
     *
     */
    @PostMapping("/receive")
    public Result receive(@RequestBody List<Long> purchaseIds) throws Exception {
        wmsPurchaseService.receive(purchaseIds);
        return Result.ok();
    }

    /**
     * 采购完成
     * @param warePurchaseDoneVo 采购完成vo
     * @return
     */
    @PostMapping("/done")
    public Result done(@RequestBody WarePurchaseDoneVo warePurchaseDoneVo) {
        wmsPurchaseService.done(warePurchaseDoneVo);
        return Result.ok();
    }
}
