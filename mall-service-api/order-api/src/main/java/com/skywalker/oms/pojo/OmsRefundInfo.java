package com.skywalker.oms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @Author Code SkyWalker
 * @Classname OmsRefundInfo
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oms_refund_info")
public class OmsRefundInfo implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "order_return_id")
	private Long orderReturnId;//退款的订单

    @Column(name = "refund")
	private String refund;//退款金额

    @Column(name = "refund_sn")
	private String refundSn;//退款交易流水号

    @Column(name = "refund_status")
	private String refundStatus;//退款状态

    @Column(name = "refund_channel")
	private Integer refundChannel;//退款渠道[1-支付宝，2-微信，3-银联，4-汇款]

    @Column(name = "refund_content")
	private String refundContent;//



}
