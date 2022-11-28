package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsMemberPrice;
import com.skywalker.sms.service.SmsMemberPriceService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsMemberPriceController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsMemberPrice")
@CrossOrigin
public class SmsMemberPriceController {

    @Autowired
    private SmsMemberPriceService smsMemberPriceService;

    /***
     * SmsMemberPrice分页条件搜索实现
     * @param smsMemberPrice
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsMemberPrice smsMemberPrice, @PathVariable  int page, @PathVariable  int size){
        //调用SmsMemberPriceService实现分页条件查询SmsMemberPrice
        PageInfo<SmsMemberPrice> pageInfo = smsMemberPriceService.findPage(smsMemberPrice, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsMemberPrice分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsMemberPriceService实现分页查询SmsMemberPrice
        PageInfo<SmsMemberPrice> pageInfo = smsMemberPriceService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsMemberPrice
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsMemberPrice smsMemberPrice){
        //调用SmsMemberPriceService实现条件查询SmsMemberPrice
        List<SmsMemberPrice> list = smsMemberPriceService.findList(smsMemberPrice);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsMemberPriceService实现根据主键删除
        smsMemberPriceService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsMemberPrice数据
     * @param smsMemberPrice
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsMemberPrice smsMemberPrice,@PathVariable Long id){
        //设置主键值
        smsMemberPrice.setId(id);
        //调用SmsMemberPriceService实现修改SmsMemberPrice
        smsMemberPriceService.update(smsMemberPrice);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsMemberPrice数据
     * @param smsMemberPrice
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsMemberPrice smsMemberPrice){
        //调用SmsMemberPriceService实现添加SmsMemberPrice
        smsMemberPriceService.add(smsMemberPrice);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsMemberPrice数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsMemberPriceService实现根据主键查询SmsMemberPrice
        SmsMemberPrice smsMemberPrice = smsMemberPriceService.findById(id);
        return Result.ok("查询成功", smsMemberPrice);
    }

    /***
     * 查询SmsMemberPrice全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsMemberPriceService实现查询所有SmsMemberPrice
        List<SmsMemberPrice> list = smsMemberPriceService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
