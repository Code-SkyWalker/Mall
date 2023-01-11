package com.skywalker.wms.dao;

import com.skywalker.wms.pojo.WmsWareSku;
import com.skywalker.wms.vo.HasStockVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareSkuMapper
 * @Description TODO
 */
public interface WmsWareSkuMapper extends Mapper<WmsWareSku> {
    List<HasStockVo> getSkuHasStock(@Param("skuIds") List<Long> skuIds);
}
