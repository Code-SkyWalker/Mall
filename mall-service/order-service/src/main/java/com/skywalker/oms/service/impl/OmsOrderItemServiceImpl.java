package com.skywalker.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.oms.dao.OmsOrderItemMapper;
import com.skywalker.oms.pojo.OmsOrderItem;
import com.skywalker.oms.service.OmsOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderItemServiceImpl
 * @Description TODO
 */
@Service
public class OmsOrderItemServiceImpl implements OmsOrderItemService {

    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;


    /**
     * OmsOrderItem条件+分页查询
     * @param omsOrderItem 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OmsOrderItem> findPage(OmsOrderItem omsOrderItem, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(omsOrderItem);
        //执行搜索
        return new PageInfo<OmsOrderItem>(omsOrderItemMapper.selectByExample(example));
    }

    /**
     * OmsOrderItem分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OmsOrderItem> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OmsOrderItem>(omsOrderItemMapper.selectAll());
    }

    /**
     * OmsOrderItem条件查询
     * @param omsOrderItem
     * @return
     */
    @Override
    public List<OmsOrderItem> findList(OmsOrderItem omsOrderItem){
        //构建查询条件
        Example example = createExample(omsOrderItem);
        //根据构建的条件查询数据
        return omsOrderItemMapper.selectByExample(example);
    }


    /**
     * OmsOrderItem构建查询对象
     * @param omsOrderItem
     * @return
     */
    public Example createExample(OmsOrderItem omsOrderItem){
        Example example=new Example(OmsOrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        if(omsOrderItem!=null){
            // id
            if(!StringUtils.isEmpty(omsOrderItem.getId())){
                    criteria.andEqualTo("id",omsOrderItem.getId());
            }
            // order_id
            if(!StringUtils.isEmpty(omsOrderItem.getOrderId())){
                    criteria.andEqualTo("orderId",omsOrderItem.getOrderId());
            }
            // order_sn
            if(!StringUtils.isEmpty(omsOrderItem.getOrderSn())){
                    criteria.andEqualTo("orderSn",omsOrderItem.getOrderSn());
            }
            // spu_id
            if(!StringUtils.isEmpty(omsOrderItem.getSpuId())){
                    criteria.andEqualTo("spuId",omsOrderItem.getSpuId());
            }
            // spu_name
            if(!StringUtils.isEmpty(omsOrderItem.getSpuName())){
                    criteria.andEqualTo("spuName",omsOrderItem.getSpuName());
            }
            // spu_pic
            if(!StringUtils.isEmpty(omsOrderItem.getSpuPic())){
                    criteria.andEqualTo("spuPic",omsOrderItem.getSpuPic());
            }
            // 品牌
            if(!StringUtils.isEmpty(omsOrderItem.getSpuBrand())){
                    criteria.andEqualTo("spuBrand",omsOrderItem.getSpuBrand());
            }
            // 商品分类id
            if(!StringUtils.isEmpty(omsOrderItem.getCategoryId())){
                    criteria.andEqualTo("categoryId",omsOrderItem.getCategoryId());
            }
            // 商品sku编号
            if(!StringUtils.isEmpty(omsOrderItem.getSkuId())){
                    criteria.andEqualTo("skuId",omsOrderItem.getSkuId());
            }
            // 商品sku名字
            if(!StringUtils.isEmpty(omsOrderItem.getSkuName())){
                    criteria.andEqualTo("skuName",omsOrderItem.getSkuName());
            }
            // 商品sku图片
            if(!StringUtils.isEmpty(omsOrderItem.getSkuPic())){
                    criteria.andEqualTo("skuPic",omsOrderItem.getSkuPic());
            }
            // 商品sku价格
            if(!StringUtils.isEmpty(omsOrderItem.getSkuPrice())){
                    criteria.andEqualTo("skuPrice",omsOrderItem.getSkuPrice());
            }
            // 商品购买的数量
            if(!StringUtils.isEmpty(omsOrderItem.getSkuQuantity())){
                    criteria.andEqualTo("skuQuantity",omsOrderItem.getSkuQuantity());
            }
            // 商品销售属性组合（JSON）
            if(!StringUtils.isEmpty(omsOrderItem.getSkuAttrsVals())){
                    criteria.andEqualTo("skuAttrsVals",omsOrderItem.getSkuAttrsVals());
            }
            // 商品促销分解金额
            if(!StringUtils.isEmpty(omsOrderItem.getPromotionAmount())){
                    criteria.andEqualTo("promotionAmount",omsOrderItem.getPromotionAmount());
            }
            // 优惠券优惠分解金额
            if(!StringUtils.isEmpty(omsOrderItem.getCouponAmount())){
                    criteria.andEqualTo("couponAmount",omsOrderItem.getCouponAmount());
            }
            // 积分优惠分解金额
            if(!StringUtils.isEmpty(omsOrderItem.getIntegrationAmount())){
                    criteria.andEqualTo("integrationAmount",omsOrderItem.getIntegrationAmount());
            }
            // 该商品经过优惠后的分解金额
            if(!StringUtils.isEmpty(omsOrderItem.getRealAmount())){
                    criteria.andEqualTo("realAmount",omsOrderItem.getRealAmount());
            }
            // 赠送积分
            if(!StringUtils.isEmpty(omsOrderItem.getGiftIntegration())){
                    criteria.andEqualTo("giftIntegration",omsOrderItem.getGiftIntegration());
            }
            // 赠送成长值
            if(!StringUtils.isEmpty(omsOrderItem.getGiftGrowth())){
                    criteria.andEqualTo("giftGrowth",omsOrderItem.getGiftGrowth());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        omsOrderItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OmsOrderItem
     * @param omsOrderItem
     */
    @Override
    public void update(OmsOrderItem omsOrderItem){
        omsOrderItemMapper.updateByPrimaryKey(omsOrderItem);
    }

    /**
     * 增加OmsOrderItem
     * @param omsOrderItem
     */
    @Override
    public void add(OmsOrderItem omsOrderItem){
        omsOrderItemMapper.insert(omsOrderItem);
    }

    /**
     * 根据ID查询OmsOrderItem
     * @param id
     * @return
     */
    @Override
    public OmsOrderItem findById(Long id){
        return  omsOrderItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OmsOrderItem全部数据
     * @return
     */
    @Override
    public List<OmsOrderItem> findAll() {
        return omsOrderItemMapper.selectAll();
    }
}
