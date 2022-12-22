package com.skywalker.pms.dao;

import com.skywalker.pms.pojo.PmsAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrMapper
 * @Description TODO
 */
public interface PmsAttrMapper extends Mapper<PmsAttr> {
    List<PmsAttr> findAttrByCategoryId(@Param("attrType") String attrType,
                                       @Param("categoryId") Long categoryId,
                                       @Param("page") int page,
                                       @Param("size") int size);

    int findAttrByCategoryIdCount(@Param("attrType") String attrType, @Param("categoryId") Long categoryId);

    List<PmsAttr> findAttrByAttrGroupId(@Param("attrGroupId") Long attrGroupId);
}
