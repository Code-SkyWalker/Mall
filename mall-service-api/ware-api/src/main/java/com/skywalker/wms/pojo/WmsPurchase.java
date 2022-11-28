package com.skywalker.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @Author Code SkyWalker
 * @Classname WmsPurchase
 * @Description TODO
 */
@Table(name="wms_purchase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WmsPurchase implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id; // 

    @Column(name = "assignee_id")
	private Long assigneeId; // 

    @Column(name = "assignee_name")
	private String assigneeName; // 

    @Column(name = "phone")
	private String phone; // 

    @Column(name = "priority")
	private Integer priority; // 

    @Column(name = "status")
	private Integer status; // 

    @Column(name = "ware_id")
	private Long wareId; // 

    @Column(name = "amount")
	private String amount; // 

    @Column(name = "create_time")
	private LocalDate createTime; //

    @Column(name = "update_time")
	private LocalDate updateTime; //



}
