package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsAttr
 * @Description TODO
 */
@Table(name="pms_attr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsAttr implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attr_id")
	private Long attrId;//属性id

    @Column(name = "attr_name")
	private String attrName;//属性名

    @Column(name = "search_type")
	private Integer searchType;//是否需要检索[0-不需要，1-需要]

    @Column(name = "value_type")
    private Integer valueType;

    @Column(name = "icon")
	private String icon;//属性图标

    @Column(name = "value_select")
	private String valueSelect;//可选值列表[用逗号分隔]

    @Column(name = "attr_type")
	private Integer attrType;//属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]

    @Column(name = "enable")
	private Long enable;//启用状态[0 - 禁用，1 - 启用]

    @Column(name = "catelog_id")
	private Long catelogId;//所属分类

    @Column(name = "show_desc")
	private Integer showDesc;//快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整

}
