package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsCategoryBrandRelation;
import com.skywalker.pms.service.PmsCategoryBrandRelationService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryBrandRelationController
 * @Description TODO
 */

@RestController
@RequestMapping("/pmsCategoryBrandRelation")
@CrossOrigin
public class PmsCategoryBrandRelationController {

    @Autowired
    private PmsCategoryBrandRelationService pmsCategoryBrandRelationService;

    /***
     * PmsCategoryBrandRelation分页条件搜索实现
     * @param pmsCategoryBrandRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsCategoryBrandRelation pmsCategoryBrandRelation, @PathVariable  int page, @PathVariable  int size){
        //调用PmsCategoryBrandRelationService实现分页条件查询PmsCategoryBrandRelation
        PageInfo<PmsCategoryBrandRelation> pageInfo = pmsCategoryBrandRelationService.findPage(pmsCategoryBrandRelation, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsCategoryBrandRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsCategoryBrandRelationService实现分页查询PmsCategoryBrandRelation
        PageInfo<PmsCategoryBrandRelation> pageInfo = pmsCategoryBrandRelationService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsCategoryBrandRelation
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsCategoryBrandRelation pmsCategoryBrandRelation){
        //调用PmsCategoryBrandRelationService实现条件查询PmsCategoryBrandRelation
        List<PmsCategoryBrandRelation> list = pmsCategoryBrandRelationService.findList(pmsCategoryBrandRelation);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsCategoryBrandRelationService实现根据主键删除
        pmsCategoryBrandRelationService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsCategoryBrandRelation数据
     * @param pmsCategoryBrandRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsCategoryBrandRelation pmsCategoryBrandRelation,@PathVariable Long id){
        //设置主键值
        pmsCategoryBrandRelation.setId(id);
        //调用PmsCategoryBrandRelationService实现修改PmsCategoryBrandRelation
        pmsCategoryBrandRelationService.update(pmsCategoryBrandRelation);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsCategoryBrandRelation数据
     * @param pmsCategoryBrandRelation
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsCategoryBrandRelation pmsCategoryBrandRelation){
        //调用PmsCategoryBrandRelationService实现添加PmsCategoryBrandRelation
        pmsCategoryBrandRelationService.add(pmsCategoryBrandRelation);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsCategoryBrandRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsCategoryBrandRelationService实现根据主键查询PmsCategoryBrandRelation
        PmsCategoryBrandRelation pmsCategoryBrandRelation = pmsCategoryBrandRelationService.findById(id);
        return Result.ok("查询成功", pmsCategoryBrandRelation);
    }

    /***
     * 查询PmsCategoryBrandRelation全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsCategoryBrandRelationService实现查询所有PmsCategoryBrandRelation
        List<PmsCategoryBrandRelation> list = pmsCategoryBrandRelationService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
