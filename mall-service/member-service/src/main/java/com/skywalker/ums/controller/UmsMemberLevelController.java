package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsMemberLevel;
import com.skywalker.ums.service.UmsMemberLevelService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLevelController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsMemberLevel")
@CrossOrigin
public class UmsMemberLevelController {

    @Autowired
    private UmsMemberLevelService umsMemberLevelService;

    /***
     * UmsMemberLevel分页条件搜索实现
     * @param umsMemberLevel
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsMemberLevel umsMemberLevel, @PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberLevelService实现分页条件查询UmsMemberLevel
        PageInfo<UmsMemberLevel> pageInfo = umsMemberLevelService.findPage(umsMemberLevel, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsMemberLevel分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberLevelService实现分页查询UmsMemberLevel
        PageInfo<UmsMemberLevel> pageInfo = umsMemberLevelService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsMemberLevel
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsMemberLevel umsMemberLevel){
        //调用UmsMemberLevelService实现条件查询UmsMemberLevel
        List<UmsMemberLevel> list = umsMemberLevelService.findList(umsMemberLevel);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsMemberLevelService实现根据主键删除
        umsMemberLevelService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsMemberLevel数据
     * @param umsMemberLevel
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsMemberLevel umsMemberLevel,@PathVariable Long id){
        //设置主键值
        umsMemberLevel.setId(id);
        //调用UmsMemberLevelService实现修改UmsMemberLevel
        umsMemberLevelService.update(umsMemberLevel);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsMemberLevel数据
     * @param umsMemberLevel
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsMemberLevel umsMemberLevel){
        //调用UmsMemberLevelService实现添加UmsMemberLevel
        umsMemberLevelService.add(umsMemberLevel);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsMemberLevel数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsMemberLevelService实现根据主键查询UmsMemberLevel
        UmsMemberLevel umsMemberLevel = umsMemberLevelService.findById(id);
        return Result.ok("查询成功", umsMemberLevel);
    }

    /***
     * 查询UmsMemberLevel全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsMemberLevelService实现查询所有UmsMemberLevel
        List<UmsMemberLevel> list = umsMemberLevelService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
