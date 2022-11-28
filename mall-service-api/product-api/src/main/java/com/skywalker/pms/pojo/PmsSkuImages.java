package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsSkuImages
 * @Description TODO
 */
@Table(name="pms_sku_images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsSkuImages implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "sku_id")
	private Long skuId;//sku_id

    @Column(name = "img_url")
	private String imgUrl;//图片地址

    @Column(name = "img_sort")
	private Integer imgSort;//排序

    @Column(name = "default_img")
	private Integer defaultImg;//默认图[0 - 不是默认图，1 - 是默认图]



}
