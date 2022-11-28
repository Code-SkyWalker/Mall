package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsSkuFullReduction;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSkuFullReductionService
 * @Description TODO
 */
public interface SmsSkuFullReductionService {

    /***
     * SmsSkuFullReduction多条件分页查询
     * @param smsSkuFullReduction
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSkuFullReduction> findPage(SmsSkuFullReduction smsSkuFullReduction, int page, int size);

    /***
     * SmsSkuFullReduction分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSkuFullReduction> findPage(int page, int size);

    /***
     * SmsSkuFullReduction多条件搜索方法
     * @param smsSkuFullReduction
     * @return
     */
    List<SmsSkuFullReduction> findList(SmsSkuFullReduction smsSkuFullReduction);

    /***
     * 删除SmsSkuFullReduction
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsSkuFullReduction数据
     * @param smsSkuFullReduction
     */
    void update(SmsSkuFullReduction smsSkuFullReduction);

    /***
     * 新增SmsSkuFullReduction
     * @param smsSkuFullReduction
     */
    void add(SmsSkuFullReduction smsSkuFullReduction);

    /**
     * 根据ID查询SmsSkuFullReduction
     * @param id
     * @return
     */
     SmsSkuFullReduction findById(Long id);

    /***
     * 查询所有SmsSkuFullReduction
     * @return
     */
    List<SmsSkuFullReduction> findAll();
}
