package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsSeckillSession;
import com.skywalker.sms.service.SmsSeckillSessionService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSessionController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsSeckillSession")
@CrossOrigin
public class SmsSeckillSessionController {

    @Autowired
    private SmsSeckillSessionService smsSeckillSessionService;

    /***
     * SmsSeckillSession分页条件搜索实现
     * @param smsSeckillSession
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsSeckillSession smsSeckillSession, @PathVariable  int page, @PathVariable  int size){
        //调用SmsSeckillSessionService实现分页条件查询SmsSeckillSession
        PageInfo<SmsSeckillSession> pageInfo = smsSeckillSessionService.findPage(smsSeckillSession, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsSeckillSession分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsSeckillSessionService实现分页查询SmsSeckillSession
        PageInfo<SmsSeckillSession> pageInfo = smsSeckillSessionService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsSeckillSession
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsSeckillSession smsSeckillSession){
        //调用SmsSeckillSessionService实现条件查询SmsSeckillSession
        List<SmsSeckillSession> list = smsSeckillSessionService.findList(smsSeckillSession);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsSeckillSessionService实现根据主键删除
        smsSeckillSessionService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsSeckillSession数据
     * @param smsSeckillSession
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsSeckillSession smsSeckillSession,@PathVariable Long id){
        //设置主键值
        smsSeckillSession.setId(id);
        //调用SmsSeckillSessionService实现修改SmsSeckillSession
        smsSeckillSessionService.update(smsSeckillSession);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsSeckillSession数据
     * @param smsSeckillSession
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsSeckillSession smsSeckillSession){
        //调用SmsSeckillSessionService实现添加SmsSeckillSession
        smsSeckillSessionService.add(smsSeckillSession);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsSeckillSession数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsSeckillSessionService实现根据主键查询SmsSeckillSession
        SmsSeckillSession smsSeckillSession = smsSeckillSessionService.findById(id);
        return Result.ok("查询成功", smsSeckillSession);
    }

    /***
     * 查询SmsSeckillSession全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsSeckillSessionService实现查询所有SmsSeckillSession
        List<SmsSeckillSession> list = smsSeckillSessionService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
