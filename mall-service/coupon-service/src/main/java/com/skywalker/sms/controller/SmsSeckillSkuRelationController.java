package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsSeckillSkuRelation;
import com.skywalker.sms.service.SmsSeckillSkuRelationService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuRelationController
 * @Description TODO
 */

@RestController
@RequestMapping("/seckillSkuRelation")
@CrossOrigin
public class SmsSeckillSkuRelationController {

    @Autowired
    private SmsSeckillSkuRelationService smsSeckillSkuRelationService;

    /***
     * SmsSeckillSkuRelation分页条件搜索实现
     * @param smsSeckillSkuRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsSeckillSkuRelation smsSeckillSkuRelation, @PathVariable  int page, @PathVariable  int size){
        //调用SmsSeckillSkuRelationService实现分页条件查询SmsSeckillSkuRelation
        PageInfo<SmsSeckillSkuRelation> pageInfo = smsSeckillSkuRelationService.findPage(smsSeckillSkuRelation, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsSeckillSkuRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsSeckillSkuRelationService实现分页查询SmsSeckillSkuRelation
        PageInfo<SmsSeckillSkuRelation> pageInfo = smsSeckillSkuRelationService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsSeckillSkuRelation
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsSeckillSkuRelation smsSeckillSkuRelation){
        //调用SmsSeckillSkuRelationService实现条件查询SmsSeckillSkuRelation
        List<SmsSeckillSkuRelation> list = smsSeckillSkuRelationService.findList(smsSeckillSkuRelation);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsSeckillSkuRelationService实现根据主键删除
        smsSeckillSkuRelationService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsSeckillSkuRelation数据
     * @param smsSeckillSkuRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsSeckillSkuRelation smsSeckillSkuRelation,@PathVariable Long id){
        //设置主键值
        smsSeckillSkuRelation.setId(id);
        //调用SmsSeckillSkuRelationService实现修改SmsSeckillSkuRelation
        smsSeckillSkuRelationService.update(smsSeckillSkuRelation);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsSeckillSkuRelation数据
     * @param smsSeckillSkuRelation
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsSeckillSkuRelation smsSeckillSkuRelation){
        //调用SmsSeckillSkuRelationService实现添加SmsSeckillSkuRelation
        smsSeckillSkuRelationService.add(smsSeckillSkuRelation);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsSeckillSkuRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsSeckillSkuRelationService实现根据主键查询SmsSeckillSkuRelation
        SmsSeckillSkuRelation smsSeckillSkuRelation = smsSeckillSkuRelationService.findById(id);
        return Result.ok("查询成功", smsSeckillSkuRelation);
    }

    /***
     * 查询SmsSeckillSkuRelation全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsSeckillSkuRelationService实现查询所有SmsSeckillSkuRelation
        List<SmsSeckillSkuRelation> list = smsSeckillSkuRelationService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
