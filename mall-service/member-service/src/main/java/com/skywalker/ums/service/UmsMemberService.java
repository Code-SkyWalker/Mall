package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsMember;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberService
 * @Description TODO
 */
public interface UmsMemberService {

    /***
     * UmsMember多条件分页查询
     * @param umsMember
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMember> findPage(UmsMember umsMember, int page, int size);

    /***
     * UmsMember分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMember> findPage(int page, int size);

    /***
     * UmsMember多条件搜索方法
     * @param umsMember
     * @return
     */
    List<UmsMember> findList(UmsMember umsMember);

    /***
     * 删除UmsMember
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsMember数据
     * @param umsMember
     */
    void update(UmsMember umsMember);

    /***
     * 新增UmsMember
     * @param umsMember
     */
    void add(UmsMember umsMember);

    /**
     * 根据ID查询UmsMember
     * @param id
     * @return
     */
     UmsMember findById(Long id);

    /***
     * 查询所有UmsMember
     * @return
     */
    List<UmsMember> findAll();
}
