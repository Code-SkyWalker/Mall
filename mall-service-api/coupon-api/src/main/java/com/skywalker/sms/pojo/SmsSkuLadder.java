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
 * @Classname SmsSkuLadder
 * @Description TODO
 */
@Table(name="sms_sku_ladder")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsSkuLadder implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "sku_id")
	private Long skuId;//spu_id

    @Column(name = "full_count")
	private Integer fullCount;//满几件

    @Column(name = "discount")
	private BigDecimal discount;//打几折

    @Column(name = "price")
	private BigDecimal price;//折后价

    @Column(name = "add_other")
	private Integer addOther;//是否叠加其他优惠[0-不可叠加，1-可叠加]



}
