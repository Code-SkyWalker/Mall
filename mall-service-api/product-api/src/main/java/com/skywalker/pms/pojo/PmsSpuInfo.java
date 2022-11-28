package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfo
 * @Description TODO
 */
@Table(name="pms_spu_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsSpuInfo implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//商品id

    @Column(name = "spu_name")
	private String spuName;//商品名称

    @Column(name = "spu_description")
	private String spuDescription;//商品描述

    @Column(name = "catalog_id")
	private Long catalogId;//所属分类id

    @Column(name = "brand_id")
	private Long brandId;//品牌id

    @Column(name = "weight")
	private String weight;//

    @Column(name = "publish_status")
	private Integer publishStatus;//上架状态[0 - 下架，1 - 上架]

    @Column(name = "create_time")
	private LocalDate createTime;//

    @Column(name = "update_time")
	private LocalDate updateTime;//



}
