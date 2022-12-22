package com.skywalker.pms.controller;

import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.pojo.PmsAttrAttrgroupRelation;
import com.skywalker.pms.service.PmsAttrAttrgroupRelationService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrAttrgroupRelationController
 * @Description TODO
 */

@RestController
@RequestMapping("/attrAttrGroupRelation")
public class PmsAttrAttrGroupRelationController {

    @Autowired
    private PmsAttrAttrgroupRelationService pmsAttrAttrgroupRelationService;

    /**
     * PmsAttrAttrGroupRelation分页条件搜索实现
     *
     * @param pmsAttrAttrgroupRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result findPage(@RequestBody(required = false) PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation, @PathVariable int page, @PathVariable int size) {
        //调用PmsAttrAttrgroupRelationService实现分页条件查询PmsAttrAttrgroupRelation
        PageInfo<PmsAttrAttrgroupRelation> pageInfo = pmsAttrAttrgroupRelationService.findPage(pmsAttrAttrgroupRelation, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    @PostMapping(value = "/search/{attrGroupId}/{page}/{size}")
    public Result findRelatedAttr(@PathVariable(name = "attrGroupId") Long attrGroupId,
                                  @PathVariable int page, @PathVariable int size,
                                  @RequestParam(name = "attrName", required = false) String attrName) {
        List<PmsAttr> relatedAttr = pmsAttrAttrgroupRelationService.getRelatedAttr(attrGroupId, attrName, page, size);
        int count = pmsAttrAttrgroupRelationService.relatedAttrCount(attrGroupId);
        return Result.ok("查询属性成功", relatedAttr).put("count", count);
    }

    /**
     * PmsAttrAttrgroupRelation分页搜索实现
     *
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result findPage(@PathVariable int page, @PathVariable int size) {
        //调用PmsAttrAttrgroupRelationService实现分页查询PmsAttrAttrgroupRelation
        PageInfo<PmsAttrAttrgroupRelation> pageInfo = pmsAttrAttrgroupRelationService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /**
     * 多条件搜索品牌数据
     *
     * @param pmsAttrAttrgroupRelation
     * @return
     */
    @PostMapping(value = "/search")
    public Result findList(@RequestBody(required = false) PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        //调用PmsAttrAttrgroupRelationService实现条件查询PmsAttrAttrgroupRelation
        List<PmsAttrAttrgroupRelation> list = pmsAttrAttrgroupRelationService.findList(pmsAttrAttrgroupRelation);
        return Result.ok("查询成功", list);
    }

    /**
     * 根据ID删除品牌数据
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Long id) {
        //调用PmsAttrAttrgroupRelationService实现根据主键删除
        pmsAttrAttrgroupRelationService.delete(id);
        return Result.ok("删除成功");
    }

    @PostMapping(value = "/delete/{attrGroupId}")
    public Result delete(@RequestBody List<Long> ids, @PathVariable(name = "attrGroupId") Long attrGroupId) {
        pmsAttrAttrgroupRelationService.deleteByGroupIdAndAttrIds(ids, attrGroupId);
        return Result.ok("删除成功");
    }

    /**
     * 修改PmsAttrAttrgroupRelation数据
     *
     * @param pmsAttrAttrgroupRelation
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation, @PathVariable Long id) {
        //设置主键值
        pmsAttrAttrgroupRelation.setId(id);
        //调用PmsAttrAttrgroupRelationService实现修改PmsAttrAttrgroupRelation
        pmsAttrAttrgroupRelationService.update(pmsAttrAttrgroupRelation);
        return Result.ok("修改成功");
    }

    /**
     * 新增PmsAttrAttrgroupRelation数据
     *
     * @param pmsAttrAttrgroupRelation
     * @return
     */
    @PostMapping
    public Result add(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        //调用PmsAttrAttrgroupRelationService实现添加PmsAttrAttrgroupRelation
        pmsAttrAttrgroupRelationService.add(pmsAttrAttrgroupRelation);
        return Result.ok("添加成功");
    }

    /**
     * 新增PmsAttrAttrgroupRelation数据
     *
     * @param attrGroupId 分组ID
     * @param attrIds     List<Long>属性ID
     * @return
     */
    @PostMapping("/attr/relation/{attrGroupId}")
    public Result add(@PathVariable("attrGroupId") Long attrGroupId, @RequestBody List<Long> attrIds) {
        //调用PmsAttrAttrgroupRelationService实现添加PmsAttrAttrgroupRelation
        pmsAttrAttrgroupRelationService.addAsList(attrGroupId, attrIds);
        return Result.ok("添加成功");
    }

    /**
     * 根据ID查询PmsAttrAttrgroupRelation数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id) {
        //调用PmsAttrAttrgroupRelationService实现根据主键查询PmsAttrAttrgroupRelation
        PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation = pmsAttrAttrgroupRelationService.findById(id);
        return Result.ok("查询成功", pmsAttrAttrgroupRelation);
    }

    /**
     * 查询PmsAttrAttrgroupRelation全部数据
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        //调用PmsAttrAttrgroupRelationService实现查询所有PmsAttrAttrgroupRelation
        List<PmsAttrAttrgroupRelation> list = pmsAttrAttrgroupRelationService.findAll();
        return Result.ok("查询成功", list);
    }
}
