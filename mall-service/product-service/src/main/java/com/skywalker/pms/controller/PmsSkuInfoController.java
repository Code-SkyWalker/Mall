package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsSkuInfo;
import com.skywalker.pms.service.PmsSkuInfoService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import com.skywalker.pms.vo.PmsSkuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsSkuInfoController
 * @Description TODO
 */

@RestController
@RequestMapping("/skuInfo")
public class PmsSkuInfoController {

    @Autowired
    private PmsSkuInfoService pmsSkuInfoService;

    /***
     * PmsSkuInfo分页条件搜索实现
     * @param pmsSkuInfoVo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false) PmsSkuInfoVo pmsSkuInfoVo, @PathVariable  int page, @PathVariable  int size){
        //调用PmsSkuInfoService实现分页条件查询PmsSkuInfo
        PageInfo<PmsSkuInfo> pageInfo = pmsSkuInfoService.findPage(pmsSkuInfoVo, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsSkuInfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsSkuInfoService实现分页查询PmsSkuInfo
        PageInfo<PmsSkuInfo> pageInfo = pmsSkuInfoService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsSkuInfo
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsSkuInfo pmsSkuInfo){
        //调用PmsSkuInfoService实现条件查询PmsSkuInfo
        List<PmsSkuInfo> list = pmsSkuInfoService.findList(pmsSkuInfo);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsSkuInfoService实现根据主键删除
        pmsSkuInfoService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsSkuInfo数据
     * @param pmsSkuInfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsSkuInfo pmsSkuInfo,@PathVariable Long id){
        //设置主键值
        pmsSkuInfo.setSkuId(id);
        //调用PmsSkuInfoService实现修改PmsSkuInfo
        pmsSkuInfoService.update(pmsSkuInfo);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsSkuInfo数据
     * @param pmsSkuInfo
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsSkuInfo pmsSkuInfo){
        //调用PmsSkuInfoService实现添加PmsSkuInfo
        pmsSkuInfoService.add(pmsSkuInfo);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsSkuInfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsSkuInfoService实现根据主键查询PmsSkuInfo
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoService.findById(id);
        return Result.ok("查询成功", pmsSkuInfo);
    }

    /***
     * 查询PmsSkuInfo全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsSkuInfoService实现查询所有PmsSkuInfo
        List<PmsSkuInfo> list = pmsSkuInfoService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
