package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsSkuSaleAttrValue;
import com.skywalker.pms.service.PmsSkuSaleAttrValueService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsSkuSaleAttrValueController
 * @Description TODO
 */

@RestController
@RequestMapping("/skuSaleAttrValue")
@CrossOrigin
public class PmsSkuSaleAttrValueController {

    @Autowired
    private PmsSkuSaleAttrValueService pmsSkuSaleAttrValueService;

    /***
     * PmsSkuSaleAttrValue分页条件搜索实现
     * @param pmsSkuSaleAttrValue
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsSkuSaleAttrValue pmsSkuSaleAttrValue, @PathVariable  int page, @PathVariable  int size){
        //调用PmsSkuSaleAttrValueService实现分页条件查询PmsSkuSaleAttrValue
        PageInfo<PmsSkuSaleAttrValue> pageInfo = pmsSkuSaleAttrValueService.findPage(pmsSkuSaleAttrValue, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsSkuSaleAttrValue分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsSkuSaleAttrValueService实现分页查询PmsSkuSaleAttrValue
        PageInfo<PmsSkuSaleAttrValue> pageInfo = pmsSkuSaleAttrValueService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsSkuSaleAttrValue
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsSkuSaleAttrValue pmsSkuSaleAttrValue){
        //调用PmsSkuSaleAttrValueService实现条件查询PmsSkuSaleAttrValue
        List<PmsSkuSaleAttrValue> list = pmsSkuSaleAttrValueService.findList(pmsSkuSaleAttrValue);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsSkuSaleAttrValueService实现根据主键删除
        pmsSkuSaleAttrValueService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsSkuSaleAttrValue数据
     * @param pmsSkuSaleAttrValue
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsSkuSaleAttrValue pmsSkuSaleAttrValue,@PathVariable Long id){
        //设置主键值
        pmsSkuSaleAttrValue.setId(id);
        //调用PmsSkuSaleAttrValueService实现修改PmsSkuSaleAttrValue
        pmsSkuSaleAttrValueService.update(pmsSkuSaleAttrValue);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsSkuSaleAttrValue数据
     * @param pmsSkuSaleAttrValue
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsSkuSaleAttrValue pmsSkuSaleAttrValue){
        //调用PmsSkuSaleAttrValueService实现添加PmsSkuSaleAttrValue
        pmsSkuSaleAttrValueService.add(pmsSkuSaleAttrValue);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsSkuSaleAttrValue数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsSkuSaleAttrValueService实现根据主键查询PmsSkuSaleAttrValue
        PmsSkuSaleAttrValue pmsSkuSaleAttrValue = pmsSkuSaleAttrValueService.findById(id);
        return Result.ok("查询成功", pmsSkuSaleAttrValue);
    }

    /***
     * 查询PmsSkuSaleAttrValue全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsSkuSaleAttrValueService实现查询所有PmsSkuSaleAttrValue
        List<PmsSkuSaleAttrValue> list = pmsSkuSaleAttrValueService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
