package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsCoupon;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsCouponService
 * @Description TODO
 */
public interface SmsCouponService {

    /***
     * SmsCoupon多条件分页查询
     * @param smsCoupon
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsCoupon> findPage(SmsCoupon smsCoupon, int page, int size);

    /***
     * SmsCoupon分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsCoupon> findPage(int page, int size);

    /***
     * SmsCoupon多条件搜索方法
     * @param smsCoupon
     * @return
     */
    List<SmsCoupon> findList(SmsCoupon smsCoupon);

    /***
     * 删除SmsCoupon
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsCoupon数据
     * @param smsCoupon
     */
    void update(SmsCoupon smsCoupon);

    /***
     * 新增SmsCoupon
     * @param smsCoupon
     */
    void add(SmsCoupon smsCoupon);

    /**
     * 根据ID查询SmsCoupon
     * @param id
     * @return
     */
     SmsCoupon findById(Long id);

    /***
     * 查询所有SmsCoupon
     * @return
     */
    List<SmsCoupon> findAll();
}
