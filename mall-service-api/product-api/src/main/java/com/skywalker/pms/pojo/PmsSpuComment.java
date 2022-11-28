package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @Author Code SkyWalker
 * @Classname PmsSpuComment
 * @Description TODO
 */
@Table(name="pms_spu_comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsSpuComment implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "sku_id")
	private Long skuId;//sku_id

    @Column(name = "spu_id")
	private Long spuId;//spu_id

    @Column(name = "spu_name")
	private String spuName;//商品名字

    @Column(name = "member_nick_name")
	private String memberNickName;//会员昵称

    @Column(name = "star")
	private String star;//星级

    @Column(name = "member_ip")
	private String memberIp;//会员ip

    @Column(name = "create_time")
	private LocalDate createTime;//创建时间

    @Column(name = "show_status")
	private String showStatus;//显示状态[0-不显示，1-显示]

    @Column(name = "spu_attributes")
	private String spuAttributes;//购买时属性组合

    @Column(name = "likes_count")
	private Integer likesCount;//点赞数

    @Column(name = "reply_count")
	private Integer replyCount;//回复数

    @Column(name = "resources")
	private String resources;//评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]

    @Column(name = "content")
	private String content;//内容

    @Column(name = "member_icon")
	private String memberIcon;//用户头像

    @Column(name = "comment_type")
	private Integer commentType;//评论类型[0 - 对商品的直接评论，1 - 对评论的回复]



}
