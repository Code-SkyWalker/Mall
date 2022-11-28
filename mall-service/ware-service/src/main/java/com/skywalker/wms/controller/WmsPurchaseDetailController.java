package com.skywalker.wms.controller;
import com.skywalker.wms.pojo.WmsPurchaseDetail;
import com.skywalker.wms.service.WmsPurchaseDetailService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseDetailController
 * @Description TODO
 */

@RestController
@RequestMapping("/wmsPurchaseDetail")
@CrossOrigin
public class WmsPurchaseDetailController {

    @Autowired
    private WmsPurchaseDetailService wmsPurchaseDetailService;

    /***
     * WmsPurchaseDetail分页条件搜索实现
     * @param wmsPurchaseDetail
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  WmsPurchaseDetail wmsPurchaseDetail, @PathVariable  int page, @PathVariable  int size){
        //调用WmsPurchaseDetailService实现分页条件查询WmsPurchaseDetail
        PageInfo<WmsPurchaseDetail> pageInfo = wmsPurchaseDetailService.findPage(wmsPurchaseDetail, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * WmsPurchaseDetail分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WmsPurchaseDetailService实现分页查询WmsPurchaseDetail
        PageInfo<WmsPurchaseDetail> pageInfo = wmsPurchaseDetailService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wmsPurchaseDetail
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  WmsPurchaseDetail wmsPurchaseDetail){
        //调用WmsPurchaseDetailService实现条件查询WmsPurchaseDetail
        List<WmsPurchaseDetail> list = wmsPurchaseDetailService.findList(wmsPurchaseDetail);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WmsPurchaseDetailService实现根据主键删除
        wmsPurchaseDetailService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改WmsPurchaseDetail数据
     * @param wmsPurchaseDetail
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  WmsPurchaseDetail wmsPurchaseDetail,@PathVariable Long id){
        //设置主键值
        wmsPurchaseDetail.setId(id);
        //调用WmsPurchaseDetailService实现修改WmsPurchaseDetail
        wmsPurchaseDetailService.update(wmsPurchaseDetail);
        return Result.ok("修改成功");
    }

    /***
     * 新增WmsPurchaseDetail数据
     * @param wmsPurchaseDetail
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   WmsPurchaseDetail wmsPurchaseDetail){
        //调用WmsPurchaseDetailService实现添加WmsPurchaseDetail
        wmsPurchaseDetailService.add(wmsPurchaseDetail);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询WmsPurchaseDetail数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用WmsPurchaseDetailService实现根据主键查询WmsPurchaseDetail
        WmsPurchaseDetail wmsPurchaseDetail = wmsPurchaseDetailService.findById(id);
        return Result.ok("查询成功", wmsPurchaseDetail);
    }

    /***
     * 查询WmsPurchaseDetail全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用WmsPurchaseDetailService实现查询所有WmsPurchaseDetail
        List<WmsPurchaseDetail> list = wmsPurchaseDetailService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
