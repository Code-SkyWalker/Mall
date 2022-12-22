package com.skywalker.pms.dao;

import com.skywalker.pms.pojo.PmsBrand;
import com.skywalker.pms.pojo.PmsCategoryBrandRelation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryBrandRelationMapper
 * @Description TODO
 */
public interface PmsCategoryBrandRelationMapper extends Mapper<PmsCategoryBrandRelation> {
    /**
     * 根据 分类ID 查询品牌列表
     * @param catId 分类ID
     * @return 品牌list
     */
    List<PmsBrand> findBrandsByCategoryId(@Param("catId") Long catId);
}
