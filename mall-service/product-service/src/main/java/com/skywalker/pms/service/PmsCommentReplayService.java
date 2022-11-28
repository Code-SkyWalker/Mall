package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsCommentReplay;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsCommentReplayService
 * @Description TODO
 */
public interface PmsCommentReplayService {

    /***
     * PmsCommentReplay多条件分页查询
     * @param pmsCommentReplay
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsCommentReplay> findPage(PmsCommentReplay pmsCommentReplay, int page, int size);

    /***
     * PmsCommentReplay分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsCommentReplay> findPage(int page, int size);

    /***
     * PmsCommentReplay多条件搜索方法
     * @param pmsCommentReplay
     * @return
     */
    List<PmsCommentReplay> findList(PmsCommentReplay pmsCommentReplay);

    /***
     * 删除PmsCommentReplay
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsCommentReplay数据
     * @param pmsCommentReplay
     */
    void update(PmsCommentReplay pmsCommentReplay);

    /***
     * 新增PmsCommentReplay
     * @param pmsCommentReplay
     */
    void add(PmsCommentReplay pmsCommentReplay);

    /**
     * 根据ID查询PmsCommentReplay
     * @param id
     * @return
     */
     PmsCommentReplay findById(Long id);

    /***
     * 查询所有PmsCommentReplay
     * @return
     */
    List<PmsCommentReplay> findAll();
}
