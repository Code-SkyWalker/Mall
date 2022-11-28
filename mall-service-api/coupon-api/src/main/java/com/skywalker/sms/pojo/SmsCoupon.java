package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @Author Code SkyWalker
 * @Classname SmsCoupon
 * @Description TODO
 */
@Table(name="sms_coupon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsCoupon implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "coupon_type")
	private String couponType;//优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]

    @Column(name = "coupon_img")
	private String couponImg;//优惠券图片

    @Column(name = "coupon_name")
	private String couponName;//优惠卷名字

    @Column(name = "num")
	private Integer num;//数量

    @Column(name = "amount")
	private String amount;//金额

    @Column(name = "per_limit")
	private Integer perLimit;//每人限领张数

    @Column(name = "min_point")
	private String minPoint;//使用门槛

    @Column(name = "start_time")
	private LocalDate startTime;//开始时间

    @Column(name = "end_time")
	private LocalDate endTime;//结束时间

    @Column(name = "use_type")
	private String useType;//使用类型[0->全场通用；1->指定分类；2->指定商品]

    @Column(name = "note")
	private String note;//备注

    @Column(name = "publish_count")
	private Integer publishCount;//发行数量

    @Column(name = "use_count")
	private Integer useCount;//已使用数量

    @Column(name = "receive_count")
	private Integer receiveCount;//领取数量

    @Column(name = "enable_start_time")
	private LocalDate enableStartTime;//可以领取的开始日期

    @Column(name = "enable_end_time")
	private LocalDate enableEndTime;//可以领取的结束日期

    @Column(name = "code")
	private String code;//优惠码

    @Column(name = "member_level")
	private String memberLevel;//可以领取的会员等级[0->不限等级，其他-对应等级]

    @Column(name = "publish")
	private String publish;//发布状态[0-未发布，1-已发布]



}
