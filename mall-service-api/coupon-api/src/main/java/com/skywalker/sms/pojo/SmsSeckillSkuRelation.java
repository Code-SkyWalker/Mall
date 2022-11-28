package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuRelation
 * @Description TODO
 */
@Table(name="sms_seckill_sku_relation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsSeckillSkuRelation implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "promotion_id")
	private Long promotionId;//活动id

    @Column(name = "promotion_session_id")
	private Long promotionSessionId;//活动场次id

    @Column(name = "sku_id")
	private Long skuId;//商品id

    @Column(name = "seckill_price")
	private String seckillPrice;//秒杀价格

    @Column(name = "seckill_count")
	private String seckillCount;//秒杀总量

    @Column(name = "seckill_limit")
	private String seckillLimit;//每人限购数量

    @Column(name = "seckill_sort")
	private Integer seckillSort;//排序



}
