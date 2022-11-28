package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsProductAttrValue
 * @Description TODO
 */
@Table(name="pms_product_attr_value")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsProductAttrValue implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "spu_id")
	private Long spuId;//商品id

    @Column(name = "attr_id")
	private Long attrId;//属性id

    @Column(name = "attr_name")
	private String attrName;//属性名

    @Column(name = "attr_value")
	private String attrValue;//属性值

    @Column(name = "attr_sort")
	private Integer attrSort;//顺序

    @Column(name = "quick_show")
	private Integer quickShow;//快速展示【是否展示在介绍上；0-否 1-是】



}
