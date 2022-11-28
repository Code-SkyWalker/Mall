package com.skywalker.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname SmsSpuBounds
 * @Description TODO
 */
@Table(name="sms_spu_bounds")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsSpuBounds implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "spu_id")
	private Long spuId;//

    @Column(name = "grow_bounds")
	private String growBounds;//成长积分

    @Column(name = "buy_bounds")
	private String buyBounds;//购物积分

    @Column(name = "work")
	private String work;//优惠生效情况[1111（四个状态位，从右到左）;0 - 无优惠，成长积分是否赠送;1 - 无优惠，购物积分是否赠送;2 - 有优惠，成长积分是否赠送;3 - 有优惠，购物积分是否赠送【状态位0：不赠送，1：赠送】]



}
