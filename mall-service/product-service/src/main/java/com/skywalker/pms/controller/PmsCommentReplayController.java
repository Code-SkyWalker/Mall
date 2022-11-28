package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsCommentReplay;
import com.skywalker.pms.service.PmsCommentReplayService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsCommentReplayController
 * @Description TODO
 */

@RestController
@RequestMapping("/pmsCommentReplay")
@CrossOrigin
public class PmsCommentReplayController {

    @Autowired
    private PmsCommentReplayService pmsCommentReplayService;

    /***
     * PmsCommentReplay分页条件搜索实现
     * @param pmsCommentReplay
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsCommentReplay pmsCommentReplay, @PathVariable  int page, @PathVariable  int size){
        //调用PmsCommentReplayService实现分页条件查询PmsCommentReplay
        PageInfo<PmsCommentReplay> pageInfo = pmsCommentReplayService.findPage(pmsCommentReplay, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsCommentReplay分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsCommentReplayService实现分页查询PmsCommentReplay
        PageInfo<PmsCommentReplay> pageInfo = pmsCommentReplayService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsCommentReplay
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsCommentReplay pmsCommentReplay){
        //调用PmsCommentReplayService实现条件查询PmsCommentReplay
        List<PmsCommentReplay> list = pmsCommentReplayService.findList(pmsCommentReplay);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsCommentReplayService实现根据主键删除
        pmsCommentReplayService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsCommentReplay数据
     * @param pmsCommentReplay
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsCommentReplay pmsCommentReplay,@PathVariable Long id){
        //设置主键值
        pmsCommentReplay.setId(id);
        //调用PmsCommentReplayService实现修改PmsCommentReplay
        pmsCommentReplayService.update(pmsCommentReplay);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsCommentReplay数据
     * @param pmsCommentReplay
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsCommentReplay pmsCommentReplay){
        //调用PmsCommentReplayService实现添加PmsCommentReplay
        pmsCommentReplayService.add(pmsCommentReplay);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsCommentReplay数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsCommentReplayService实现根据主键查询PmsCommentReplay
        PmsCommentReplay pmsCommentReplay = pmsCommentReplayService.findById(id);
        return Result.ok("查询成功", pmsCommentReplay);
    }

    /***
     * 查询PmsCommentReplay全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsCommentReplayService实现查询所有PmsCommentReplay
        List<PmsCommentReplay> list = pmsCommentReplayService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
