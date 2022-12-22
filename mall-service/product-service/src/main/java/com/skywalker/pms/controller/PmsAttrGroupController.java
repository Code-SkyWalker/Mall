package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsAttrGroup;
import com.skywalker.pms.pojo.PmsBrand;
import com.skywalker.pms.service.PmsAttrGroupService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrGroupController
 * @Description TODO
 */

@RestController
@RequestMapping("/attrGroup")
public class PmsAttrGroupController {

    @Autowired
    private PmsAttrGroupService pmsAttrGroupService;

    /***
     * PmsAttrGroup分页条件搜索实现
     * @param pmsAttrGroup
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsAttrGroup pmsAttrGroup, @PathVariable  int page, @PathVariable  int size){
        //调用PmsAttrGroupService实现分页条件查询PmsAttrGroup
        PageInfo<PmsAttrGroup> pageInfo = pmsAttrGroupService.findPage(pmsAttrGroup, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsAttrGroup分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsAttrGroupService实现分页查询PmsAttrGroup
        PageInfo<PmsAttrGroup> pageInfo = pmsAttrGroupService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsAttrGroup
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsAttrGroup pmsAttrGroup){
        //调用PmsAttrGroupService实现条件查询PmsAttrGroup
        List<PmsAttrGroup> list = pmsAttrGroupService.findList(pmsAttrGroup);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsAttrGroupService实现根据主键删除
        pmsAttrGroupService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 根据ID删除品牌数据
     * @param ids
     * @return
     */
    @PostMapping(value = "/delete" )
    public Result delete(@RequestBody List<Long> ids){
        //调用PmsAttrGroupService实现根据主键删除
        pmsAttrGroupService.deleteByIds(ids);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsAttrGroup数据
     * @param pmsAttrGroup
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsAttrGroup pmsAttrGroup,@PathVariable Long id){
        //设置主键值
        pmsAttrGroup.setAttrGroupId(id);
        //调用PmsAttrGroupService实现修改PmsAttrGroup
        pmsAttrGroupService.update(pmsAttrGroup);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsAttrGroup数据
     * @param pmsAttrGroup
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsAttrGroup pmsAttrGroup){
        //调用PmsAttrGroupService实现添加PmsAttrGroup
        pmsAttrGroupService.add(pmsAttrGroup);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsAttrGroup数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsAttrGroupService实现根据主键查询PmsAttrGroup
        PmsAttrGroup pmsAttrGroup = pmsAttrGroupService.findById(id);
        return Result.ok("查询成功", pmsAttrGroup);
    }

    /***
     * 查询PmsAttrGroup全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsAttrGroupService实现查询所有PmsAttrGroup
        List<PmsAttrGroup> list = pmsAttrGroupService.findAll();
        return Result.ok("查询成功", list) ;
    }

    @GetMapping("/findAttrGroupByCategoryId/{categoryId}/{page}/{size}")
    public Result findAttrGroupByCategoryId(@PathVariable(name = "categoryId") Long categoryId,
                                        @PathVariable(name = "page") int page,
                                        @PathVariable(name = "size") int size) {
        List<PmsAttrGroup> brands = pmsAttrGroupService.findAttrGroupByCategoryId(categoryId, page, size);
        int count = pmsAttrGroupService.findBrandByCategoryIdCount(categoryId);
        return Result.ok("查询成功").put("data", brands).put("count", count);
    }
}
