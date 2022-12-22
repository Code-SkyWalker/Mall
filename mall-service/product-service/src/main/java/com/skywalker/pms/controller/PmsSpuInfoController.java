package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsSpuInfo;
import com.skywalker.pms.service.PmsSpuInfoService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoController
 * @Description TODO
 */

@RestController
@RequestMapping("/spuInfo")
//@CrossOrigin
public class PmsSpuInfoController {

    @Autowired
    private PmsSpuInfoService pmsSpuInfoService;

    /***
     * PmsSpuInfo分页条件搜索实现
     * @param pmsSpuInfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsSpuInfo pmsSpuInfo, @PathVariable  int page, @PathVariable  int size){
        //调用PmsSpuInfoService实现分页条件查询PmsSpuInfo
        PageInfo<PmsSpuInfo> pageInfo = pmsSpuInfoService.findPage(pmsSpuInfo, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsSpuInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsSpuInfoService实现分页查询PmsSpuInfo
        PageInfo<PmsSpuInfo> pageInfo = pmsSpuInfoService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsSpuInfo
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsSpuInfo pmsSpuInfo){
        //调用PmsSpuInfoService实现条件查询PmsSpuInfo
        List<PmsSpuInfo> list = pmsSpuInfoService.findList(pmsSpuInfo);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsSpuInfoService实现根据主键删除
        pmsSpuInfoService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsSpuInfo数据
     * @param pmsSpuInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsSpuInfo pmsSpuInfo,@PathVariable Long id){
        //设置主键值
        pmsSpuInfo.setId(id);
        //调用PmsSpuInfoService实现修改PmsSpuInfo
        pmsSpuInfoService.update(pmsSpuInfo);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsSpuInfo数据
     * @param pmsSpuInfo
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsSpuInfo pmsSpuInfo){
        //调用PmsSpuInfoService实现添加PmsSpuInfo
        pmsSpuInfoService.add(pmsSpuInfo);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsSpuInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsSpuInfoService实现根据主键查询PmsSpuInfo
        PmsSpuInfo pmsSpuInfo = pmsSpuInfoService.findById(id);
        return Result.ok("查询成功", pmsSpuInfo);
    }

    /***
     * 查询PmsSpuInfo全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsSpuInfoService实现查询所有PmsSpuInfo
        List<PmsSpuInfo> list = pmsSpuInfoService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
