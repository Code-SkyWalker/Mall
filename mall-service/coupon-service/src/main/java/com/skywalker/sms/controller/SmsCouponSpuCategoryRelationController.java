package com.skywalker.sms.controller;
import com.skywalker.sms.pojo.SmsCouponSpuCategoryRelation;
import com.skywalker.sms.service.SmsCouponSpuCategoryRelationService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuCategoryRelationController
 * @Description TODO
 */

@RestController
@RequestMapping("/couponSpuCategoryRelation")
@CrossOrigin
public class SmsCouponSpuCategoryRelationController {

    @Autowired
    private SmsCouponSpuCategoryRelationService smsCouponSpuCategoryRelationService;

    /***
     * SmsCouponSpuCategoryRelation分页条件搜索实现
     * @param smsCouponSpuCategoryRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation, @PathVariable  int page, @PathVariable  int size){
        //调用SmsCouponSpuCategoryRelationService实现分页条件查询SmsCouponSpuCategoryRelation
        PageInfo<SmsCouponSpuCategoryRelation> pageInfo = smsCouponSpuCategoryRelationService.findPage(smsCouponSpuCategoryRelation, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * SmsCouponSpuCategoryRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SmsCouponSpuCategoryRelationService实现分页查询SmsCouponSpuCategoryRelation
        PageInfo<SmsCouponSpuCategoryRelation> pageInfo = smsCouponSpuCategoryRelationService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param smsCouponSpuCategoryRelation
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation){
        //调用SmsCouponSpuCategoryRelationService实现条件查询SmsCouponSpuCategoryRelation
        List<SmsCouponSpuCategoryRelation> list = smsCouponSpuCategoryRelationService.findList(smsCouponSpuCategoryRelation);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SmsCouponSpuCategoryRelationService实现根据主键删除
        smsCouponSpuCategoryRelationService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改SmsCouponSpuCategoryRelation数据
     * @param smsCouponSpuCategoryRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation,@PathVariable Long id){
        //设置主键值
        smsCouponSpuCategoryRelation.setId(id);
        //调用SmsCouponSpuCategoryRelationService实现修改SmsCouponSpuCategoryRelation
        smsCouponSpuCategoryRelationService.update(smsCouponSpuCategoryRelation);
        return Result.ok("修改成功");
    }

    /***
     * 新增SmsCouponSpuCategoryRelation数据
     * @param smsCouponSpuCategoryRelation
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation){
        //调用SmsCouponSpuCategoryRelationService实现添加SmsCouponSpuCategoryRelation
        smsCouponSpuCategoryRelationService.add(smsCouponSpuCategoryRelation);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询SmsCouponSpuCategoryRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用SmsCouponSpuCategoryRelationService实现根据主键查询SmsCouponSpuCategoryRelation
        SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation = smsCouponSpuCategoryRelationService.findById(id);
        return Result.ok("查询成功", smsCouponSpuCategoryRelation);
    }

    /***
     * 查询SmsCouponSpuCategoryRelation全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用SmsCouponSpuCategoryRelationService实现查询所有SmsCouponSpuCategoryRelation
        List<SmsCouponSpuCategoryRelation> list = smsCouponSpuCategoryRelationService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
