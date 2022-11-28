package com.skywalker.ums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLoginLog
 * @Description TODO
 */
@Table(name="ums_member_login_log")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsMemberLoginLog implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "member_id")
	private Long memberId;//member_id

    @Column(name = "create_time")
	private LocalDate createTime;//创建时间

    @Column(name = "ip")
	private String ip;//ip

    @Column(name = "city")
	private String city;//city

    @Column(name = "login_type")
	private String loginType;//登录类型[1-web，2-app]



}
