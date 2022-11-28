package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname SmsSkuFullReduction
 * @Description TODO
 */
@Table(name="sms_sku_full_reduction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsSkuFullReduction implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "sku_id")
	private Long skuId;//spu_id

    @Column(name = "full_price")
	private String fullPrice;//满多少

    @Column(name = "reduce_price")
	private String reducePrice;//减多少

    @Column(name = "add_other")
	private String addOther;//是否参与其他优惠



}
