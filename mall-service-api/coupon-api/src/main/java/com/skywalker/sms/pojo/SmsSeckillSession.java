package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSession
 * @Description TODO
 */
@Table(name="sms_seckill_session")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsSeckillSession implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "name")
	private String name;//场次名称

    @Column(name = "start_time")
	private LocalDate startTime;//每日开始时间

    @Column(name = "end_time")
	private LocalDate endTime;//每日结束时间

    @Column(name = "status")
	private String status;//启用状态

    @Column(name = "create_time")
	private LocalDate createTime;//创建时间



}
