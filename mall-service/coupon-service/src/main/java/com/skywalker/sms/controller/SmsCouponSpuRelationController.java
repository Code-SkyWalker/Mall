package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsCouponSpuRelation;
import com.skywalker.sms.service.SmsCouponSpuRelationService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuRelationController
 * @Description TODO
 */

@RestController
@RequestMapping("/smsCouponSpuRelation")
@CrossOrigin
public class SmsCouponSpuRelationController {

    @Autowired
    private SmsCouponSpuRelationService smsCouponSpuRelationService;

    /***
     * SmsCouponSpuRelation分页条件搜索实现
     * @param smsCouponSpuRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsCouponSpuRelation smsCouponSpuRelation, @PathVariable  int page, @PathVariable  int size){
        //调用SmsCouponSpuRelationService实现分页条件查询SmsCouponSpuRelation
        PageInfo<SmsCouponSpuRelation> pageInfo = smsCouponSpuRelationService.findPage(smsCouponSpuRelation, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsCouponSpuRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsCouponSpuRelationService实现分页查询SmsCouponSpuRelation
        PageInfo<SmsCouponSpuRelation> pageInfo = smsCouponSpuRelationService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsCouponSpuRelation
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsCouponSpuRelation smsCouponSpuRelation){
        //调用SmsCouponSpuRelationService实现条件查询SmsCouponSpuRelation
        List<SmsCouponSpuRelation> list = smsCouponSpuRelationService.findList(smsCouponSpuRelation);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsCouponSpuRelationService实现根据主键删除
        smsCouponSpuRelationService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsCouponSpuRelation数据
     * @param smsCouponSpuRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsCouponSpuRelation smsCouponSpuRelation,@PathVariable Long id){
        //设置主键值
        smsCouponSpuRelation.setId(id);
        //调用SmsCouponSpuRelationService实现修改SmsCouponSpuRelation
        smsCouponSpuRelationService.update(smsCouponSpuRelation);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsCouponSpuRelation数据
     * @param smsCouponSpuRelation
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsCouponSpuRelation smsCouponSpuRelation){
        //调用SmsCouponSpuRelationService实现添加SmsCouponSpuRelation
        smsCouponSpuRelationService.add(smsCouponSpuRelation);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsCouponSpuRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsCouponSpuRelationService实现根据主键查询SmsCouponSpuRelation
        SmsCouponSpuRelation smsCouponSpuRelation = smsCouponSpuRelationService.findById(id);
        return Result.ok("查询成功", smsCouponSpuRelation);
    }

    /***
     * 查询SmsCouponSpuRelation全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsCouponSpuRelationService实现查询所有SmsCouponSpuRelation
        List<SmsCouponSpuRelation> list = smsCouponSpuRelationService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
