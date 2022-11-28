package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsMemberReceiveAddress;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberReceiveAddressService
 * @Description TODO
 */
public interface UmsMemberReceiveAddressService {

    /***
     * UmsMemberReceiveAddress多条件分页查询
     * @param umsMemberReceiveAddress
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberReceiveAddress> findPage(UmsMemberReceiveAddress umsMemberReceiveAddress, int page, int size);

    /***
     * UmsMemberReceiveAddress分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberReceiveAddress> findPage(int page, int size);

    /***
     * UmsMemberReceiveAddress多条件搜索方法
     * @param umsMemberReceiveAddress
     * @return
     */
    List<UmsMemberReceiveAddress> findList(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /***
     * 删除UmsMemberReceiveAddress
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsMemberReceiveAddress数据
     * @param umsMemberReceiveAddress
     */
    void update(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /***
     * 新增UmsMemberReceiveAddress
     * @param umsMemberReceiveAddress
     */
    void add(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 根据ID查询UmsMemberReceiveAddress
     * @param id
     * @return
     */
     UmsMemberReceiveAddress findById(Long id);

    /***
     * 查询所有UmsMemberReceiveAddress
     * @return
     */
    List<UmsMemberReceiveAddress> findAll();
}
