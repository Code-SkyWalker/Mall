package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsCouponHistory;
import com.skywalker.sms.service.SmsCouponHistoryService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsCouponHistoryController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsCouponHistory")
@CrossOrigin
public class SmsCouponHistoryController {

    @Autowired
    private SmsCouponHistoryService smsCouponHistoryService;

    /***
     * SmsCouponHistory分页条件搜索实现
     * @param smsCouponHistory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsCouponHistory smsCouponHistory, @PathVariable  int page, @PathVariable  int size){
        //调用SmsCouponHistoryService实现分页条件查询SmsCouponHistory
        PageInfo<SmsCouponHistory> pageInfo = smsCouponHistoryService.findPage(smsCouponHistory, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsCouponHistory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsCouponHistoryService实现分页查询SmsCouponHistory
        PageInfo<SmsCouponHistory> pageInfo = smsCouponHistoryService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsCouponHistory
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsCouponHistory smsCouponHistory){
        //调用SmsCouponHistoryService实现条件查询SmsCouponHistory
        List<SmsCouponHistory> list = smsCouponHistoryService.findList(smsCouponHistory);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsCouponHistoryService实现根据主键删除
        smsCouponHistoryService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsCouponHistory数据
     * @param smsCouponHistory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsCouponHistory smsCouponHistory,@PathVariable Long id){
        //设置主键值
        smsCouponHistory.setId(id);
        //调用SmsCouponHistoryService实现修改SmsCouponHistory
        smsCouponHistoryService.update(smsCouponHistory);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsCouponHistory数据
     * @param smsCouponHistory
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsCouponHistory smsCouponHistory){
        //调用SmsCouponHistoryService实现添加SmsCouponHistory
        smsCouponHistoryService.add(smsCouponHistory);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsCouponHistory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsCouponHistoryService实现根据主键查询SmsCouponHistory
        SmsCouponHistory smsCouponHistory = smsCouponHistoryService.findById(id);
        return Result.ok("查询成功", smsCouponHistory);
    }

    /***
     * 查询SmsCouponHistory全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsCouponHistoryService实现查询所有SmsCouponHistory
        List<SmsCouponHistory> list = smsCouponHistoryService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
