package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsSeckillSkuNotice;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuNoticeService
 * @Description TODO
 */
public interface SmsSeckillSkuNoticeService {

    /***
     * SmsSeckillSkuNotice多条件分页查询
     * @param smsSeckillSkuNotice
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSeckillSkuNotice> findPage(SmsSeckillSkuNotice smsSeckillSkuNotice, int page, int size);

    /***
     * SmsSeckillSkuNotice分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSeckillSkuNotice> findPage(int page, int size);

    /***
     * SmsSeckillSkuNotice多条件搜索方法
     * @param smsSeckillSkuNotice
     * @return
     */
    List<SmsSeckillSkuNotice> findList(SmsSeckillSkuNotice smsSeckillSkuNotice);

    /***
     * 删除SmsSeckillSkuNotice
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsSeckillSkuNotice数据
     * @param smsSeckillSkuNotice
     */
    void update(SmsSeckillSkuNotice smsSeckillSkuNotice);

    /***
     * 新增SmsSeckillSkuNotice
     * @param smsSeckillSkuNotice
     */
    void add(SmsSeckillSkuNotice smsSeckillSkuNotice);

    /**
     * 根据ID查询SmsSeckillSkuNotice
     * @param id
     * @return
     */
     SmsSeckillSkuNotice findById(Long id);

    /***
     * 查询所有SmsSeckillSkuNotice
     * @return
     */
    List<SmsSeckillSkuNotice> findAll();
}
