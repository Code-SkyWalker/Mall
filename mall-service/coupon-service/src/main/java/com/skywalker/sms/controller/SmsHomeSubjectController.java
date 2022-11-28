package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsHomeSubject;
import com.skywalker.sms.service.SmsHomeSubjectService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsHomeSubject")
@CrossOrigin
public class SmsHomeSubjectController {

    @Autowired
    private SmsHomeSubjectService smsHomeSubjectService;

    /***
     * SmsHomeSubject分页条件搜索实现
     * @param smsHomeSubject
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsHomeSubject smsHomeSubject, @PathVariable  int page, @PathVariable  int size){
        //调用SmsHomeSubjectService实现分页条件查询SmsHomeSubject
        PageInfo<SmsHomeSubject> pageInfo = smsHomeSubjectService.findPage(smsHomeSubject, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsHomeSubject分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsHomeSubjectService实现分页查询SmsHomeSubject
        PageInfo<SmsHomeSubject> pageInfo = smsHomeSubjectService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsHomeSubject
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsHomeSubject smsHomeSubject){
        //调用SmsHomeSubjectService实现条件查询SmsHomeSubject
        List<SmsHomeSubject> list = smsHomeSubjectService.findList(smsHomeSubject);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsHomeSubjectService实现根据主键删除
        smsHomeSubjectService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsHomeSubject数据
     * @param smsHomeSubject
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsHomeSubject smsHomeSubject,@PathVariable Long id){
        //设置主键值
        smsHomeSubject.setId(id);
        //调用SmsHomeSubjectService实现修改SmsHomeSubject
        smsHomeSubjectService.update(smsHomeSubject);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsHomeSubject数据
     * @param smsHomeSubject
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsHomeSubject smsHomeSubject){
        //调用SmsHomeSubjectService实现添加SmsHomeSubject
        smsHomeSubjectService.add(smsHomeSubject);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsHomeSubject数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsHomeSubjectService实现根据主键查询SmsHomeSubject
        SmsHomeSubject smsHomeSubject = smsHomeSubjectService.findById(id);
        return Result.ok("查询成功", smsHomeSubject);
    }

    /***
     * 查询SmsHomeSubject全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsHomeSubjectService实现查询所有SmsHomeSubject
        List<SmsHomeSubject> list = smsHomeSubjectService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
