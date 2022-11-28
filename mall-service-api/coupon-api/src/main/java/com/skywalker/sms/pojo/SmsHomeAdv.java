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
 * @Classname SmsHomeAdv
 * @Description TODO
 */
@Table(name="sms_home_adv")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsHomeAdv implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "name")
	private String name;//名字

    @Column(name = "pic")
	private String pic;//图片地址

    @Column(name = "start_time")
	private LocalDate startTime;//开始时间

    @Column(name = "end_time")
	private LocalDate endTime;//结束时间

    @Column(name = "status")
	private String status;//状态

    @Column(name = "click_count")
	private Integer clickCount;//点击数

    @Column(name = "url")
	private String url;//广告详情连接地址

    @Column(name = "note")
	private String note;//备注

    @Column(name = "sort")
	private Integer sort;//排序

    @Column(name = "publisher_id")
	private Long publisherId;//发布者

    @Column(name = "auth_id")
	private Long authId;//审核者



}
