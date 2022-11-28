package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsHomeSubjectSpu;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectSpuService
 * @Description TODO
 */
public interface SmsHomeSubjectSpuService {

    /***
     * SmsHomeSubjectSpu多条件分页查询
     * @param smsHomeSubjectSpu
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsHomeSubjectSpu> findPage(SmsHomeSubjectSpu smsHomeSubjectSpu, int page, int size);

    /***
     * SmsHomeSubjectSpu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsHomeSubjectSpu> findPage(int page, int size);

    /***
     * SmsHomeSubjectSpu多条件搜索方法
     * @param smsHomeSubjectSpu
     * @return
     */
    List<SmsHomeSubjectSpu> findList(SmsHomeSubjectSpu smsHomeSubjectSpu);

    /***
     * 删除SmsHomeSubjectSpu
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsHomeSubjectSpu数据
     * @param smsHomeSubjectSpu
     */
    void update(SmsHomeSubjectSpu smsHomeSubjectSpu);

    /***
     * 新增SmsHomeSubjectSpu
     * @param smsHomeSubjectSpu
     */
    void add(SmsHomeSubjectSpu smsHomeSubjectSpu);

    /**
     * 根据ID查询SmsHomeSubjectSpu
     * @param id
     * @return
     */
     SmsHomeSubjectSpu findById(Long id);

    /***
     * 查询所有SmsHomeSubjectSpu
     * @return
     */
    List<SmsHomeSubjectSpu> findAll();
}
