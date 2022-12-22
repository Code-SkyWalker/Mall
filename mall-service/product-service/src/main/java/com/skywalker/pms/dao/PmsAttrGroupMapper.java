package com.skywalker.pms.dao;

import com.skywalker.pms.pojo.PmsAttrGroup;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrGroupMapper.xml
 * @Description TODO
 */
public interface PmsAttrGroupMapper extends Mapper<PmsAttrGroup> {

    List<PmsAttrGroup> findAttrGroupByCategoryId(@Param("catId") Long catId, @Param("page") int page, @Param("size") int size);

    int findBrandByCategoryIdCount(@Param("catId") Long catId);
}
