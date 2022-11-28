package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsCoupon;
import com.skywalker.sms.service.SmsCouponService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsCouponController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsCoupon")
@CrossOrigin
public class SmsCouponController {

    @Autowired
    private SmsCouponService smsCouponService;

    /***
     * SmsCoupon分页条件搜索实现
     * @param smsCoupon
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsCoupon smsCoupon, @PathVariable  int page, @PathVariable  int size){
        //调用SmsCouponService实现分页条件查询SmsCoupon
        PageInfo<SmsCoupon> pageInfo = smsCouponService.findPage(smsCoupon, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsCoupon分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsCouponService实现分页查询SmsCoupon
        PageInfo<SmsCoupon> pageInfo = smsCouponService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsCoupon
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsCoupon smsCoupon){
        //调用SmsCouponService实现条件查询SmsCoupon
        List<SmsCoupon> list = smsCouponService.findList(smsCoupon);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsCouponService实现根据主键删除
        smsCouponService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsCoupon数据
     * @param smsCoupon
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsCoupon smsCoupon,@PathVariable Long id){
        //设置主键值
        smsCoupon.setId(id);
        //调用SmsCouponService实现修改SmsCoupon
        smsCouponService.update(smsCoupon);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsCoupon数据
     * @param smsCoupon
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsCoupon smsCoupon){
        //调用SmsCouponService实现添加SmsCoupon
        smsCouponService.add(smsCoupon);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsCoupon数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsCouponService实现根据主键查询SmsCoupon
        SmsCoupon smsCoupon = smsCouponService.findById(id);
        return Result.ok("查询成功", smsCoupon);
    }

    /***
     * 查询SmsCoupon全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsCouponService实现查询所有SmsCoupon
        List<SmsCoupon> list = smsCouponService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
