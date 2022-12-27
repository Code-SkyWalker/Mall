package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsHomeSubjectSpu;
import com.skywalker.sms.service.SmsHomeSubjectSpuService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectSpuController
 * @Description TODO
 */

@RestController
@RequestMapping("/homeSubjectSpu")
@CrossOrigin
public class SmsHomeSubjectSpuController {

    @Autowired
    private SmsHomeSubjectSpuService smsHomeSubjectSpuService;

    /***
     * SmsHomeSubjectSpu分页条件搜索实现
     * @param smsHomeSubjectSpu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsHomeSubjectSpu smsHomeSubjectSpu, @PathVariable  int page, @PathVariable  int size){
        //调用SmsHomeSubjectSpuService实现分页条件查询SmsHomeSubjectSpu
        PageInfo<SmsHomeSubjectSpu> pageInfo = smsHomeSubjectSpuService.findPage(smsHomeSubjectSpu, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsHomeSubjectSpu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsHomeSubjectSpuService实现分页查询SmsHomeSubjectSpu
        PageInfo<SmsHomeSubjectSpu> pageInfo = smsHomeSubjectSpuService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsHomeSubjectSpu
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsHomeSubjectSpu smsHomeSubjectSpu){
        //调用SmsHomeSubjectSpuService实现条件查询SmsHomeSubjectSpu
        List<SmsHomeSubjectSpu> list = smsHomeSubjectSpuService.findList(smsHomeSubjectSpu);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsHomeSubjectSpuService实现根据主键删除
        smsHomeSubjectSpuService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsHomeSubjectSpu数据
     * @param smsHomeSubjectSpu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsHomeSubjectSpu smsHomeSubjectSpu,@PathVariable Long id){
        //设置主键值
        smsHomeSubjectSpu.setId(id);
        //调用SmsHomeSubjectSpuService实现修改SmsHomeSubjectSpu
        smsHomeSubjectSpuService.update(smsHomeSubjectSpu);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsHomeSubjectSpu数据
     * @param smsHomeSubjectSpu
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsHomeSubjectSpu smsHomeSubjectSpu){
        //调用SmsHomeSubjectSpuService实现添加SmsHomeSubjectSpu
        smsHomeSubjectSpuService.add(smsHomeSubjectSpu);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsHomeSubjectSpu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsHomeSubjectSpuService实现根据主键查询SmsHomeSubjectSpu
        SmsHomeSubjectSpu smsHomeSubjectSpu = smsHomeSubjectSpuService.findById(id);
        return Result.ok("查询成功", smsHomeSubjectSpu);
    }

    /***
     * 查询SmsHomeSubjectSpu全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsHomeSubjectSpuService实现查询所有SmsHomeSubjectSpu
        List<SmsHomeSubjectSpu> list = smsHomeSubjectSpuService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
