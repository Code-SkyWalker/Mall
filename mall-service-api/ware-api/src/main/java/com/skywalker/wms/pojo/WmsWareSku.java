package com.skywalker.wms.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname WmsWareSku
 * @Description TODO
 */
@Table(name="wms_ware_sku")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WmsWareSku implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id; // id

    @Column(name = "sku_id")
	private Long skuId; // sku_id

    @Column(name = "ware_id")
	private Long wareId; // 仓库id

    @Column(name = "stock")
	private Integer stock; // 库存数

    @Column(name = "sku_name")
	private String skuName; // sku_name

    @Column(name = "stock_locked")
	private Integer stockLocked; // 锁定库存



}
