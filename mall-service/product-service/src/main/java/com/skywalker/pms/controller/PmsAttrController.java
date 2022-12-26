package com.skywalker.pms.controller;

import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.service.PmsAttrService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;

import com.skywalker.pms.vo.AttrGroupsAndAttrs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrController
 * @Description TODO
 */

@RestController
@RequestMapping("/attr")
public class PmsAttrController {

    @Autowired
    private PmsAttrService pmsAttrService;

    /***
     * PmsAttr分页条件搜索实现
     * @param pmsAttr
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{attrType}/{page}/{size}")
    public Result findPage(@RequestBody(required = false) PmsAttr pmsAttr,
                           @PathVariable(name = "attrType") String attrType,
                           @PathVariable int page, @PathVariable int size) {
        //调用PmsAttrService实现分页条件查询PmsAttr
        PageInfo<PmsAttr> pageInfo = pmsAttrService.findPage(attrType, pmsAttr, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsAttr分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result findPage(@PathVariable int page, @PathVariable int size) {
        //调用PmsAttrService实现分页查询PmsAttr
        PageInfo<PmsAttr> pageInfo = pmsAttrService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsAttr
     * @return
     */
    @PostMapping(value = "/search")
    public Result findList(@RequestBody(required = false) PmsAttr pmsAttr) {
        //调用PmsAttrService实现条件查询PmsAttr
        List<PmsAttr> list = pmsAttrService.findList(pmsAttr);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Long id) {
        //调用PmsAttrService实现根据主键删除
        pmsAttrService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 根据ID删除品牌数据
     * @param ids
     * @return
     */
    @PostMapping(value = "/delete")
    public Result delete(@RequestBody List<Long> ids) {
        //调用PmsAttrService实现根据主键删除
        pmsAttrService.delete(ids);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsAttr数据
     * @param pmsAttr
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody PmsAttr pmsAttr, @PathVariable Long id) {
        //设置主键值
        pmsAttr.setAttrId(id);
        //调用PmsAttrService实现修改PmsAttr
        pmsAttrService.update(pmsAttr);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsAttr数据
     * @param pmsAttr
     * @return
     */
    @PostMapping
    public Result add(@RequestBody PmsAttr pmsAttr) {
        //调用PmsAttrService实现添加PmsAttr
        pmsAttrService.add(pmsAttr);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsAttr数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id) {
        //调用PmsAttrService实现根据主键查询PmsAttr
        PmsAttr pmsAttr = pmsAttrService.findById(id);
        return Result.ok("查询成功", pmsAttr);
    }

    /***
     * 查询PmsAttr全部数据
     * @return
     */
    @GetMapping
    public Result findAll() {
        //调用PmsAttrService实现查询所有PmsAttr
        List<PmsAttr> list = pmsAttrService.findAll();
        return Result.ok("查询成功", list);
    }

    /**
     * 根据 categoryID 查询 属性
     *
     * @param categoryId 分类id
     * @return /
     */
    @GetMapping("/{attrType}/findAttrByCategoryId/{categoryId}/{page}/{size}")
    public Result findAttrByCategoryId(@PathVariable(name = "categoryId") Long categoryId,
                                       @PathVariable(name = "attrType") String attrType,
                                       @PathVariable(name = "page") int page,
                                       @PathVariable(name = "size") int size) {
        List<PmsAttr> brands = pmsAttrService.findAttrByCategoryId(attrType, categoryId, page, size);
        int count = pmsAttrService.findAttrByCategoryIdCount(attrType, categoryId);
        return Result.ok("查询成功").put("data", brands).put("count", count);
    }

    /**
     * 获取当前分组没有关联的所有属性
     * @param attrName
     * @param attrGroupId
     * @return
     */
    @PostMapping("/noRelationAttr/{attrGroupId}/{page}/{size}")
    public Result getNotRelationAttr(@RequestParam(name = "attrName", required = false) String attrName,
                                     @PathVariable(name = "attrGroupId") Long attrGroupId,
                                     @PathVariable(name = "page") int page,
                                     @PathVariable(name = "size") int size) {

        PageInfo<PmsAttr> notRelationAttr = pmsAttrService.getNotRelationAttr(attrGroupId, attrName, page, size);
        return Result.ok(notRelationAttr);
    }

}
