package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsSeckillPromotion;
import com.skywalker.sms.service.SmsSeckillPromotionService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillPromotionController
 * @Description TODO
 */

@RestController
@RequestMapping("/seckillPromotion")
@CrossOrigin
public class SmsSeckillPromotionController {

    @Autowired
    private SmsSeckillPromotionService smsSeckillPromotionService;

    /***
     * SmsSeckillPromotion分页条件搜索实现
     * @param smsSeckillPromotion
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsSeckillPromotion smsSeckillPromotion, @PathVariable  int page, @PathVariable  int size){
        //调用SmsSeckillPromotionService实现分页条件查询SmsSeckillPromotion
        PageInfo<SmsSeckillPromotion> pageInfo = smsSeckillPromotionService.findPage(smsSeckillPromotion, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsSeckillPromotion分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsSeckillPromotionService实现分页查询SmsSeckillPromotion
        PageInfo<SmsSeckillPromotion> pageInfo = smsSeckillPromotionService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsSeckillPromotion
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsSeckillPromotion smsSeckillPromotion){
        //调用SmsSeckillPromotionService实现条件查询SmsSeckillPromotion
        List<SmsSeckillPromotion> list = smsSeckillPromotionService.findList(smsSeckillPromotion);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsSeckillPromotionService实现根据主键删除
        smsSeckillPromotionService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsSeckillPromotion数据
     * @param smsSeckillPromotion
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsSeckillPromotion smsSeckillPromotion,@PathVariable Long id){
        //设置主键值
        smsSeckillPromotion.setId(id);
        //调用SmsSeckillPromotionService实现修改SmsSeckillPromotion
        smsSeckillPromotionService.update(smsSeckillPromotion);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsSeckillPromotion数据
     * @param smsSeckillPromotion
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsSeckillPromotion smsSeckillPromotion){
        //调用SmsSeckillPromotionService实现添加SmsSeckillPromotion
        smsSeckillPromotionService.add(smsSeckillPromotion);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsSeckillPromotion数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsSeckillPromotionService实现根据主键查询SmsSeckillPromotion
        SmsSeckillPromotion smsSeckillPromotion = smsSeckillPromotionService.findById(id);
        return Result.ok("查询成功", smsSeckillPromotion);
    }

    /***
     * 查询SmsSeckillPromotion全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsSeckillPromotionService实现查询所有SmsSeckillPromotion
        List<SmsSeckillPromotion> list = smsSeckillPromotionService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
