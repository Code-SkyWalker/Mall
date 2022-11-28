package com.skywalker.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTask
 * @Description TODO
 */
@Table(name="wms_ware_order_task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WmsWareOrderTask implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id; // id

    @Column(name = "order_id")
	private Long orderId; // order_id

    @Column(name = "order_sn")
	private String orderSn; // order_sn

    @Column(name = "consignee")
	private String consignee; // 收货人

    @Column(name = "consignee_tel")
	private String consigneeTel; // 收货人电话

    @Column(name = "delivery_address")
	private String deliveryAddress; // 配送地址

    @Column(name = "order_comment")
	private String orderComment; // 订单备注

    @Column(name = "payment_way")
	private String paymentWay; // 付款方式【 1:在线付款 2:货到付款】

    @Column(name = "task_status")
	private Integer taskStatus; // 任务状态

    @Column(name = "order_body")
	private String orderBody; // 订单描述

    @Column(name = "tracking_no")
	private String trackingNo; // 物流单号

    @Column(name = "create_time")
	private LocalDate createTime; // create_time

    @Column(name = "ware_id")
	private Long wareId; // 仓库id

    @Column(name = "task_comment")
	private String taskComment; // 工作单备注



}
