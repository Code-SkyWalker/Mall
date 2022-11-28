package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsSpuImages
 * @Description TODO
 */
@Table(name="pms_spu_images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsSpuImages implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "spu_id")
	private Long spuId;//spu_id

    @Column(name = "img_name")
	private String imgName;//图片名

    @Column(name = "img_url")
	private String imgUrl;//图片地址

    @Column(name = "img_sort")
	private Integer imgSort;//顺序

    @Column(name = "default_img")
	private Integer defaultImg;//是否默认图



}
