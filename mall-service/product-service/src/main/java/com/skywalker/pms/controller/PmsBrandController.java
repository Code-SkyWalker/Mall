package com.skywalker.pms.controller;

import com.skywalker.pms.pojo.PmsBrand;
import com.skywalker.pms.pojo.PmsCategory;
import com.skywalker.pms.pojo.PmsCategoryBrandRelation;
import com.skywalker.pms.service.PmsBrandService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result;

import com.skywalker.pms.service.PmsCategoryBrandRelationService;
import com.skywalker.pms.service.PmsCategoryService;
import com.skywalker.valid.ValidAdd;
import com.skywalker.valid.ValidUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsBrandController
 * @Description TODO
 */

@RestController
@RequestMapping("/brand")
//@CrossOrigin
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    @Autowired
    private PmsCategoryService pmsCategoryService;

    @Autowired
    private PmsCategoryBrandRelationService pmsCategoryBrandRelationService;

    /***
     * PmsBrand分页条件搜索实现
     * @param pmsBrand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result findPage(@RequestBody(required = false) PmsBrand pmsBrand, @PathVariable int page, @PathVariable int size) {
        //调用PmsBrandService实现分页条件查询PmsBrand
        PageInfo<PmsBrand> pageInfo = pmsBrandService.findPage(pmsBrand, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsBrand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result findPage(@PathVariable int page, @PathVariable int size) {
        //调用PmsBrandService实现分页查询PmsBrand
        PageInfo<PmsBrand> pageInfo = pmsBrandService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsBrand
     * @return
     */
    @PostMapping(value = "/search")
    public Result findList(@RequestBody(required = false) PmsBrand pmsBrand) {
        //调用PmsBrandService实现条件查询PmsBrand
        List<PmsBrand> list = pmsBrandService.findList(pmsBrand);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Long id) {
        //调用PmsBrandService实现根据主键删除
        pmsBrandService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 根据ID删除品牌数据
     * @param ids /
     * @return /
     */
    @PostMapping(value = "/delete")
    public Result deleteByIds(@RequestBody List<Long> ids) {
        //调用PmsBrandService实现根据主键删除
        pmsBrandService.deleteByIds(ids);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsBrand数据
     * @param pmsBrand /
     * @param id /
     * @return /
     */
    @PutMapping(value = "/{id}")
    public Result update(@Validated(ValidUpdate.class) @RequestBody PmsBrand pmsBrand, @PathVariable Long id) {
        //设置主键值
        pmsBrand.setBrandId(id);
        //调用PmsBrandService实现修改PmsBrand
        pmsBrandService.update(pmsBrand);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsBrand数据
     * @param pmsBrand
     * @return
     */
    @PostMapping
    public Result add(@Validated(ValidAdd.class) @RequestBody PmsBrand pmsBrand, @RequestParam("categoryId") Long categoryId) {
        //调用PmsBrandService实现添加PmsBrand
        pmsBrandService.add(pmsBrand);

        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsBrand数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id) {
        //调用PmsBrandService实现根据主键查询PmsBrand
        PmsBrand pmsBrand = pmsBrandService.findById(id);

        // 查询 Brand所属分类
        return Result.ok("查询成功", pmsBrand);
    }

    /***
     * 查询PmsBrand全部数据
     * @return
     */
    @GetMapping
    public Result findAll() {
        //调用PmsBrandService实现查询所有PmsBrand
        List<PmsBrand> list = pmsBrandService.findAll();
        return Result.ok("查询成功", list);
    }


    /**
     * 根据 categoryID 查询 品牌
     *
     * @param categoryId 分类id
     * @return /
     */
    @GetMapping("/findBrandByCategoryId/{categoryId}/{page}/{size}")
    public Result findBrandByCategoryId(@PathVariable(name = "categoryId") Long categoryId,
                                        @PathVariable(name = "page") int page,
                                        @PathVariable(name = "size") int size) {
        List<PmsBrand> brands = pmsBrandService.findBrandByCategoryId(categoryId, page, size);
        int count = pmsBrandService.findBrandByCategoryIdCount(categoryId);
        return Result.ok("查询成功").put("data", brands).put("count", count);
    }
}
