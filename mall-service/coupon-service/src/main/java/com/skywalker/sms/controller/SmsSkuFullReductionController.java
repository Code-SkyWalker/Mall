package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsSkuFullReduction;
import com.skywalker.sms.service.SmsSkuFullReductionService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsSkuFullReductionController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsSkuFullReduction")
@CrossOrigin
public class SmsSkuFullReductionController {

    @Autowired
    private SmsSkuFullReductionService smsSkuFullReductionService;

    /***
     * SmsSkuFullReduction分页条件搜索实现
     * @param smsSkuFullReduction
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsSkuFullReduction smsSkuFullReduction, @PathVariable  int page, @PathVariable  int size){
        //调用SmsSkuFullReductionService实现分页条件查询SmsSkuFullReduction
        PageInfo<SmsSkuFullReduction> pageInfo = smsSkuFullReductionService.findPage(smsSkuFullReduction, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsSkuFullReduction分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsSkuFullReductionService实现分页查询SmsSkuFullReduction
        PageInfo<SmsSkuFullReduction> pageInfo = smsSkuFullReductionService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsSkuFullReduction
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsSkuFullReduction smsSkuFullReduction){
        //调用SmsSkuFullReductionService实现条件查询SmsSkuFullReduction
        List<SmsSkuFullReduction> list = smsSkuFullReductionService.findList(smsSkuFullReduction);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsSkuFullReductionService实现根据主键删除
        smsSkuFullReductionService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsSkuFullReduction数据
     * @param smsSkuFullReduction
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsSkuFullReduction smsSkuFullReduction,@PathVariable Long id){
        //设置主键值
        smsSkuFullReduction.setId(id);
        //调用SmsSkuFullReductionService实现修改SmsSkuFullReduction
        smsSkuFullReductionService.update(smsSkuFullReduction);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsSkuFullReduction数据
     * @param smsSkuFullReduction
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsSkuFullReduction smsSkuFullReduction){
        //调用SmsSkuFullReductionService实现添加SmsSkuFullReduction
        smsSkuFullReductionService.add(smsSkuFullReduction);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsSkuFullReduction数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsSkuFullReductionService实现根据主键查询SmsSkuFullReduction
        SmsSkuFullReduction smsSkuFullReduction = smsSkuFullReductionService.findById(id);
        return Result.ok("查询成功", smsSkuFullReduction);
    }

    /***
     * 查询SmsSkuFullReduction全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsSkuFullReductionService实现查询所有SmsSkuFullReduction
        List<SmsSkuFullReduction> list = smsSkuFullReductionService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
