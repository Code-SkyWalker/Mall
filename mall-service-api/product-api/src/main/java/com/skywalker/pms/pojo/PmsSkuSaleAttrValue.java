package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsSkuSaleAttrValue
 * @Description TODO
 */
@Table(name="pms_sku_sale_attr_value")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsSkuSaleAttrValue implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "sku_id")
	private Long skuId;//sku_id

    @Column(name = "attr_id")
	private Long attrId;//attr_id

    @Column(name = "attr_name")
	private String attrName;//销售属性名

    @Column(name = "attr_value")
	private String attrValue;//销售属性值

    @Column(name = "attr_sort")
	private Integer attrSort;//顺序



}
