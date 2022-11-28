package com.skywalker.oms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnApply
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oms_order_return_apply")
public class OmsOrderReturnApply implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "order_id")
	private Long orderId;//order_id

    @Column(name = "sku_id")
	private Long skuId;//退货商品id

    @Column(name = "order_sn")
	private String orderSn;//订单编号

    @Column(name = "create_time")
	private LocalDate createTime;//申请时间

    @Column(name = "member_username")
	private String memberUsername;//会员用户名

    @Column(name = "return_amount")
	private String returnAmount;//退款金额

    @Column(name = "return_name")
	private String returnName;//退货人姓名

    @Column(name = "return_phone")
	private String returnPhone;//退货人电话

    @Column(name = "status")
	private String status;//申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]

    @Column(name = "handle_time")
	private LocalDate handleTime;//处理时间

    @Column(name = "sku_img")
	private String skuImg;//商品图片

    @Column(name = "sku_name")
	private String skuName;//商品名称

    @Column(name = "sku_brand")
	private String skuBrand;//商品品牌

    @Column(name = "sku_attrs_vals")
	private String skuAttrsVals;//商品销售属性(JSON)

    @Column(name = "sku_count")
	private Integer skuCount;//退货数量

    @Column(name = "sku_price")
	private String skuPrice;//商品单价

    @Column(name = "sku_real_price")
	private String skuRealPrice;//商品实际支付单价

    @Column(name = "reason")
	private String reason;//原因

    @Column(name = "description述")
	private String description述;//描述

    @Column(name = "desc_pics")
	private String descPics;//凭证图片，以逗号隔开

    @Column(name = "handle_note")
	private String handleNote;//处理备注

    @Column(name = "handle_man")
	private String handleMan;//处理人员

    @Column(name = "receive_man")
	private String receiveMan;//收货人

    @Column(name = "receive_time")
	private LocalDate receiveTime;//收货时间

    @Column(name = "receive_note")
	private String receiveNote;//收货备注

    @Column(name = "receive_phone")
	private String receivePhone;//收货电话

    @Column(name = "company_address")
	private String companyAddress;//公司收货地址



}
