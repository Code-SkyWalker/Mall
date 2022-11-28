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
 * @Classname SmsCouponHistory
 * @Description TODO
 */
@Table(name="sms_coupon_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsCouponHistory implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "coupon_id")
	private Long couponId;//优惠券id

    @Column(name = "member_id")
	private Long memberId;//会员id

    @Column(name = "member_nick_name")
	private String memberNickName;//会员名字

    @Column(name = "get_type")
	private String getType;//获取方式[0->后台赠送；1->主动领取]

    @Column(name = "create_time")
	private LocalDate createTime;//创建时间

    @Column(name = "use_type")
	private String useType;//使用状态[0->未使用；1->已使用；2->已过期]

    @Column(name = "use_time")
	private LocalDate useTime;//使用时间

    @Column(name = "order_id")
	private Long orderId;//订单id

    @Column(name = "order_sn")
	private Long orderSn;//订单号



}
