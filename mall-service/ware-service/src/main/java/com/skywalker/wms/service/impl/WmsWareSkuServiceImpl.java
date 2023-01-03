package com.skywalker.wms.service.impl;

import com.skywalker.entity.Result;
import com.skywalker.pms.feign.PmsSkuInfoFeign;
import com.skywalker.pms.pojo.PmsSkuInfo;
import com.skywalker.wms.dao.WmsWareSkuMapper;
import com.skywalker.wms.pojo.WmsWareSku;
import com.skywalker.wms.service.WmsWareSkuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareSkuServiceImpl
 * @Description TODO
 */
@Service
public class WmsWareSkuServiceImpl implements WmsWareSkuService {

    @Autowired
    private WmsWareSkuMapper wmsWareSkuMapper;

    @Autowired
    private PmsSkuInfoFeign pmsSkuInfoFeign;


    /**
     * WmsWareSku条件+分页查询
     *
     * @param wmsWareSku 查询条件
     * @param page       页码
     * @param size       页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WmsWareSku> findPage(WmsWareSku wmsWareSku, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(wmsWareSku);
        //执行搜索
        return new PageInfo<>(wmsWareSkuMapper.selectByExample(example));
    }

    /**
     * WmsWareSku分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WmsWareSku> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<WmsWareSku>(wmsWareSkuMapper.selectAll());
    }

    /**
     * WmsWareSku条件查询
     *
     * @param wmsWareSku
     * @return
     */
    @Override
    public List<WmsWareSku> findList(WmsWareSku wmsWareSku) {
        //构建查询条件
        Example example = createExample(wmsWareSku);
        //根据构建的条件查询数据
        return wmsWareSkuMapper.selectByExample(example);
    }


    /**
     * WmsWareSku构建查询对象
     *
     * @param wmsWareSku
     * @return
     */
    public Example createExample(WmsWareSku wmsWareSku) {
        Example example = new Example(WmsWareSku.class);
        Example.Criteria criteria = example.createCriteria();
        if (wmsWareSku != null) {
            // id
            if (!StringUtils.isEmpty(wmsWareSku.getId())) {
                criteria.andEqualTo("id", wmsWareSku.getId());
            }
            // sku_id
            if (!StringUtils.isEmpty(wmsWareSku.getSkuId())) {
                criteria.andEqualTo("skuId", wmsWareSku.getSkuId());
            }
            // 仓库id
            if (!StringUtils.isEmpty(wmsWareSku.getWareId())) {
                criteria.andEqualTo("wareId", wmsWareSku.getWareId());
            }
            // 库存数
            if (!StringUtils.isEmpty(wmsWareSku.getStock())) {
                criteria.andEqualTo("stock", wmsWareSku.getStock());
            }
            // sku_name
            if (!StringUtils.isEmpty(wmsWareSku.getSkuName())) {
                criteria.andEqualTo("skuName", wmsWareSku.getSkuName());
            }
            // 锁定库存
            if (!StringUtils.isEmpty(wmsWareSku.getStockLocked())) {
                criteria.andEqualTo("stockLocked", wmsWareSku.getStockLocked());
            }
        }
        return example;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        wmsWareSkuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WmsWareSku
     *
     * @param wmsWareSku
     */
    @Override
    public void update(WmsWareSku wmsWareSku) {
        wmsWareSkuMapper.updateByPrimaryKeySelective(wmsWareSku);
    }

    /**
     * 增加WmsWareSku
     *
     * @param wmsWareSku
     */
    @Override
    public void add(WmsWareSku wmsWareSku) {
        wmsWareSkuMapper.insertSelective(wmsWareSku);
    }

    /**
     * 根据ID查询WmsWareSku
     *
     * @param id
     * @return
     */
    @Override
    public WmsWareSku findById(Long id) {
        return wmsWareSkuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WmsWareSku全部数据
     *
     * @return
     */
    @Override
    public List<WmsWareSku> findAll() {
        return wmsWareSkuMapper.selectAll();
    }

    /**
     * sku库存添加库存数量
     *
     * @param wareId 仓库Id
     * @param skuId  skuId
     * @param stock  增加的库存数量
     */
    @Override
    public void addStock(Long wareId, Long skuId, Integer stock) {
        // ware_sku 查询是否存在: 存在库存相加; 不存在: 添加
        WmsWareSku wmsWareSkus = this.findBySkuIdAndWareId(wareId, skuId);
        // 查询skuName
        PmsSkuInfo pmsSkuInfo = (PmsSkuInfo) this.pmsSkuInfoFeign.findById(skuId).get("data");

        if (wmsWareSkus == null) { // 不存在
            WmsWareSku wmsWareSku = WmsWareSku.builder()
                    .skuId(skuId).wareId(wareId).stock(stock)
                    .skuName(pmsSkuInfo.getSkuName())
                    .build();
            this.add(wmsWareSku);
        } else { // 存在
            WmsWareSku wmsWareSku = WmsWareSku.builder()
                    .skuId(skuId).wareId(wareId).stock(wmsWareSkus.getStock() + stock)
                    .skuName(pmsSkuInfo.getSkuName())
                    .build();
            this.update(wmsWareSku);
        }
    }

    /**
     * sku 查询 ware_sku 是否存在sku
     *
     * @param wareId wareId
     * @param skuId  skuId
     * @return /
     */
    @Override
    public WmsWareSku findBySkuIdAndWareId(Long wareId, Long skuId) {
        Example example = new Example(WmsWareSku.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wareId", wareId);
        criteria.andEqualTo("skuId", skuId);
        return this.wmsWareSkuMapper.selectOneByExample(example);
    }
}
