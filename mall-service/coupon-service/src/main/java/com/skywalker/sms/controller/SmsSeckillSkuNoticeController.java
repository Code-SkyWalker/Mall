package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsSeckillSkuNotice;
import com.skywalker.sms.service.SmsSeckillSkuNoticeService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuNoticeController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsSeckillSkuNotice")
@CrossOrigin
public class SmsSeckillSkuNoticeController {

    @Autowired
    private SmsSeckillSkuNoticeService smsSeckillSkuNoticeService;

    /***
     * SmsSeckillSkuNotice分页条件搜索实现
     * @param smsSeckillSkuNotice
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsSeckillSkuNotice smsSeckillSkuNotice, @PathVariable  int page, @PathVariable  int size){
        //调用SmsSeckillSkuNoticeService实现分页条件查询SmsSeckillSkuNotice
        PageInfo<SmsSeckillSkuNotice> pageInfo = smsSeckillSkuNoticeService.findPage(smsSeckillSkuNotice, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsSeckillSkuNotice分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsSeckillSkuNoticeService实现分页查询SmsSeckillSkuNotice
        PageInfo<SmsSeckillSkuNotice> pageInfo = smsSeckillSkuNoticeService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsSeckillSkuNotice
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsSeckillSkuNotice smsSeckillSkuNotice){
        //调用SmsSeckillSkuNoticeService实现条件查询SmsSeckillSkuNotice
        List<SmsSeckillSkuNotice> list = smsSeckillSkuNoticeService.findList(smsSeckillSkuNotice);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsSeckillSkuNoticeService实现根据主键删除
        smsSeckillSkuNoticeService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsSeckillSkuNotice数据
     * @param smsSeckillSkuNotice
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsSeckillSkuNotice smsSeckillSkuNotice,@PathVariable Long id){
        //设置主键值
        smsSeckillSkuNotice.setId(id);
        //调用SmsSeckillSkuNoticeService实现修改SmsSeckillSkuNotice
        smsSeckillSkuNoticeService.update(smsSeckillSkuNotice);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsSeckillSkuNotice数据
     * @param smsSeckillSkuNotice
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsSeckillSkuNotice smsSeckillSkuNotice){
        //调用SmsSeckillSkuNoticeService实现添加SmsSeckillSkuNotice
        smsSeckillSkuNoticeService.add(smsSeckillSkuNotice);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsSeckillSkuNotice数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsSeckillSkuNoticeService实现根据主键查询SmsSeckillSkuNotice
        SmsSeckillSkuNotice smsSeckillSkuNotice = smsSeckillSkuNoticeService.findById(id);
        return Result.ok("查询成功", smsSeckillSkuNotice);
    }

    /***
     * 查询SmsSeckillSkuNotice全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsSeckillSkuNoticeService实现查询所有SmsSeckillSkuNotice
        List<SmsSeckillSkuNotice> list = smsSeckillSkuNoticeService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
