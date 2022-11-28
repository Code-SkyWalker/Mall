package com.skywalker.ums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname UmsMemberStatisticsInfo
 * @Description TODO
 */
@Table(name="ums_member_statistics_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UmsMemberStatisticsInfo implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "member_id")
	private Long memberId;//会员id

    @Column(name = "consume_amount")
	private String consumeAmount;//累计消费金额

    @Column(name = "coupon_amount")
	private String couponAmount;//累计优惠金额

    @Column(name = "order_count")
	private Integer orderCount;//订单数量

    @Column(name = "coupon_count")
	private Integer couponCount;//优惠券数量

    @Column(name = "comment_count")
	private Integer commentCount;//评价数

    @Column(name = "return_order_count")
	private Integer returnOrderCount;//退货数量

    @Column(name = "login_count")
	private Integer loginCount;//登录次数

    @Column(name = "attend_count")
	private Integer attendCount;//关注数量

    @Column(name = "fans_count")
	private Integer fansCount;//粉丝数量

    @Column(name = "collect_product_count")
	private Integer collectProductCount;//收藏的商品数量

    @Column(name = "collect_subject_count")
	private Integer collectSubjectCount;//收藏的专题活动数量

    @Column(name = "collect_comment_count")
	private Integer collectCommentCount;//收藏的评论数量

    @Column(name = "invite_friend_count")
	private Integer inviteFriendCount;//邀请的朋友数量



}
