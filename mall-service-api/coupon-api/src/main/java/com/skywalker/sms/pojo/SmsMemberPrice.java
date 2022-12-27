package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @Author Code SkyWalker
 * @Classname SmsMemberPrice
 * @Description TODO
 */
@Table(name="sms_member_price")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsMemberPrice implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "sku_id")
	private Long skuId;//sku_id

    @Column(name = "member_level_id")
	private Long memberLevelId;//会员等级id

    @Column(name = "member_level_name")
	private String memberLevelName;//会员等级名

    @Column(name = "member_price")
	private BigDecimal memberPrice;//会员对应价格

    @Column(name = "add_other")
	private Integer addOther;//可否叠加其他优惠[0-不可叠加优惠，1-可叠加]



}
