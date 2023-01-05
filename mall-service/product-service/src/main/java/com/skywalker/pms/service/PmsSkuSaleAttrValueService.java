package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.pojo.PmsSkuSaleAttrValue;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSkuSaleAttrValueService
 * @Description TODO
 */
public interface PmsSkuSaleAttrValueService {

    /***
     * PmsSkuSaleAttrValue多条件分页查询
     * @param pmsSkuSaleAttrValue
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSkuSaleAttrValue> findPage(PmsSkuSaleAttrValue pmsSkuSaleAttrValue, int page, int size);

    /***
     * PmsSkuSaleAttrValue分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsSkuSaleAttrValue> findPage(int page, int size);

    /***
     * PmsSkuSaleAttrValue多条件搜索方法
     * @param pmsSkuSaleAttrValue
     * @return
     */
    List<PmsSkuSaleAttrValue> findList(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /***
     * 删除PmsSkuSaleAttrValue
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsSkuSaleAttrValue数据
     * @param pmsSkuSaleAttrValue
     */
    void update(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /***
     * 新增PmsSkuSaleAttrValue
     * @param pmsSkuSaleAttrValue
     */
    void add(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /**
     * 根据ID查询PmsSkuSaleAttrValue
     * @param id
     * @return
     */
     PmsSkuSaleAttrValue findById(Long id);

    /***
     * 查询所有PmsSkuSaleAttrValue
     * @return
     */
    List<PmsSkuSaleAttrValue> findAll();

}
