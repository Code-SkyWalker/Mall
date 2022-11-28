package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsSkuLadder;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSkuLadderService
 * @Description TODO
 */
public interface SmsSkuLadderService {

    /***
     * SmsSkuLadder多条件分页查询
     * @param smsSkuLadder
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSkuLadder> findPage(SmsSkuLadder smsSkuLadder, int page, int size);

    /***
     * SmsSkuLadder分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSkuLadder> findPage(int page, int size);

    /***
     * SmsSkuLadder多条件搜索方法
     * @param smsSkuLadder
     * @return
     */
    List<SmsSkuLadder> findList(SmsSkuLadder smsSkuLadder);

    /***
     * 删除SmsSkuLadder
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsSkuLadder数据
     * @param smsSkuLadder
     */
    void update(SmsSkuLadder smsSkuLadder);

    /***
     * 新增SmsSkuLadder
     * @param smsSkuLadder
     */
    void add(SmsSkuLadder smsSkuLadder);

    /**
     * 根据ID查询SmsSkuLadder
     * @param id
     * @return
     */
     SmsSkuLadder findById(Long id);

    /***
     * 查询所有SmsSkuLadder
     * @return
     */
    List<SmsSkuLadder> findAll();
}
