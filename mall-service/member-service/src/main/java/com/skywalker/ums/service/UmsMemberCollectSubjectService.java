package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsMemberCollectSubject;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSubjectService
 * @Description TODO
 */
public interface UmsMemberCollectSubjectService {

    /***
     * UmsMemberCollectSubject多条件分页查询
     * @param umsMemberCollectSubject
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberCollectSubject> findPage(UmsMemberCollectSubject umsMemberCollectSubject, int page, int size);

    /***
     * UmsMemberCollectSubject分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberCollectSubject> findPage(int page, int size);

    /***
     * UmsMemberCollectSubject多条件搜索方法
     * @param umsMemberCollectSubject
     * @return
     */
    List<UmsMemberCollectSubject> findList(UmsMemberCollectSubject umsMemberCollectSubject);

    /***
     * 删除UmsMemberCollectSubject
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsMemberCollectSubject数据
     * @param umsMemberCollectSubject
     */
    void update(UmsMemberCollectSubject umsMemberCollectSubject);

    /***
     * 新增UmsMemberCollectSubject
     * @param umsMemberCollectSubject
     */
    void add(UmsMemberCollectSubject umsMemberCollectSubject);

    /**
     * 根据ID查询UmsMemberCollectSubject
     * @param id
     * @return
     */
     UmsMemberCollectSubject findById(Long id);

    /***
     * 查询所有UmsMemberCollectSubject
     * @return
     */
    List<UmsMemberCollectSubject> findAll();
}
