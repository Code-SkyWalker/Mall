package com.skywalker.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskDetail
 * @Description TODO
 */
@Table(name="wms_ware_order_task_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WmsWareOrderTaskDetail implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id; // id

    @Column(name = "sku_id")
	private Long skuId; // sku_id

    @Column(name = "sku_name")
	private String skuName; // sku_name

    @Column(name = "sku_num")
	private Integer skuNum; // 购买个数

    @Column(name = "task_id")
	private Long taskId; // 工作单id

    @Column(name = "ware_id")
	private Long wareId; // 仓库id

    @Column(name = "lock_status")
	private Integer lockStatus; // 1-已锁定  2-已解锁  3-扣减



}
