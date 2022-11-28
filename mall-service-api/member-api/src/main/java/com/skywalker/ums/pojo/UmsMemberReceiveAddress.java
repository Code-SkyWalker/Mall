package com.skywalker.ums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname UmsMemberReceiveAddress
 * @Description TODO
 */
@Table(name="ums_member_receive_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsMemberReceiveAddress implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "member_id")
	private Long memberId;//member_id

    @Column(name = "name")
	private String name;//收货人姓名

    @Column(name = "phone")
	private String phone;//电话

    @Column(name = "post_code")
	private String postCode;//邮政编码

    @Column(name = "province")
	private String province;//省份/直辖市

    @Column(name = "city")
	private String city;//城市

    @Column(name = "region")
	private String region;//区

    @Column(name = "detail_address")
	private String detailAddress;//详细地址(街道)

    @Column(name = "areacode")
	private String areacode;//省市区代码

    @Column(name = "default_status")
	private String defaultStatus;//是否默认



}
