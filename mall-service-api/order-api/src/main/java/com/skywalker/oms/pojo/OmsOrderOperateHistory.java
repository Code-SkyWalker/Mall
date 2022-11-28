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
 * @Classname OmsOrderOperateHistory
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oms_order_operate_history")
public class OmsOrderOperateHistory implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "order_id")
	private Long orderId;//订单id

    @Column(name = "operate_man")
	private String operateMan;//操作人[用户；系统；后台管理员]

    @Column(name = "create_time")
	private LocalDate createTime;//操作时间

    @Column(name = "order_status")
	private Integer orderStatus;//订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】

    @Column(name = "note")
	private String note;//备注



}
