package com.skywalker.pms.controller;

import com.skywalker.pms.pojo.PmsCategory;
import com.skywalker.pms.service.PmsCategoryService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryController
 * @Description TODO
 */

@RestController
@RequestMapping("/category")
//@CrossOrigin
public class PmsCategoryController {

    @Autowired
    private PmsCategoryService pmsCategoryService;

    /***
     * PmsCategory分页条件搜索实现
     * @param pmsCategory /
     * @param page /
     * @param size /
     * @return /
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result findPage(@RequestBody(required = false) PmsCategory pmsCategory, @PathVariable int page, @PathVariable int size) {
        //调用PmsCategoryService实现分页条件查询PmsCategory
        PageInfo<PmsCategory> pageInfo = pmsCategoryService.findPage(pmsCategory, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsCategory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return /
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result findPage(@PathVariable int page, @PathVariable int size) {
        //调用PmsCategoryService实现分页查询PmsCategory
        PageInfo<PmsCategory> pageInfo = pmsCategoryService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsCategory /
     * @return /
     */
    @PostMapping(value = "/search")
    public Result findList(@RequestBody(required = false) PmsCategory pmsCategory) {
        //调用PmsCategoryService实现条件查询PmsCategory
        List<PmsCategory> list = pmsCategoryService.findList(pmsCategory);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id /
     * @return /
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Long id) {
        //调用PmsCategoryService实现根据主键删除
        pmsCategoryService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 根据ID删除品牌数据
     * @param ids /
     * @return /
     */
    @PostMapping(value = "/delete")
    public Result delete(@RequestBody List<Long> ids) {
        //调用PmsCategoryService实现根据主键删除
        pmsCategoryService.delete(ids);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsCategory数据
     * @param pmsCategory /
     * @param id /
     * @return /
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody PmsCategory pmsCategory, @PathVariable Long id) {
        //设置主键值
        pmsCategory.setCatId(id);
        //调用PmsCategoryService实现修改PmsCategory
        pmsCategoryService.update(pmsCategory);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsCategory数据
     * @param pmsCategory /
     * @return /
     */
    @PostMapping
    public Result add(@RequestBody PmsCategory pmsCategory) {
        //调用PmsCategoryService实现添加PmsCategory
        pmsCategoryService.add(pmsCategory);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsCategory数据
     * @param id /
     * @return /
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id) {
        //调用PmsCategoryService实现根据主键查询PmsCategory
        PmsCategory pmsCategory = pmsCategoryService.findById(id);
        return Result.ok("查询成功").put("category", pmsCategory);
    }

    /***
     * 查询PmsCategory全部数据
     * @return /
     */
    @GetMapping
    public Result findAll() {
        //调用PmsCategoryService实现查询所有PmsCategory
        List<PmsCategory> list = pmsCategoryService.findAll();
        return Result.ok("查询成功", list);
    }
}
