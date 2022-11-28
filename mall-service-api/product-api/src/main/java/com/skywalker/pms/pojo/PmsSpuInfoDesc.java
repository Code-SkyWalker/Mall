package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoDesc
 * @Description TODO
 */
@Table(name="pms_spu_info_desc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsSpuInfoDesc implements Serializable{

	@Id
    @Column(name = "spu_id")
	private Long spuId;//商品id

    @Column(name = "decript")
	private String decript;//商品介绍



}
