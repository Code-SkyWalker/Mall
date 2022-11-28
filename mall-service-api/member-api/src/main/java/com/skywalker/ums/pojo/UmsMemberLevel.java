package com.skywalker.ums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLevel
 * @Description TODO
 */
@Table(name="ums_member_level")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsMemberLevel implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "name")
	private String name;//等级名称

    @Column(name = "growth_point")
	private Integer growthPoint;//等级需要的成长值

    @Column(name = "default_status")
	private Integer defaultStatus;//是否为默认等级[0->不是；1->是]

    @Column(name = "free_freight_point")
	private String freeFreightPoint;//免运费标准

    @Column(name = "comment_growth_point")
	private Integer commentGrowthPoint;//每次评价获取的成长值

    @Column(name = "priviledge_free_freight")
	private Integer priviledgeFreeFreight;//是否有免邮特权

    @Column(name = "priviledge_member_price")
	private Integer priviledgeMemberPrice;//是否有会员价格特权

    @Column(name = "priviledge_birthday")
	private Integer priviledgeBirthday;//是否有生日特权

    @Column(name = "note")
	private String note;//备注



}
