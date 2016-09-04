package com.coaware.social.domain.interaction;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 统计有用没用表Entity
 * @author Administrator
 * @version 2016-08-26
 */
public class SocialInteractionGood extends DataEntity<SocialInteractionGood> {
	
	private static final long serialVersionUID = 1L;
	private Integer commentId;		// 评论id
	private Integer userId;		// 用户id
	private Date time;		// 创建时间
	private Integer good;		// 0没用1有用
	private Integer checkk;		// 区分来源
	
	public SocialInteractionGood() {
		super();
	}

	public SocialInteractionGood(Integer id){
		super(id);
	}

	@NotNull(message="评论id不能为空")
	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	
	@NotNull(message="用户id不能为空")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public Integer getGood() {
		return good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}

	public Integer getCheckk() {
		return checkk;
	}

	public void setCheckk(Integer checkk) {
		this.checkk = checkk;
	}
	
	
	
}