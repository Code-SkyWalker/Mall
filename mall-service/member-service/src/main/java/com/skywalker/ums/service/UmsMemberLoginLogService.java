package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsMemberLoginLog;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLoginLogService
 * @Description TODO
 */
public interface UmsMemberLoginLogService {

    /***
     * UmsMemberLoginLog多条件分页查询
     * @param umsMemberLoginLog
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberLoginLog> findPage(UmsMemberLoginLog umsMemberLoginLog, int page, int size);

    /***
     * UmsMemberLoginLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberLoginLog> findPage(int page, int size);

    /***
     * UmsMemberLoginLog多条件搜索方法
     * @param umsMemberLoginLog
     * @return
     */
    List<UmsMemberLoginLog> findList(UmsMemberLoginLog umsMemberLoginLog);

    /***
     * 删除UmsMemberLoginLog
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsMemberLoginLog数据
     * @param umsMemberLoginLog
     */
    void update(UmsMemberLoginLog umsMemberLoginLog);

    /***
     * 新增UmsMemberLoginLog
     * @param umsMemberLoginLog
     */
    void add(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 根据ID查询UmsMemberLoginLog
     * @param id
     * @return
     */
     UmsMemberLoginLog findById(Long id);

    /***
     * 查询所有UmsMemberLoginLog
     * @return
     */
    List<UmsMemberLoginLog> findAll();
}
