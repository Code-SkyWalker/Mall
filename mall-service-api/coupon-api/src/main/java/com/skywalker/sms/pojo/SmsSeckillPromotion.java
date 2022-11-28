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
 * @Classname SmsSeckillPromotion
 * @Description TODO
 */
@Table(name="sms_seckill_promotion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsSeckillPromotion implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "title")
	private String title;//活动标题

    @Column(name = "start_time")
	private LocalDate startTime;//开始日期

    @Column(name = "end_time")
	private LocalDate endTime;//结束日期

    @Column(name = "status")
	private Integer status;//上下线状态

    @Column(name = "create_time")
	private LocalDate createTime;//创建时间

    @Column(name = "user_id")
	private Long userId;//创建人



}
