package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectSpu
 * @Description TODO
 */
@Table(name="sms_home_subject_spu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsHomeSubjectSpu implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "name")
	private String name;//专题名字

    @Column(name = "subject_id")
	private Long subjectId;//专题id

    @Column(name = "spu_id")
	private Long spuId;//spu_id

    @Column(name = "sort")
	private Integer sort;//排序



}
