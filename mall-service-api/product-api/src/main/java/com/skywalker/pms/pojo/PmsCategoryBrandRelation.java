package com.skywalker.pms.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryBrandRelation
 * @Description TODO
 */
@Table(name="pms_category_brand_relation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PmsCategoryBrandRelation implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//

    @Column(name = "brand_id")
	private Long brandId;//品牌id

    @Column(name = "catelog_id")
	private Long catelogId;//分类id

    @Column(name = "brand_name")
	private String brandName;//

    @Column(name = "catelog_name")
	private String catelogName;//



}
