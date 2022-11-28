package com.skywalker.pms.controller;
import com.skywalker.pms.pojo.PmsSpuComment;
import com.skywalker.pms.service.PmsSpuCommentService;
import com.github.pagehelper.PageInfo;
import com.skywalker.entity.Result ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsSpuCommentController
 * @Description TODO
 */

@RestController
@RequestMapping("/pmsSpuComment")
@CrossOrigin
public class PmsSpuCommentController {

    @Autowired
    private PmsSpuCommentService pmsSpuCommentService;

    /***
     * PmsSpuComment分页条件搜索实现
     * @param pmsSpuComment
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false)  PmsSpuComment pmsSpuComment, @PathVariable  int page, @PathVariable  int size){
        //调用PmsSpuCommentService实现分页条件查询PmsSpuComment
        PageInfo<PmsSpuComment> pageInfo = pmsSpuCommentService.findPage(pmsSpuComment, page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * PmsSpuComment分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PmsSpuCommentService实现分页查询PmsSpuComment
        PageInfo<PmsSpuComment> pageInfo = pmsSpuCommentService.findPage(page, size);
        return Result.ok("查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pmsSpuComment
     * @return
     */
    @PostMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  PmsSpuComment pmsSpuComment){
        //调用PmsSpuCommentService实现条件查询PmsSpuComment
        List<PmsSpuComment> list = pmsSpuCommentService.findList(pmsSpuComment);
        return Result.ok("查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PmsSpuCommentService实现根据主键删除
        pmsSpuCommentService.delete(id);
        return Result.ok("删除成功");
    }

    /***
     * 修改PmsSpuComment数据
     * @param pmsSpuComment
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  PmsSpuComment pmsSpuComment,@PathVariable Long id){
        //设置主键值
        pmsSpuComment.setId(id);
        //调用PmsSpuCommentService实现修改PmsSpuComment
        pmsSpuCommentService.update(pmsSpuComment);
        return Result.ok("修改成功");
    }

    /***
     * 新增PmsSpuComment数据
     * @param pmsSpuComment
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   PmsSpuComment pmsSpuComment){
        //调用PmsSpuCommentService实现添加PmsSpuComment
        pmsSpuCommentService.add(pmsSpuComment);
        return Result.ok("添加成功");
    }

    /***
     * 根据ID查询PmsSpuComment数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        //调用PmsSpuCommentService实现根据主键查询PmsSpuComment
        PmsSpuComment pmsSpuComment = pmsSpuCommentService.findById(id);
        return Result.ok("查询成功", pmsSpuComment);
    }

    /***
     * 查询PmsSpuComment全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        //调用PmsSpuCommentService实现查询所有PmsSpuComment
        List<PmsSpuComment> list = pmsSpuCommentService.findAll();
        return Result.ok("查询成功", list) ;
    }
}
