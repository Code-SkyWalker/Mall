package com.skywalker.pms.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @Author Code SkyWalker
 * @Classname PmsSkuInfo
 * @Description TODO
 */
@Table(name="pms_sku_info")
@Data
public class PmsSkuInfo implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku_id")
	private Long skuId;//skuId

    @Column(name = "spu_id")
	private Long spuId;//spuId

    @Column(name = "sku_name")
	private String skuName;//sku名称

    @Column(name = "sku_desc")
	private String skuDesc;//sku介绍描述

    @Column(name = "catalog_id")
	private Long catalogId;//所属分类id

    @Column(name = "brand_id")
	private Long brandId;//品牌id

    @Column(name = "sku_default_img")
	private String skuDefaultImg;//默认图片

    @Column(name = "sku_title")
	private String skuTitle;//标题

    @Column(name = "sku_subtitle")
	private String skuSubtitle;//副标题

    @Column(name = "price")
	private BigDecimal price;//价格

    @Column(name = "sale_count")
	private Long saleCount;//销量



}
