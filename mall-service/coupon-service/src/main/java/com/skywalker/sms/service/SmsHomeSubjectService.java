package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsHomeSubject;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectService
 * @Description TODO
 */
public interface SmsHomeSubjectService {

    /***
     * SmsHomeSubject多条件分页查询
     * @param smsHomeSubject
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsHomeSubject> findPage(SmsHomeSubject smsHomeSubject, int page, int size);

    /***
     * SmsHomeSubject分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsHomeSubject> findPage(int page, int size);

    /***
     * SmsHomeSubject多条件搜索方法
     * @param smsHomeSubject
     * @return
     */
    List<SmsHomeSubject> findList(SmsHomeSubject smsHomeSubject);

    /***
     * 删除SmsHomeSubject
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsHomeSubject数据
     * @param smsHomeSubject
     */
    void update(SmsHomeSubject smsHomeSubject);

    /***
     * 新增SmsHomeSubject
     * @param smsHomeSubject
     */
    void add(SmsHomeSubject smsHomeSubject);

    /**
     * 根据ID查询SmsHomeSubject
     * @param id
     * @return
     */
     SmsHomeSubject findById(Long id);

    /***
     * 查询所有SmsHomeSubject
     * @return
     */
    List<SmsHomeSubject> findAll();
}
