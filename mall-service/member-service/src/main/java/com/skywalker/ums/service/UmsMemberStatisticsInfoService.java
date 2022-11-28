package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsMemberStatisticsInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberStatisticsInfoService
 * @Description TODO
 */
public interface UmsMemberStatisticsInfoService {

    /***
     * UmsMemberStatisticsInfo多条件分页查询
     * @param umsMemberStatisticsInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberStatisticsInfo> findPage(UmsMemberStatisticsInfo umsMemberStatisticsInfo, int page, int size);

    /***
     * UmsMemberStatisticsInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsMemberStatisticsInfo> findPage(int page, int size);

    /***
     * UmsMemberStatisticsInfo多条件搜索方法
     * @param umsMemberStatisticsInfo
     * @return
     */
    List<UmsMemberStatisticsInfo> findList(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /***
     * 删除UmsMemberStatisticsInfo
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsMemberStatisticsInfo数据
     * @param umsMemberStatisticsInfo
     */
    void update(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /***
     * 新增UmsMemberStatisticsInfo
     * @param umsMemberStatisticsInfo
     */
    void add(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /**
     * 根据ID查询UmsMemberStatisticsInfo
     * @param id
     * @return
     */
     UmsMemberStatisticsInfo findById(Long id);

    /***
     * 查询所有UmsMemberStatisticsInfo
     * @return
     */
    List<UmsMemberStatisticsInfo> findAll();
}
