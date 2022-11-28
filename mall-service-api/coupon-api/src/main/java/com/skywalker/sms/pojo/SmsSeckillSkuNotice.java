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
 * @Classname SmsSeckillSkuNotice
 * @Description TODO
 */
@Table(name="sms_seckill_sku_notice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsSeckillSkuNotice implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "member_id")
	private Long memberId;//member_id

    @Column(name = "sku_id")
	private Long skuId;//sku_id

    @Column(name = "session_id")
	private Long sessionId;//活动场次id

    @Column(name = "subcribe_time")
	private LocalDate subcribeTime;//订阅时间

    @Column(name = "send_time")
	private LocalDate sendTime;//发送时间

    @Column(name = "notice_type")
	private String noticeType;//通知方式[0-短信，1-邮件]



}
