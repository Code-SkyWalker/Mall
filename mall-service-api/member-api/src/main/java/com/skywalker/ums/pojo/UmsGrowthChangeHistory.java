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
 * @Classname UmsGrowthChangeHistory
 * @Description TODO
 */
@Table(name="ums_growth_change_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsGrowthChangeHistory implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "member_id")
	private Long memberId;//member_id

    @Column(name = "create_time")
	private LocalDate createTime;//create_time

    @Column(name = "change_count")
	private Integer changeCount;//改变的值（正负计数）

    @Column(name = "note")
	private String note;//备注

    @Column(name = "source_type")
	private Integer sourceType;//积分来源[0-购物，1-管理员修改]



}
