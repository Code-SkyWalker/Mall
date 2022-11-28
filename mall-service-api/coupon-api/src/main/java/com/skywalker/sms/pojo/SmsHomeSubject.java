package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubject
 * @Description TODO
 */
@Table(name="sms_home_subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsHomeSubject implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "name")
	private String name;//专题名字

    @Column(name = "title")
	private String title;//专题标题

    @Column(name = "sub_title")
	private String subTitle;//专题副标题

    @Column(name = "status")
	private String status;//显示状态

    @Column(name = "url")
	private String url;//详情连接

    @Column(name = "sort")
	private Integer sort;//排序

    @Column(name = "img")
	private String img;//专题图片地址



}
