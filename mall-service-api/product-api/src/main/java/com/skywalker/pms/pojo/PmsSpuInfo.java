package com.skywalker.pms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfo
 * @Description TODO
 */
@Table(name="pms_spu_info")
@Data
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
	private BigDecimal weight;//

    @Column(name = "publish_status")
	private Integer publishStatus;//上架状态[0 - 下架，1 - 上架]

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime = LocalDateTime.now();//

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime = LocalDateTime.now();//

}
