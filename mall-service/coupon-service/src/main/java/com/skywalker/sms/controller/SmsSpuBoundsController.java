package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsSpuBounds;
import com.skywalker.sms.service.SmsSpuBoundsService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsSpuBoundsController
 * @Description TODO
 */

@RestController
@RequestMapping("/spuBounds")
@CrossOrigin
public class SmsSpuBoundsController {

    @Autowired
    private SmsSpuBoundsService smsSpuBoundsService;

    /***
     * SmsSpuBounds分页条件搜索实现
     * @param smsSpuBounds
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsSpuBounds smsSpuBounds, @PathVariable  int page, @PathVariable  int size){
        //调用SmsSpuBoundsService实现分页条件查询SmsSpuBounds
        PageInfo<SmsSpuBounds> pageInfo = smsSpuBoundsService.findPage(smsSpuBounds, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsSpuBounds分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsSpuBoundsService实现分页查询SmsSpuBounds
        PageInfo<SmsSpuBounds> pageInfo = smsSpuBoundsService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsSpuBounds
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsSpuBounds smsSpuBounds){
        //调用SmsSpuBoundsService实现条件查询SmsSpuBounds
        List<SmsSpuBounds> list = smsSpuBoundsService.findList(smsSpuBounds);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsSpuBoundsService实现根据主键删除
        smsSpuBoundsService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsSpuBounds数据
     * @param smsSpuBounds
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsSpuBounds smsSpuBounds,@PathVariable Long id){
        //设置主键值
        smsSpuBounds.setId(id);
        //调用SmsSpuBoundsService实现修改SmsSpuBounds
        smsSpuBoundsService.update(smsSpuBounds);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsSpuBounds数据
     * @param smsSpuBounds
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsSpuBounds smsSpuBounds){
        //调用SmsSpuBoundsService实现添加SmsSpuBounds
        smsSpuBoundsService.add(smsSpuBounds);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsSpuBounds数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsSpuBoundsService实现根据主键查询SmsSpuBounds
        SmsSpuBounds smsSpuBounds = smsSpuBoundsService.findById(id);
        return Result.ok("查询成功", smsSpuBounds);
    }

    /***
     * 查询SmsSpuBounds全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsSpuBoundsService实现查询所有SmsSpuBounds
        List<SmsSpuBounds> list = smsSpuBoundsService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
