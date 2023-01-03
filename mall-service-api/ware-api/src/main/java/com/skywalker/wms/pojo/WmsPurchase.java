package com.skywalker.wms.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @Author Code SkyWalker
 * @Classname WmsPurchase
 * @Description TODO
 */
@Table(name="wms_purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WmsPurchase implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id; // 采购单ID

    @Column(name = "assignee_id")
	private Long assigneeId; // 采购人ID

    @Column(name = "assignee_name")
	private String assigneeName; // 采购人姓名

    @Column(name = "phone")
	private String phone; // 采购人电话

    @Column(name = "priority")
	private Integer priority; // 优先级

    @Column(name = "status")
	private Integer status; // 状态: 0:新建 1:已分配 2:已领取 3:已完成 4:有异常

    @Column(name = "ware_id")
	private Long wareId; // 仓库ID

    @Column(name = "amount")
	private String amount; // 总金额

    @Column(name = "create_time")
	private LocalDateTime createTime; // 创建日期

    @Column(name = "update_time")
	private LocalDateTime updateTime; // 修改日期



}
