package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsGrowthChangeHistory;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsGrowthChangeHistoryService
 * @Description TODO
 */
public interface UmsGrowthChangeHistoryService {

    /***
     * UmsGrowthChangeHistory多条件分页查询
     * @param umsGrowthChangeHistory
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsGrowthChangeHistory> findPage(UmsGrowthChangeHistory umsGrowthChangeHistory, int page, int size);

    /***
     * UmsGrowthChangeHistory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsGrowthChangeHistory> findPage(int page, int size);

    /***
     * UmsGrowthChangeHistory多条件搜索方法
     * @param umsGrowthChangeHistory
     * @return
     */
    List<UmsGrowthChangeHistory> findList(UmsGrowthChangeHistory umsGrowthChangeHistory);

    /***
     * 删除UmsGrowthChangeHistory
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsGrowthChangeHistory数据
     * @param umsGrowthChangeHistory
     */
    void update(UmsGrowthChangeHistory umsGrowthChangeHistory);

    /***
     * 新增UmsGrowthChangeHistory
     * @param umsGrowthChangeHistory
     */
    void add(UmsGrowthChangeHistory umsGrowthChangeHistory);

    /**
     * 根据ID查询UmsGrowthChangeHistory
     * @param id
     * @return
     */
     UmsGrowthChangeHistory findById(Long id);

    /***
     * 查询所有UmsGrowthChangeHistory
     * @return
     */
    List<UmsGrowthChangeHistory> findAll();
}
