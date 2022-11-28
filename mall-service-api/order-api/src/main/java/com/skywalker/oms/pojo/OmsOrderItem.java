package com.skywalker.oms.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderItem
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oms_order_item")
public class OmsOrderItem implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "order_id")
	private Long orderId;//order_id

    @Column(name = "order_sn")
	private String orderSn;//order_sn

    @Column(name = "spu_id")
	private Long spuId;//spu_id

    @Column(name = "spu_name")
	private String spuName;//spu_name

    @Column(name = "spu_pic")
	private String spuPic;//spu_pic

    @Column(name = "spu_brand")
	private String spuBrand;//品牌

    @Column(name = "category_id")
	private Long categoryId;//商品分类id

    @Column(name = "sku_id")
	private Long skuId;//商品sku编号

    @Column(name = "sku_name")
	private String skuName;//商品sku名字

    @Column(name = "sku_pic")
	private String skuPic;//商品sku图片

    @Column(name = "sku_price")
	private String skuPrice;//商品sku价格

    @Column(name = "sku_quantity")
	private Integer skuQuantity;//商品购买的数量

    @Column(name = "sku_attrs_vals")
	private String skuAttrsVals;//商品销售属性组合（JSON）

    @Column(name = "promotion_amount")
	private String promotionAmount;//商品促销分解金额

    @Column(name = "coupon_amount")
	private String couponAmount;//优惠券优惠分解金额

    @Column(name = "integration_amount")
	private String integrationAmount;//积分优惠分解金额

    @Column(name = "real_amount")
	private String realAmount;//该商品经过优惠后的分解金额

    @Column(name = "gift_integration")
	private Integer giftIntegration;//赠送积分

    @Column(name = "gift_growth")
	private Integer giftGrowth;//赠送成长值



}
