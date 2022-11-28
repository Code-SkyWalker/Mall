package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsSpuImages;
import com.skywalker.pms.service.PmsSpuImagesService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsSpuImagesController
 * @Description TODO
 */

@RestController
@RequestMapping("/pmsSpuImages")
@CrossOrigin
public class PmsSpuImagesController {

    @Autowired
    private PmsSpuImagesService pmsSpuImagesService;

    /***
     * PmsSpuImages分页条件搜索实现
     * @param pmsSpuImages
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsSpuImages pmsSpuImages, @PathVariable  int page, @PathVariable  int size){
        //调用PmsSpuImagesService实现分页条件查询PmsSpuImages
        PageInfo<PmsSpuImages> pageInfo = pmsSpuImagesService.findPage(pmsSpuImages, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsSpuImages分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsSpuImagesService实现分页查询PmsSpuImages
        PageInfo<PmsSpuImages> pageInfo = pmsSpuImagesService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsSpuImages
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsSpuImages pmsSpuImages){
        //调用PmsSpuImagesService实现条件查询PmsSpuImages
        List<PmsSpuImages> list = pmsSpuImagesService.findList(pmsSpuImages);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsSpuImagesService实现根据主键删除
        pmsSpuImagesService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsSpuImages数据
     * @param pmsSpuImages
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsSpuImages pmsSpuImages,@PathVariable Long id){
        //设置主键值
        pmsSpuImages.setId(id);
        //调用PmsSpuImagesService实现修改PmsSpuImages
        pmsSpuImagesService.update(pmsSpuImages);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsSpuImages数据
     * @param pmsSpuImages
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsSpuImages pmsSpuImages){
        //调用PmsSpuImagesService实现添加PmsSpuImages
        pmsSpuImagesService.add(pmsSpuImages);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsSpuImages数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsSpuImagesService实现根据主键查询PmsSpuImages
        PmsSpuImages pmsSpuImages = pmsSpuImagesService.findById(id);
        return Result.ok("查询成功", pmsSpuImages);
    }

    /***
     * 查询PmsSpuImages全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsSpuImagesService实现查询所有PmsSpuImages
        List<PmsSpuImages> list = pmsSpuImagesService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
