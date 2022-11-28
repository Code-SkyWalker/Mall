package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname SmsCouponSpuCategoryRelation
 * @Description TODO
 */
@Table(name="sms_coupon_spu_category_relation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsCouponSpuCategoryRelation implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "coupon_id")
	private Long couponId;//优惠券id

    @Column(name = "category_id")
	private Long categoryId;//产品分类id

    @Column(name = "category_name")
	private String categoryName;//产品分类名称



}
