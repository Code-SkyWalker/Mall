package com.skywalker.pms.dao;

import com.skywalker.pms.pojo.PmsBrand;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsBrandMapper
 * @Description TODO
 */
public interface PmsBrandMapper extends Mapper<PmsBrand> {

    /**
     * 根据 分类ID 查询品牌
     * @param categoryId categoryId
     * @param page  /
     * @param size  /
     */
    List<PmsBrand> findBrandByCategoryId(@Param("categoryId") Long categoryId, @Param("page") int page, @Param("size") int size);
    int findBrandByCategoryIdCount(@Param("categoryId") Long categoryId);
}
