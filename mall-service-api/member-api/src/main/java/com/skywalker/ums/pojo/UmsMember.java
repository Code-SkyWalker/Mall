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
 * @Classname UmsMember
 * @Description TODO
 */
@Table(name="ums_member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsMember implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "level_id")
	private Long levelId;//会员等级id

    @Column(name = "username")
	private String username;//用户名

    @Column(name = "password")
	private String password;//密码

    @Column(name = "nickname")
	private String nickname;//昵称

    @Column(name = "mobile")
	private String mobile;//手机号码

    @Column(name = "email")
	private String email;//邮箱

    @Column(name = "header")
	private String header;//头像

    @Column(name = "gender")
	private Integer gender;//性别

    @Column(name = "birth")
	private LocalDate birth;//生日

    @Column(name = "city")
	private String city;//所在城市

    @Column(name = "job")
	private String job;//职业

    @Column(name = "sign")
	private String sign;//个性签名

    @Column(name = "source_type")
	private Integer sourceType;//用户来源

    @Column(name = "integration")
	private Integer integration;//积分

    @Column(name = "growth")
	private Integer growth;//成长值

    @Column(name = "status")
	private Integer status;//启用状态

    @Column(name = "create_time")
	private LocalDate createTime;//注册时间



}
