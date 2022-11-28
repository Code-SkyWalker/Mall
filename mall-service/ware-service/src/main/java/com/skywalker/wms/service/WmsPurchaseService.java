package com.skywalker.wms.service;
import com.skywalker.wms.pojo.WmsPurchase;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseService
 * @Description TODO
 */
public interface WmsPurchaseService {

    /***
     * WmsPurchase多条件分页查询
     * @param wmsPurchase
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsPurchase> findPage(WmsPurchase wmsPurchase, int page, int size);

    /***
     * WmsPurchase分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WmsPurchase> findPage(int page, int size);

    /***
     * WmsPurchase多条件搜索方法
     * @param wmsPurchase
     * @return
     */
    List<WmsPurchase> findList(WmsPurchase wmsPurchase);

    /***
     * 删除WmsPurchase
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WmsPurchase数据
     * @param wmsPurchase
     */
    void update(WmsPurchase wmsPurchase);

    /***
     * 新增WmsPurchase
     * @param wmsPurchase
     */
    void add(WmsPurchase wmsPurchase);

    /**
     * 根据ID查询WmsPurchase
     * @param id
     * @return
     */
     WmsPurchase findById(Long id);

    /***
     * 查询所有WmsPurchase
     * @return
     */
    List<WmsPurchase> findAll();
}
