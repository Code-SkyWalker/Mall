package com.skywalker.oms.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnReason
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oms_order_return_reason")
public class OmsOrderReturnReason implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "name")
	private String name;//退货原因名

    @Column(name = "sort")
	private Integer sort;//排序

    @Column(name = "status")
	private String status;//启用状态

    @Column(name = "create_time")
	private LocalDate createTime;//create_time



}
