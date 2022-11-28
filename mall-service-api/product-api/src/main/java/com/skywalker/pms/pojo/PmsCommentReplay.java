package com.skywalker.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsCommentReplay
 * @Description TODO
 */
@Table(name="pms_comment_replay")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsCommentReplay implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//id

    @Column(name = "comment_id")
	private Long commentId;//评论id

    @Column(name = "reply_id")
	private Long replyId;//回复id



}
