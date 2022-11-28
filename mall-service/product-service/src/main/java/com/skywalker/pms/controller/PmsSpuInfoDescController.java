package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsSpuInfoDesc;
import com.skywalker.pms.service.PmsSpuInfoDescService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoDescController
 * @Description TODO
 */

@RestController
@RequestMapping("/pmsSpuInfoDesc")
@CrossOrigin
public class PmsSpuInfoDescController {

    @Autowired
    private PmsSpuInfoDescService pmsSpuInfoDescService;

    /***
     * PmsSpuInfoDesc分页条件搜索实现
     * @param pmsSpuInfoDesc
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsSpuInfoDesc pmsSpuInfoDesc, @PathVariable  int page, @PathVariable  int size){
        //调用PmsSpuInfoDescService实现分页条件查询PmsSpuInfoDesc
        PageInfo<PmsSpuInfoDesc> pageInfo = pmsSpuInfoDescService.findPage(pmsSpuInfoDesc, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsSpuInfoDesc分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsSpuInfoDescService实现分页查询PmsSpuInfoDesc
        PageInfo<PmsSpuInfoDesc> pageInfo = pmsSpuInfoDescService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsSpuInfoDesc
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsSpuInfoDesc pmsSpuInfoDesc){
        //调用PmsSpuInfoDescService实现条件查询PmsSpuInfoDesc
        List<PmsSpuInfoDesc> list = pmsSpuInfoDescService.findList(pmsSpuInfoDesc);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsSpuInfoDescService实现根据主键删除
        pmsSpuInfoDescService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsSpuInfoDesc数据
     * @param pmsSpuInfoDesc
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsSpuInfoDesc pmsSpuInfoDesc,@PathVariable Long id){
        //设置主键值
        pmsSpuInfoDesc.setSpuId(id);
        //调用PmsSpuInfoDescService实现修改PmsSpuInfoDesc
        pmsSpuInfoDescService.update(pmsSpuInfoDesc);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsSpuInfoDesc数据
     * @param pmsSpuInfoDesc
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsSpuInfoDesc pmsSpuInfoDesc){
        //调用PmsSpuInfoDescService实现添加PmsSpuInfoDesc
        pmsSpuInfoDescService.add(pmsSpuInfoDesc);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsSpuInfoDesc数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsSpuInfoDescService实现根据主键查询PmsSpuInfoDesc
        PmsSpuInfoDesc pmsSpuInfoDesc = pmsSpuInfoDescService.findById(id);
        return Result.ok("查询成功", pmsSpuInfoDesc);
    }

    /***
     * 查询PmsSpuInfoDesc全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsSpuInfoDescService实现查询所有PmsSpuInfoDesc
        List<PmsSpuInfoDesc> list = pmsSpuInfoDescService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
