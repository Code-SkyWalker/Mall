package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsMember;
import com.skywalker.ums.service.UmsMemberService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsMember")
@CrossOrigin
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    /***
     * UmsMember分页条件搜索实现
     * @param umsMember
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsMember umsMember, @PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberService实现分页条件查询UmsMember
        PageInfo<UmsMember> pageInfo = umsMemberService.findPage(umsMember, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsMember分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberService实现分页查询UmsMember
        PageInfo<UmsMember> pageInfo = umsMemberService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsMember
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsMember umsMember){
        //调用UmsMemberService实现条件查询UmsMember
        List<UmsMember> list = umsMemberService.findList(umsMember);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsMemberService实现根据主键删除
        umsMemberService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsMember数据
     * @param umsMember
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsMember umsMember,@PathVariable Long id){
        //设置主键值
        umsMember.setId(id);
        //调用UmsMemberService实现修改UmsMember
        umsMemberService.update(umsMember);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsMember数据
     * @param umsMember
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsMember umsMember){
        //调用UmsMemberService实现添加UmsMember
        umsMemberService.add(umsMember);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsMember数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsMemberService实现根据主键查询UmsMember
        UmsMember umsMember = umsMemberService.findById(id);
        return Result.ok("查询成功", umsMember);
    }

    /***
     * 查询UmsMember全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsMemberService实现查询所有UmsMember
        List<UmsMember> list = umsMemberService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
