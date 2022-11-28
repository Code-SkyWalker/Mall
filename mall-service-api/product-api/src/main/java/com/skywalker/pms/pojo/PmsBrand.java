package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsBrand
 * @Description TODO
 */
@Table(name="pms_brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsBrand implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
	private Long brandId;//品牌id

    @Column(name = "name")
	private String name;//品牌名

    @Column(name = "logo")
	private String logo;//品牌logo地址

    @Column(name = "descript")
	private String descript;//介绍

    @Column(name = "show_status")
	private Integer showStatus;//显示状态[0-不显示；1-显示]

    @Column(name = "first_letter")
	private String firstLetter;//检索首字母

    @Column(name = "sort")
	private Integer sort;//排序



}
