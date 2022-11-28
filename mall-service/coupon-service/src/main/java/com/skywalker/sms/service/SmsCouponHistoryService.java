package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsCouponHistory;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsCouponHistoryService
 * @Description TODO
 */
public interface SmsCouponHistoryService {

    /***
     * SmsCouponHistory多条件分页查询
     * @param smsCouponHistory
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsCouponHistory> findPage(SmsCouponHistory smsCouponHistory, int page, int size);

    /***
     * SmsCouponHistory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsCouponHistory> findPage(int page, int size);

    /***
     * SmsCouponHistory多条件搜索方法
     * @param smsCouponHistory
     * @return
     */
    List<SmsCouponHistory> findList(SmsCouponHistory smsCouponHistory);

    /***
     * 删除SmsCouponHistory
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsCouponHistory数据
     * @param smsCouponHistory
     */
    void update(SmsCouponHistory smsCouponHistory);

    /***
     * 新增SmsCouponHistory
     * @param smsCouponHistory
     */
    void add(SmsCouponHistory smsCouponHistory);

    /**
     * 根据ID查询SmsCouponHistory
     * @param id
     * @return
     */
     SmsCouponHistory findById(Long id);

    /***
     * 查询所有SmsCouponHistory
     * @return
     */
    List<SmsCouponHistory> findAll();
}
