package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsCouponSpuRelation;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuRelationService
 * @Description TODO
 */
public interface SmsCouponSpuRelationService {

    /***
     * SmsCouponSpuRelation多条件分页查询
     * @param smsCouponSpuRelation
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsCouponSpuRelation> findPage(SmsCouponSpuRelation smsCouponSpuRelation, int page, int size);

    /***
     * SmsCouponSpuRelation分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsCouponSpuRelation> findPage(int page, int size);

    /***
     * SmsCouponSpuRelation多条件搜索方法
     * @param smsCouponSpuRelation
     * @return
     */
    List<SmsCouponSpuRelation> findList(SmsCouponSpuRelation smsCouponSpuRelation);

    /***
     * 删除SmsCouponSpuRelation
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsCouponSpuRelation数据
     * @param smsCouponSpuRelation
     */
    void update(SmsCouponSpuRelation smsCouponSpuRelation);

    /***
     * 新增SmsCouponSpuRelation
     * @param smsCouponSpuRelation
     */
    void add(SmsCouponSpuRelation smsCouponSpuRelation);

    /**
     * 根据ID查询SmsCouponSpuRelation
     * @param id
     * @return
     */
     SmsCouponSpuRelation findById(Long id);

    /***
     * 查询所有SmsCouponSpuRelation
     * @return
     */
    List<SmsCouponSpuRelation> findAll();
}
