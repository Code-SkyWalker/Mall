package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsAttrAttrgroupRelation
 * @Description TODO
 */
@Table(name="pms_attr_attrgroup_relation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsAttrAttrgroupRelation implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "attr_id")
	private Long attrId;//属性id

    @Column(name = "attr_group_id")
	private Long attrGroupId;//属性分组id

    @Column(name = "attr_sort")
	private Integer attrSort;//属性组内排序



}
