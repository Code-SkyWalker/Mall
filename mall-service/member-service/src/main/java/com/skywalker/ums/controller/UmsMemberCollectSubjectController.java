package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsMemberCollectSubject;
import com.skywalker.ums.service.UmsMemberCollectSubjectService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSubjectController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsMemberCollectSubject")
@CrossOrigin
public class UmsMemberCollectSubjectController {

    @Autowired
    private UmsMemberCollectSubjectService umsMemberCollectSubjectService;

    /***
     * UmsMemberCollectSubject分页条件搜索实现
     * @param umsMemberCollectSubject
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsMemberCollectSubject umsMemberCollectSubject, @PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberCollectSubjectService实现分页条件查询UmsMemberCollectSubject
        PageInfo<UmsMemberCollectSubject> pageInfo = umsMemberCollectSubjectService.findPage(umsMemberCollectSubject, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsMemberCollectSubject分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberCollectSubjectService实现分页查询UmsMemberCollectSubject
        PageInfo<UmsMemberCollectSubject> pageInfo = umsMemberCollectSubjectService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsMemberCollectSubject
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsMemberCollectSubject umsMemberCollectSubject){
        //调用UmsMemberCollectSubjectService实现条件查询UmsMemberCollectSubject
        List<UmsMemberCollectSubject> list = umsMemberCollectSubjectService.findList(umsMemberCollectSubject);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsMemberCollectSubjectService实现根据主键删除
        umsMemberCollectSubjectService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsMemberCollectSubject数据
     * @param umsMemberCollectSubject
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsMemberCollectSubject umsMemberCollectSubject,@PathVariable Long id){
        //设置主键值
        umsMemberCollectSubject.setId(id);
        //调用UmsMemberCollectSubjectService实现修改UmsMemberCollectSubject
        umsMemberCollectSubjectService.update(umsMemberCollectSubject);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsMemberCollectSubject数据
     * @param umsMemberCollectSubject
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsMemberCollectSubject umsMemberCollectSubject){
        //调用UmsMemberCollectSubjectService实现添加UmsMemberCollectSubject
        umsMemberCollectSubjectService.add(umsMemberCollectSubject);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsMemberCollectSubject数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsMemberCollectSubjectService实现根据主键查询UmsMemberCollectSubject
        UmsMemberCollectSubject umsMemberCollectSubject = umsMemberCollectSubjectService.findById(id);
        return Result.ok("查询成功", umsMemberCollectSubject);
    }

    /***
     * 查询UmsMemberCollectSubject全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsMemberCollectSubjectService实现查询所有UmsMemberCollectSubject
        List<UmsMemberCollectSubject> list = umsMemberCollectSubjectService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
