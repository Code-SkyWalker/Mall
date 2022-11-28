package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsSpuBounds;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSpuBoundsService
 * @Description TODO
 */
public interface SmsSpuBoundsService {

    /***
     * SmsSpuBounds多条件分页查询
     * @param smsSpuBounds
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSpuBounds> findPage(SmsSpuBounds smsSpuBounds, int page, int size);

    /***
     * SmsSpuBounds分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSpuBounds> findPage(int page, int size);

    /***
     * SmsSpuBounds多条件搜索方法
     * @param smsSpuBounds
     * @return
     */
    List<SmsSpuBounds> findList(SmsSpuBounds smsSpuBounds);

    /***
     * 删除SmsSpuBounds
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsSpuBounds数据
     * @param smsSpuBounds
     */
    void update(SmsSpuBounds smsSpuBounds);

    /***
     * 新增SmsSpuBounds
     * @param smsSpuBounds
     */
    void add(SmsSpuBounds smsSpuBounds);

    /**
     * 根据ID查询SmsSpuBounds
     * @param id
     * @return
     */
     SmsSpuBounds findById(Long id);

    /***
     * 查询所有SmsSpuBounds
     * @return
     */
    List<SmsSpuBounds> findAll();
}
