package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsSkuLadder;
import com.skywalker.sms.service.SmsSkuLadderService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsSkuLadderController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsSkuLadder")
@CrossOrigin
public class SmsSkuLadderController {

    @Autowired
    private SmsSkuLadderService smsSkuLadderService;

    /***
     * SmsSkuLadder分页条件搜索实现
     * @param smsSkuLadder
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsSkuLadder smsSkuLadder, @PathVariable  int page, @PathVariable  int size){
        //调用SmsSkuLadderService实现分页条件查询SmsSkuLadder
        PageInfo<SmsSkuLadder> pageInfo = smsSkuLadderService.findPage(smsSkuLadder, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsSkuLadder分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsSkuLadderService实现分页查询SmsSkuLadder
        PageInfo<SmsSkuLadder> pageInfo = smsSkuLadderService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsSkuLadder
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsSkuLadder smsSkuLadder){
        //调用SmsSkuLadderService实现条件查询SmsSkuLadder
        List<SmsSkuLadder> list = smsSkuLadderService.findList(smsSkuLadder);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsSkuLadderService实现根据主键删除
        smsSkuLadderService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsSkuLadder数据
     * @param smsSkuLadder
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsSkuLadder smsSkuLadder,@PathVariable Long id){
        //设置主键值
        smsSkuLadder.setId(id);
        //调用SmsSkuLadderService实现修改SmsSkuLadder
        smsSkuLadderService.update(smsSkuLadder);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsSkuLadder数据
     * @param smsSkuLadder
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsSkuLadder smsSkuLadder){
        //调用SmsSkuLadderService实现添加SmsSkuLadder
        smsSkuLadderService.add(smsSkuLadder);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsSkuLadder数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsSkuLadderService实现根据主键查询SmsSkuLadder
        SmsSkuLadder smsSkuLadder = smsSkuLadderService.findById(id);
        return Result.ok("查询成功", smsSkuLadder);
    }

    /***
     * 查询SmsSkuLadder全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsSkuLadderService实现查询所有SmsSkuLadder
        List<SmsSkuLadder> list = smsSkuLadderService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
