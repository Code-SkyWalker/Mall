package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsSpuComment;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuCommentService
 * @Description TODO
 */
public interface PmsSpuCommentService {

    /***
     * PmsSpuComment多条件分页查询
     * @param pmsSpuComment
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSpuComment> findPage(PmsSpuComment pmsSpuComment, int page, int size);

    /***
     * PmsSpuComment分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSpuComment> findPage(int page, int size);

    /***
     * PmsSpuComment多条件搜索方法
     * @param pmsSpuComment
     * @return
     */
    List<PmsSpuComment> findList(PmsSpuComment pmsSpuComment);

    /***
     * 删除PmsSpuComment
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsSpuComment数据
     * @param pmsSpuComment
     */
    void update(PmsSpuComment pmsSpuComment);

    /***
     * 新增PmsSpuComment
     * @param pmsSpuComment
     */
    void add(PmsSpuComment pmsSpuComment);

    /**
     * 根据ID查询PmsSpuComment
     * @param id
     * @return
     */
     PmsSpuComment findById(Long id);

    /***
     * 查询所有PmsSpuComment
     * @return
     */
    List<PmsSpuComment> findAll();
}
