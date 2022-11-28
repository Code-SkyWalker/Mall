package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsProductAttrValue;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsProductAttrValueService
 * @Description TODO
 */
public interface PmsProductAttrValueService {

    /***
     * PmsProductAttrValue多条件分页查询
     * @param pmsProductAttrValue
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsProductAttrValue> findPage(PmsProductAttrValue pmsProductAttrValue, int page, int size);

    /***
     * PmsProductAttrValue分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsProductAttrValue> findPage(int page, int size);

    /***
     * PmsProductAttrValue多条件搜索方法
     * @param pmsProductAttrValue
     * @return
     */
    List<PmsProductAttrValue> findList(PmsProductAttrValue pmsProductAttrValue);

    /***
     * 删除PmsProductAttrValue
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsProductAttrValue数据
     * @param pmsProductAttrValue
     */
    void update(PmsProductAttrValue pmsProductAttrValue);

    /***
     * 新增PmsProductAttrValue
     * @param pmsProductAttrValue
     */
    void add(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 根据ID查询PmsProductAttrValue
     * @param id
     * @return
     */
     PmsProductAttrValue findById(Long id);

    /***
     * 查询所有PmsProductAttrValue
     * @return
     */
    List<PmsProductAttrValue> findAll();
}
