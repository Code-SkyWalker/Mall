package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsProductAttrValue;
import com.skywalker.pms.service.PmsProductAttrValueService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsProductAttrValueController
 * @Description TODO
 */

@RestController
@RequestMapping("/pmsProductAttrValue")
@CrossOrigin
public class PmsProductAttrValueController {

    @Autowired
    private PmsProductAttrValueService pmsProductAttrValueService;

    /***
     * PmsProductAttrValue分页条件搜索实现
     * @param pmsProductAttrValue
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsProductAttrValue pmsProductAttrValue, @PathVariable  int page, @PathVariable  int size){
        //调用PmsProductAttrValueService实现分页条件查询PmsProductAttrValue
        PageInfo<PmsProductAttrValue> pageInfo = pmsProductAttrValueService.findPage(pmsProductAttrValue, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsProductAttrValue分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsProductAttrValueService实现分页查询PmsProductAttrValue
        PageInfo<PmsProductAttrValue> pageInfo = pmsProductAttrValueService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsProductAttrValue
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsProductAttrValue pmsProductAttrValue){
        //调用PmsProductAttrValueService实现条件查询PmsProductAttrValue
        List<PmsProductAttrValue> list = pmsProductAttrValueService.findList(pmsProductAttrValue);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsProductAttrValueService实现根据主键删除
        pmsProductAttrValueService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsProductAttrValue数据
     * @param pmsProductAttrValue
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsProductAttrValue pmsProductAttrValue,@PathVariable Long id){
        //设置主键值
        pmsProductAttrValue.setId(id);
        //调用PmsProductAttrValueService实现修改PmsProductAttrValue
        pmsProductAttrValueService.update(pmsProductAttrValue);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsProductAttrValue数据
     * @param pmsProductAttrValue
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsProductAttrValue pmsProductAttrValue){
        //调用PmsProductAttrValueService实现添加PmsProductAttrValue
        pmsProductAttrValueService.add(pmsProductAttrValue);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsProductAttrValue数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsProductAttrValueService实现根据主键查询PmsProductAttrValue
        PmsProductAttrValue pmsProductAttrValue = pmsProductAttrValueService.findById(id);
        return Result.ok("查询成功", pmsProductAttrValue);
    }

    /***
     * 查询PmsProductAttrValue全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsProductAttrValueService实现查询所有PmsProductAttrValue
        List<PmsProductAttrValue> list = pmsProductAttrValueService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
