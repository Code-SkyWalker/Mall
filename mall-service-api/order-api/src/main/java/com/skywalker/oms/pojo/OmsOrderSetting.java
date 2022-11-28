package com.skywalker.oms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderSetting
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oms_order_setting")
public class OmsOrderSetting implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "flash_order_overtime")
	private Integer flashOrderOvertime;//秒杀订单超时关闭时间(分)

    @Column(name = "normal_order_overtime")
	private Integer normalOrderOvertime;//正常订单超时时间(分)

    @Column(name = "confirm_overtime")
	private Integer confirmOvertime;//发货后自动确认收货时间（天）

    @Column(name = "finish_overtime")
	private Integer finishOvertime;//自动完成交易时间，不能申请退货（天）

    @Column(name = "comment_overtime")
	private Integer commentOvertime;//订单完成后自动好评时间（天）

    @Column(name = "member_level")
	private Integer memberLevel;//会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】



}
