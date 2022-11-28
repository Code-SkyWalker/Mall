package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsSkuImages;
import com.skywalker.pms.service.PmsSkuImagesService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsSkuImagesController
 * @Description TODO
 */

@RestController
@RequestMapping("/pmsSkuImages")
@CrossOrigin
public class PmsSkuImagesController {

    @Autowired
    private PmsSkuImagesService pmsSkuImagesService;

    /***
     * PmsSkuImages分页条件搜索实现
     * @param pmsSkuImages
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsSkuImages pmsSkuImages, @PathVariable  int page, @PathVariable  int size){
        //调用PmsSkuImagesService实现分页条件查询PmsSkuImages
        PageInfo<PmsSkuImages> pageInfo = pmsSkuImagesService.findPage(pmsSkuImages, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsSkuImages分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsSkuImagesService实现分页查询PmsSkuImages
        PageInfo<PmsSkuImages> pageInfo = pmsSkuImagesService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsSkuImages
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsSkuImages pmsSkuImages){
        //调用PmsSkuImagesService实现条件查询PmsSkuImages
        List<PmsSkuImages> list = pmsSkuImagesService.findList(pmsSkuImages);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsSkuImagesService实现根据主键删除
        pmsSkuImagesService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsSkuImages数据
     * @param pmsSkuImages
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsSkuImages pmsSkuImages,@PathVariable Long id){
        //设置主键值
        pmsSkuImages.setId(id);
        //调用PmsSkuImagesService实现修改PmsSkuImages
        pmsSkuImagesService.update(pmsSkuImages);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsSkuImages数据
     * @param pmsSkuImages
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsSkuImages pmsSkuImages){
        //调用PmsSkuImagesService实现添加PmsSkuImages
        pmsSkuImagesService.add(pmsSkuImages);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsSkuImages数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsSkuImagesService实现根据主键查询PmsSkuImages
        PmsSkuImages pmsSkuImages = pmsSkuImagesService.findById(id);
        return Result.ok("查询成功", pmsSkuImages);
    }

    /***
     * 查询PmsSkuImages全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsSkuImagesService实现查询所有PmsSkuImages
        List<PmsSkuImages> list = pmsSkuImagesService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
