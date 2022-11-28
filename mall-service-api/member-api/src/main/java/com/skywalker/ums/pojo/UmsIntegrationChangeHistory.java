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
 * @Classname UmsIntegrationChangeHistory
 * @Description TODO
 */
@Table(name="ums_integration_change_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsIntegrationChangeHistory implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "member_id")
	private Long memberId;//member_id

    @Column(name = "create_time")
	private LocalDate createTime;//create_time

    @Column(name = "change_count")
	private Integer changeCount;//变化的值

    @Column(name = "note")
	private String note;//备注

    @Column(name = "source_tyoe")
	private Integer sourceTyoe;//来源[0->购物；1->管理员修改;2->活动]



}
