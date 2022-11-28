package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsSeckillSkuRelation;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuRelationService
 * @Description TODO
 */
public interface SmsSeckillSkuRelationService {

    /***
     * SmsSeckillSkuRelation多条件分页查询
     * @param smsSeckillSkuRelation
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSeckillSkuRelation> findPage(SmsSeckillSkuRelation smsSeckillSkuRelation, int page, int size);

    /***
     * SmsSeckillSkuRelation分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSeckillSkuRelation> findPage(int page, int size);

    /***
     * SmsSeckillSkuRelation多条件搜索方法
     * @param smsSeckillSkuRelation
     * @return
     */
    List<SmsSeckillSkuRelation> findList(SmsSeckillSkuRelation smsSeckillSkuRelation);

    /***
     * 删除SmsSeckillSkuRelation
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsSeckillSkuRelation数据
     * @param smsSeckillSkuRelation
     */
    void update(SmsSeckillSkuRelation smsSeckillSkuRelation);

    /***
     * 新增SmsSeckillSkuRelation
     * @param smsSeckillSkuRelation
     */
    void add(SmsSeckillSkuRelation smsSeckillSkuRelation);

    /**
     * 根据ID查询SmsSeckillSkuRelation
     * @param id
     * @return
     */
     SmsSeckillSkuRelation findById(Long id);

    /***
     * 查询所有SmsSeckillSkuRelation
     * @return
     */
    List<SmsSeckillSkuRelation> findAll();
}
