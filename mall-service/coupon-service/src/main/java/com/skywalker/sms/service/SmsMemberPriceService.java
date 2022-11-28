package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsMemberPrice;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsMemberPriceService
 * @Description TODO
 */
public interface SmsMemberPriceService {

    /***
     * SmsMemberPrice多条件分页查询
     * @param smsMemberPrice
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsMemberPrice> findPage(SmsMemberPrice smsMemberPrice, int page, int size);

    /***
     * SmsMemberPrice分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsMemberPrice> findPage(int page, int size);

    /***
     * SmsMemberPrice多条件搜索方法
     * @param smsMemberPrice
     * @return
     */
    List<SmsMemberPrice> findList(SmsMemberPrice smsMemberPrice);

    /***
     * 删除SmsMemberPrice
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsMemberPrice数据
     * @param smsMemberPrice
     */
    void update(SmsMemberPrice smsMemberPrice);

    /***
     * 新增SmsMemberPrice
     * @param smsMemberPrice
     */
    void add(SmsMemberPrice smsMemberPrice);

    /**
     * 根据ID查询SmsMemberPrice
     * @param id
     * @return
     */
     SmsMemberPrice findById(Long id);

    /***
     * 查询所有SmsMemberPrice
     * @return
     */
    List<SmsMemberPrice> findAll();
}
