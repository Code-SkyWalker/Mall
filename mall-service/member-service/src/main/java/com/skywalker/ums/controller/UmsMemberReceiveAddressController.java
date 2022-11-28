package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsMemberReceiveAddress;
import com.skywalker.ums.service.UmsMemberReceiveAddressService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberReceiveAddressController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsMemberReceiveAddress")
@CrossOrigin
public class UmsMemberReceiveAddressController {

    @Autowired
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /***
     * UmsMemberReceiveAddress分页条件搜索实现
     * @param umsMemberReceiveAddress
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsMemberReceiveAddress umsMemberReceiveAddress, @PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberReceiveAddressService实现分页条件查询UmsMemberReceiveAddress
        PageInfo<UmsMemberReceiveAddress> pageInfo = umsMemberReceiveAddressService.findPage(umsMemberReceiveAddress, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsMemberReceiveAddress分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberReceiveAddressService实现分页查询UmsMemberReceiveAddress
        PageInfo<UmsMemberReceiveAddress> pageInfo = umsMemberReceiveAddressService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsMemberReceiveAddress
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsMemberReceiveAddress umsMemberReceiveAddress){
        //调用UmsMemberReceiveAddressService实现条件查询UmsMemberReceiveAddress
        List<UmsMemberReceiveAddress> list = umsMemberReceiveAddressService.findList(umsMemberReceiveAddress);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsMemberReceiveAddressService实现根据主键删除
        umsMemberReceiveAddressService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsMemberReceiveAddress数据
     * @param umsMemberReceiveAddress
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsMemberReceiveAddress umsMemberReceiveAddress,@PathVariable Long id){
        //设置主键值
        umsMemberReceiveAddress.setId(id);
        //调用UmsMemberReceiveAddressService实现修改UmsMemberReceiveAddress
        umsMemberReceiveAddressService.update(umsMemberReceiveAddress);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsMemberReceiveAddress数据
     * @param umsMemberReceiveAddress
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsMemberReceiveAddress umsMemberReceiveAddress){
        //调用UmsMemberReceiveAddressService实现添加UmsMemberReceiveAddress
        umsMemberReceiveAddressService.add(umsMemberReceiveAddress);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsMemberReceiveAddress数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsMemberReceiveAddressService实现根据主键查询UmsMemberReceiveAddress
        UmsMemberReceiveAddress umsMemberReceiveAddress = umsMemberReceiveAddressService.findById(id);
        return Result.ok("查询成功", umsMemberReceiveAddress);
    }

    /***
     * 查询UmsMemberReceiveAddress全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsMemberReceiveAddressService实现查询所有UmsMemberReceiveAddress
        List<UmsMemberReceiveAddress> list = umsMemberReceiveAddressService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
