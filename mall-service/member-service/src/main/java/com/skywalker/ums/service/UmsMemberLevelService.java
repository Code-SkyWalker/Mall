package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsMemberLevel;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLevelService
 * @Description TODO
 */
public interface UmsMemberLevelService {

    /***
     * UmsMemberLevel多条件分页查询
     * @param umsMemberLevel
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberLevel> findPage(UmsMemberLevel umsMemberLevel, int page, int size);

    /***
     * UmsMemberLevel分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberLevel> findPage(int page, int size);

    /***
     * UmsMemberLevel多条件搜索方法
     * @param umsMemberLevel
     * @return
     */
    List<UmsMemberLevel> findList(UmsMemberLevel umsMemberLevel);

    /***
     * 删除UmsMemberLevel
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsMemberLevel数据
     * @param umsMemberLevel
     */
    void update(UmsMemberLevel umsMemberLevel);

    /***
     * 新增UmsMemberLevel
     * @param umsMemberLevel
     */
    void add(UmsMemberLevel umsMemberLevel);

    /**
     * 根据ID查询UmsMemberLevel
     * @param id
     * @return
     */
     UmsMemberLevel findById(Long id);

    /***
     * 查询所有UmsMemberLevel
     * @return
     */
    List<UmsMemberLevel> findAll();
}
