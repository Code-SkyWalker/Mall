package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsMemberCollectSpu;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSpuService
 * @Description TODO
 */
public interface UmsMemberCollectSpuService {

    /***
     * UmsMemberCollectSpu多条件分页查询
     * @param umsMemberCollectSpu
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberCollectSpu> findPage(UmsMemberCollectSpu umsMemberCollectSpu, int page, int size);

    /***
     * UmsMemberCollectSpu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberCollectSpu> findPage(int page, int size);

    /***
     * UmsMemberCollectSpu多条件搜索方法
     * @param umsMemberCollectSpu
     * @return
     */
    List<UmsMemberCollectSpu> findList(UmsMemberCollectSpu umsMemberCollectSpu);

    /***
     * 删除UmsMemberCollectSpu
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsMemberCollectSpu数据
     * @param umsMemberCollectSpu
     */
    void update(UmsMemberCollectSpu umsMemberCollectSpu);

    /***
     * 新增UmsMemberCollectSpu
     * @param umsMemberCollectSpu
     */
    void add(UmsMemberCollectSpu umsMemberCollectSpu);

    /**
     * 根据ID查询UmsMemberCollectSpu
     * @param id
     * @return
     */
     UmsMemberCollectSpu findById(Long id);

    /***
     * 查询所有UmsMemberCollectSpu
     * @return
     */
    List<UmsMemberCollectSpu> findAll();
}
