package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsSeckillPromotion;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillPromotionService
 * @Description TODO
 */
public interface SmsSeckillPromotionService {

    /***
     * SmsSeckillPromotion多条件分页查询
     * @param smsSeckillPromotion
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSeckillPromotion> findPage(SmsSeckillPromotion smsSeckillPromotion, int page, int size);

    /***
     * SmsSeckillPromotion分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSeckillPromotion> findPage(int page, int size);

    /***
     * SmsSeckillPromotion多条件搜索方法
     * @param smsSeckillPromotion
     * @return
     */
    List<SmsSeckillPromotion> findList(SmsSeckillPromotion smsSeckillPromotion);

    /***
     * 删除SmsSeckillPromotion
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsSeckillPromotion数据
     * @param smsSeckillPromotion
     */
    void update(SmsSeckillPromotion smsSeckillPromotion);

    /***
     * 新增SmsSeckillPromotion
     * @param smsSeckillPromotion
     */
    void add(SmsSeckillPromotion smsSeckillPromotion);

    /**
     * 根据ID查询SmsSeckillPromotion
     * @param id
     * @return
     */
     SmsSeckillPromotion findById(Long id);

    /***
     * 查询所有SmsSeckillPromotion
     * @return
     */
    List<SmsSeckillPromotion> findAll();
}
