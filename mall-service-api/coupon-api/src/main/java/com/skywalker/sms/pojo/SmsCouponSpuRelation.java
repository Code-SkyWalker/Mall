package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuRelation
 * @Description TODO
 */
@Table(name="sms_coupon_spu_relation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsCouponSpuRelation implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "coupon_id")
	private Long couponId;//优惠券id

    @Column(name = "spu_id")
	private Long spuId;//spu_id

    @Column(name = "spu_name")
	private String spuName;//spu_name



}
