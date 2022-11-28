package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsCouponSpuCategoryRelation;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuCategoryRelationService
 * @Description TODO
 */
public interface SmsCouponSpuCategoryRelationService {

    /***
     * SmsCouponSpuCategoryRelation多条件分页查询
     * @param smsCouponSpuCategoryRelation
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsCouponSpuCategoryRelation> findPage(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation, int page, int size);

    /***
     * SmsCouponSpuCategoryRelation分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsCouponSpuCategoryRelation> findPage(int page, int size);

    /***
     * SmsCouponSpuCategoryRelation多条件搜索方法
     * @param smsCouponSpuCategoryRelation
     * @return
     */
    List<SmsCouponSpuCategoryRelation> findList(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /***
     * 删除SmsCouponSpuCategoryRelation
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsCouponSpuCategoryRelation数据
     * @param smsCouponSpuCategoryRelation
     */
    void update(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /***
     * 新增SmsCouponSpuCategoryRelation
     * @param smsCouponSpuCategoryRelation
     */
    void add(SmsCouponSpuCategoryRelation smsCouponSpuCategoryRelation);

    /**
     * 根据ID查询SmsCouponSpuCategoryRelation
     * @param id
     * @return
     */
     SmsCouponSpuCategoryRelation findById(Long id);

    /***
     * 查询所有SmsCouponSpuCategoryRelation
     * @return
     */
    List<SmsCouponSpuCategoryRelation> findAll();
}
