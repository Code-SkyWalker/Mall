package com.skywalker.pms.dao;

import com.skywalker.pms.pojo.PmsAttr;
import com.skywalker.pms.pojo.PmsAttrAttrgroupRelation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsAttrAttrgroupRelationMapper
 * @Description TODO
 */
public interface PmsAttrAttrgroupRelationMapper extends Mapper<PmsAttrAttrgroupRelation> {
    List<PmsAttr> getRelatedAttr(@Param("attrGroupId") Long attrGroupId, @Param("attrName") String attrName, @Param("page") int page, @Param("size") int size);

    int relatedAttrCount(@Param("attrGroupId") Long attrGroupId);

    void insertAsList(@Param("attrGroupId") Long attrGroupId, @Param("attrIds") List<Long> attrIds);
}
