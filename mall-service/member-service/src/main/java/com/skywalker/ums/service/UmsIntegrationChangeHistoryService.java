package com.skywalker.ums.service;
import com.skywalker.ums.pojo.UmsIntegrationChangeHistory;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsIntegrationChangeHistoryService
 * @Description TODO
 */
public interface UmsIntegrationChangeHistoryService {

    /***
     * UmsIntegrationChangeHistory多条件分页查询
     * @param umsIntegrationChangeHistory
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsIntegrationChangeHistory> findPage(UmsIntegrationChangeHistory umsIntegrationChangeHistory, int page, int size);

    /***
     * UmsIntegrationChangeHistory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UmsIntegrationChangeHistory> findPage(int page, int size);

    /***
     * UmsIntegrationChangeHistory多条件搜索方法
     * @param umsIntegrationChangeHistory
     * @return
     */
    List<UmsIntegrationChangeHistory> findList(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /***
     * 删除UmsIntegrationChangeHistory
     * @param id
     */
    void delete(Long id);

    /***
     * 修改UmsIntegrationChangeHistory数据
     * @param umsIntegrationChangeHistory
     */
    void update(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /***
     * 新增UmsIntegrationChangeHistory
     * @param umsIntegrationChangeHistory
     */
    void add(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 根据ID查询UmsIntegrationChangeHistory
     * @param id
     * @return
     */
     UmsIntegrationChangeHistory findById(Long id);

    /***
     * 查询所有UmsIntegrationChangeHistory
     * @return
     */
    List<UmsIntegrationChangeHistory> findAll();
}
