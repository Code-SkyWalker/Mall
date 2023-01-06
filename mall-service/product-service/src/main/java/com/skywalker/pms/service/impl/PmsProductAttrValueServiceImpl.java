package com.skywalker.pms.service.impl;

import com.skywalker.pms.dao.PmsProductAttrValueMapper;
import com.skywalker.pms.pojo.PmsProductAttrValue;
import com.skywalker.pms.service.PmsProductAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Code SkyWalker
 * @Classname PmsProductAttrValueServiceImpl
 * @Description TODO
 */
@Service
public class PmsProductAttrValueServiceImpl implements PmsProductAttrValueService {

    @Autowired
    private PmsProductAttrValueMapper pmsProductAttrValueMapper;

    /**
     * 根据attr查询 spu 产品的基本属性
     *
     * @param spuId
     * @return
     */
    @Override
    public List<PmsProductAttrValue> findBaseAttrBySpuId(Long spuId) {
        if (spuId == null) return null;
        Example example = new Example(PmsProductAttrValue.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("spuId", spuId);
        return pmsProductAttrValueMapper.selectByExample(example);
    }

    /**
     * 增加PmsProductAttrValue
     *
     * @param pmsProductAttrValue
     */
    @Override
    public void add(PmsProductAttrValue pmsProductAttrValue) {
        pmsProductAttrValueMapper.insertSelective(pmsProductAttrValue);
    }

    /**
     * 根据spuId 删除
     *
     * @param spuId
     */
    @Override
    public void delete(Long spuId) {
        if (spuId == null) return;
        Example example = new Example(PmsProductAttrValue.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("spuId", spuId);

        this.pmsProductAttrValueMapper.deleteByExample(example);
    }

    /**
     * 批量更新
     *
     * @param list  list
     * @param spuId spuId
     */
    @Override
    @Transactional
    public void update(List<PmsProductAttrValue> list, Long spuId) {
        if (list.isEmpty()) return;

        this.delete(spuId);

        list.stream()
            .peek(ele -> ele.setSpuId(spuId))
            .forEach(this::add);

    }
}
