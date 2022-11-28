package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsAttrGroup
 * @Description TODO
 */
@Table(name="pms_attr_group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsAttrGroup implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attr_group_id")
	private Long attrGroupId;//分组id

    @Column(name = "attr_group_name")
	private String attrGroupName;//组名

    @Column(name = "sort")
	private Integer sort;//排序

    @Column(name = "descript")
	private String descript;//描述

    @Column(name = "icon")
	private String icon;//组图标

    @Column(name = "catelog_id")
	private Long catelogId;//所属分类id



}
