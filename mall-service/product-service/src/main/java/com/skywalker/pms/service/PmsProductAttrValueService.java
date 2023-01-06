package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsProductAttrValue;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsProductAttrValueService
 * @Description TODO
 */
public interface PmsProductAttrValueService {

    /**
     * 根据attr查询 spu 产品的基本属性
     * @param spuId
     * @return
     */
    List<PmsProductAttrValue> findBaseAttrBySpuId(Long spuId);

    /***
     * 新增PmsProductAttrValue
     * @param pmsProductAttrValue
     */
    void add(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 根据spuId 删除
     * @param spuId
     */
    void delete(Long spuId);

    void update(List<PmsProductAttrValue> list, Long spuId);



}
