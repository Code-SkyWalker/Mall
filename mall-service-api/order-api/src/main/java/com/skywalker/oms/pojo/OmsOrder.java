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
 * @Classname OmsOrder
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oms_order")
public class OmsOrder implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "member_id")
	private Long memberId;//member_id

    @Column(name = "order_sn")
	private String orderSn;//订单号

    @Column(name = "coupon_id")
	private Long couponId;//使用的优惠券

    @Column(name = "create_time")
	private LocalDate createTime;//create_time

    @Column(name = "member_username")
	private String memberUsername;//用户名

    @Column(name = "total_amount")
	private String totalAmount;//订单总额

    @Column(name = "pay_amount")
	private String payAmount;//应付总额

    @Column(name = "freight_amount")
	private String freightAmount;//运费金额

    @Column(name = "promotion_amount")
	private String promotionAmount;//促销优化金额（促销价、满减、阶梯价）

    @Column(name = "integration_amount")
	private String integrationAmount;//积分抵扣金额

    @Column(name = "coupon_amount")
	private String couponAmount;//优惠券抵扣金额

    @Column(name = "discount_amount")
	private String discountAmount;//后台调整订单使用的折扣金额

    @Column(name = "pay_type")
	private Integer payType;//支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】

    @Column(name = "source_type")
	private Integer sourceType;//订单来源[0->PC订单；1->app订单]

    @Column(name = "status")
	private Integer status;//订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】

    @Column(name = "delivery_company")
	private String deliveryCompany;//物流公司(配送方式)

    @Column(name = "delivery_sn")
	private String deliverySn;//物流单号

    @Column(name = "auto_confirm_day")
	private Integer autoConfirmDay;//自动确认时间（天）

    @Column(name = "integration")
	private Integer integration;//可以获得的积分

    @Column(name = "growth")
	private Integer growth;//可以获得的成长值

    @Column(name = "bill_type")
	private Integer billType;//发票类型[0->不开发票；1->电子发票；2->纸质发票]

    @Column(name = "bill_header")
	private String billHeader;//发票抬头

    @Column(name = "bill_content")
	private String billContent;//发票内容

    @Column(name = "bill_receiver_phone")
	private String billReceiverPhone;//收票人电话

    @Column(name = "bill_receiver_email")
	private String billReceiverEmail;//收票人邮箱

    @Column(name = "receiver_name")
	private String receiverName;//收货人姓名

    @Column(name = "receiver_phone")
	private String receiverPhone;//收货人电话

    @Column(name = "receiver_post_code")
	private String receiverPostCode;//收货人邮编

    @Column(name = "receiver_province")
	private String receiverProvince;//省份/直辖市

    @Column(name = "receiver_city")
	private String receiverCity;//城市

    @Column(name = "receiver_region")
	private String receiverRegion;//区

    @Column(name = "receiver_detail_address")
	private String receiverDetailAddress;//详细地址

    @Column(name = "note")
	private String note;//订单备注

    @Column(name = "confirm_status")
	private Integer confirmStatus;//确认收货状态[0->未确认；1->已确认]

    @Column(name = "delete_status")
	private Integer deleteStatus;//删除状态【0->未删除；1->已删除】

    @Column(name = "use_integration")
	private Integer useIntegration;//下单时使用的积分

    @Column(name = "payment_time")
	private LocalDate paymentTime;//支付时间

    @Column(name = "delivery_time")
	private LocalDate deliveryTime;//发货时间

    @Column(name = "receive_time")
	private LocalDate receiveTime;//确认收货时间

    @Column(name = "comment_time")
	private LocalDate commentTime;//评价时间

    @Column(name = "modify_time")
	private LocalDate modifyTime;//修改时间



}
