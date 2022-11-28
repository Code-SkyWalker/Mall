package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsHomeAdv;
import com.skywalker.sms.service.SmsHomeAdvService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsHomeAdvController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsHomeAdv")
@CrossOrigin
public class SmsHomeAdvController {

    @Autowired
    private SmsHomeAdvService smsHomeAdvService;

    /***
     * SmsHomeAdv分页条件搜索实现
     * @param smsHomeAdv
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsHomeAdv smsHomeAdv, @PathVariable  int page, @PathVariable  int size){
        //调用SmsHomeAdvService实现分页条件查询SmsHomeAdv
        PageInfo<SmsHomeAdv> pageInfo = smsHomeAdvService.findPage(smsHomeAdv, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsHomeAdv分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsHomeAdvService实现分页查询SmsHomeAdv
        PageInfo<SmsHomeAdv> pageInfo = smsHomeAdvService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsHomeAdv
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsHomeAdv smsHomeAdv){
        //调用SmsHomeAdvService实现条件查询SmsHomeAdv
        List<SmsHomeAdv> list = smsHomeAdvService.findList(smsHomeAdv);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsHomeAdvService实现根据主键删除
        smsHomeAdvService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsHomeAdv数据
     * @param smsHomeAdv
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsHomeAdv smsHomeAdv,@PathVariable Long id){
        //设置主键值
        smsHomeAdv.setId(id);
        //调用SmsHomeAdvService实现修改SmsHomeAdv
        smsHomeAdvService.update(smsHomeAdv);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsHomeAdv数据
     * @param smsHomeAdv
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsHomeAdv smsHomeAdv){
        //调用SmsHomeAdvService实现添加SmsHomeAdv
        smsHomeAdvService.add(smsHomeAdv);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsHomeAdv数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsHomeAdvService实现根据主键查询SmsHomeAdv
        SmsHomeAdv smsHomeAdv = smsHomeAdvService.findById(id);
        return Result.ok("查询成功", smsHomeAdv);
    }

    /***
     * 查询SmsHomeAdv全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsHomeAdvService实现查询所有SmsHomeAdv
        List<SmsHomeAdv> list = smsHomeAdvService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
