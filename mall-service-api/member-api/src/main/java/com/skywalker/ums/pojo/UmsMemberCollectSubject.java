package com.skywalker.ums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSubject
 * @Description TODO
 */
@Table(name="ums_member_collect_subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsMemberCollectSubject implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "subject_id")
	private Long subjectId;//subject_id

    @Column(name = "subject_name")
	private String subjectName;//subject_name

    @Column(name = "subject_img")
	private String subjectImg;//subject_img

    @Column(name = "subject_urll")
	private String subjectUrll;//活动url



}
