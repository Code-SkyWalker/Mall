package com.skywalker.ums.controller;
import com.skywalker.ums.pojo.UmsMemberCollectSpu;
import com.skywalker.ums.service.UmsMemberCollectSpuService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSpuController
 * @Description TODO
 */

@RestController
@RequestMapping("/umsMemberCollectSpu")
@CrossOrigin
public class UmsMemberCollectSpuController {

    @Autowired
    private UmsMemberCollectSpuService umsMemberCollectSpuService;

    /***
     * UmsMemberCollectSpu分页条件搜索实现
     * @param umsMemberCollectSpu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  UmsMemberCollectSpu umsMemberCollectSpu, @PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberCollectSpuService实现分页条件查询UmsMemberCollectSpu
        PageInfo<UmsMemberCollectSpu> pageInfo = umsMemberCollectSpuService.findPage(umsMemberCollectSpu, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * UmsMemberCollectSpu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UmsMemberCollectSpuService实现分页查询UmsMemberCollectSpu
        PageInfo<UmsMemberCollectSpu> pageInfo = umsMemberCollectSpuService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param umsMemberCollectSpu
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  UmsMemberCollectSpu umsMemberCollectSpu){
        //调用UmsMemberCollectSpuService实现条件查询UmsMemberCollectSpu
        List<UmsMemberCollectSpu> list = umsMemberCollectSpuService.findList(umsMemberCollectSpu);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UmsMemberCollectSpuService实现根据主键删除
        umsMemberCollectSpuService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改UmsMemberCollectSpu数据
     * @param umsMemberCollectSpu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UmsMemberCollectSpu umsMemberCollectSpu,@PathVariable Long id){
        //设置主键值
        umsMemberCollectSpu.setId(id);
        //调用UmsMemberCollectSpuService实现修改UmsMemberCollectSpu
        umsMemberCollectSpuService.update(umsMemberCollectSpu);
        return Result.ok("修改成功");
    }

    /***
     * 新增UmsMemberCollectSpu数据
     * @param umsMemberCollectSpu
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   UmsMemberCollectSpu umsMemberCollectSpu){
        //调用UmsMemberCollectSpuService实现添加UmsMemberCollectSpu
        umsMemberCollectSpuService.add(umsMemberCollectSpu);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询UmsMemberCollectSpu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用UmsMemberCollectSpuService实现根据主键查询UmsMemberCollectSpu
        UmsMemberCollectSpu umsMemberCollectSpu = umsMemberCollectSpuService.findById(id);
        return Result.ok("查询成功", umsMemberCollectSpu);
    }

    /***
     * 查询UmsMemberCollectSpu全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用UmsMemberCollectSpuService实现查询所有UmsMemberCollectSpu
        List<UmsMemberCollectSpu> list = umsMemberCollectSpuService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
