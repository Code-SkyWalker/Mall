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
 * @Classname UmsMemberCollectSpu
 * @Description TODO
 */
@Table(name="ums_member_collect_spu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsMemberCollectSpu implements Serializable{

	@Id
    @Column(name = "id")
	private Long id;//id

    @Column(name = "member_id")
	private Long memberId;//会员id

    @Column(name = "spu_id")
	private Long spuId;//spu_id

    @Column(name = "spu_name")
	private String spuName;//spu_name

    @Column(name = "spu_img")
	private String spuImg;//spu_img

    @Column(name = "create_time")
	private LocalDate createTime;//create_time



}
