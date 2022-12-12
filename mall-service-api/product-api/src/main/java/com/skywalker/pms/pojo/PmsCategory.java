package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * @Author Code SkyWalker
 * @Classname PmsCategory
 * @Description TODO
 */
@Table(name="pms_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsCategory implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
	private Long catId;//分类id

    @Column(name = "name")
	private String name;//分类名称

    @Column(name = "parent_cid")
	private Long parentCid;//父分类id

    @Column(name = "cat_level")
	private Integer catLevel;//层级

    @Column(name = "show_status")
	private Integer showStatus;//是否显示[0-不显示，1显示]

    @Column(name = "sort")
	private Integer sort;//排序

    @Column(name = "icon")
	private String icon;//图标地址

    @Column(name = "product_unit")
	private String productUnit;//计量单位

    @Column(name = "product_count")
	private Integer productCount;//商品数量

    @Transient
    private List<PmsCategory> children;
}
