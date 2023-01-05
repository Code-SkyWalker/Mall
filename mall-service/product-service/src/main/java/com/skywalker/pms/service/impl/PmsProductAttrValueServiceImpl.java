package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsProductAttrValueMapper;
import com.skywalker.pms.pojo.PmsProductAttrValue;
import com.skywalker.pms.pojo.PmsSkuSaleAttrValue;
import com.skywalker.pms.service.PmsProductAttrValueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
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
        Example example = new Example(PmsProductAttrValue.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("spuId", spuId);
        return pmsProductAttrValueMapper.selectByExample(example);
    }

    /**
     * 增加PmsProductAttrValue
     * @param pmsProductAttrValue
     */
    @Override
    public void add(PmsProductAttrValue pmsProductAttrValue){
        pmsProductAttrValueMapper.insert(pmsProductAttrValue);
    }

    /**
     * 批量更新
     *
     * @param list  list
     * @param spuId spuId
     */
    @Override
    public void update(List<PmsProductAttrValue> list, Long spuId) {
        if (!list.isEmpty()) {
            Example example = new Example(PmsProductAttrValue.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("spuId", spuId);

            list.forEach(ele -> {
                criteria.andEqualTo("attrId", ele.getAttrId());
                this.pmsProductAttrValueMapper.updateByExampleSelective(ele, example);
            });
        }
    }
}
