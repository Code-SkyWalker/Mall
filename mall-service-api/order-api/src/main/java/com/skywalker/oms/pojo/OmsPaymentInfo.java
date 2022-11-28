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
 * @Classname OmsPaymentInfo
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oms_payment_info")
public class OmsPaymentInfo implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "order_sn")
	private String orderSn;//订单号（对外业务号）

    @Column(name = "order_id")
	private Long orderId;//订单id

    @Column(name = "alipay_trade_no")
	private String alipayTradeNo;//支付宝交易流水号

    @Column(name = "total_amount")
	private String totalAmount;//支付总金额

    @Column(name = "subject")
	private String subject;//交易内容

    @Column(name = "payment_status")
	private String paymentStatus;//支付状态

    @Column(name = "create_time")
	private LocalDate createTime;//创建时间

    @Column(name = "confirm_time")
	private LocalDate confirmTime;//确认时间

    @Column(name = "callback_content")
	private String callbackContent;//回调内容

    @Column(name = "callback_time")
	private LocalDate callbackTime;//回调时间

}
