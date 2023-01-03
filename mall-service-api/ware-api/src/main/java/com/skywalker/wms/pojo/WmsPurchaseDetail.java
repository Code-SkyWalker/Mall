package com.skywalker.wms.pojo;

import com.skywalker.constant.WareConstant;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseDetail
 * @Description TODO
 */
@Table(name="wms_purchase_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WmsPurchaseDetail implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id; // 

    @Column(name = "purchase_id")
	private Long purchaseId; // 采购单id

    @Column(name = "sku_id")
	private Long skuId; // 采购商品id

    @Column(name = "sku_num")
	private Integer skuNum; // 采购数量

    @Column(name = "sku_price")
	private String skuPrice; // 采购金额

    @Column(name = "ware_id")
	private Long wareId; // 仓库id

    @Column(name = "status")
	private Integer status; // 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]



}
