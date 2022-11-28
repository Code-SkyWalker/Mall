package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsHomeAdv;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsHomeAdvService
 * @Description TODO
 */
public interface SmsHomeAdvService {

    /***
     * SmsHomeAdv多条件分页查询
     * @param smsHomeAdv
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsHomeAdv> findPage(SmsHomeAdv smsHomeAdv, int page, int size);

    /***
     * SmsHomeAdv分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsHomeAdv> findPage(int page, int size);

    /***
     * SmsHomeAdv多条件搜索方法
     * @param smsHomeAdv
     * @return
     */
    List<SmsHomeAdv> findList(SmsHomeAdv smsHomeAdv);

    /***
     * 删除SmsHomeAdv
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsHomeAdv数据
     * @param smsHomeAdv
     */
    void update(SmsHomeAdv smsHomeAdv);

    /***
     * 新增SmsHomeAdv
     * @param smsHomeAdv
     */
    void add(SmsHomeAdv smsHomeAdv);

    /**
     * 根据ID查询SmsHomeAdv
     * @param id
     * @return
     */
     SmsHomeAdv findById(Long id);

    /***
     * 查询所有SmsHomeAdv
     * @return
     */
    List<SmsHomeAdv> findAll();
}
