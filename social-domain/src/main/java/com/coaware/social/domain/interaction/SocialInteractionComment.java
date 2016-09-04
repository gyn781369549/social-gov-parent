package com.coaware.social.domain.interaction;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 帮助信息评论表Entity
 * @author Administrator
 * @version 2016-08-26
 */
public class SocialInteractionComment extends DataEntity<SocialInteractionComment> {
	
	private static final long serialVersionUID = 1L;
	private Integer user_Id;		// 用户id
	private Integer sib_Id;		// 邻帮_帮助信息表id
	private Integer checkk;		// 审核是否通过0待审核&amp;1审核通过 &amp;2被驳回默认0
	private Date time;		// 申请时间（年月日时分秒）
	private String content;		// 评论内容
	private Integer star;		// 评级 满意度1-5星星 默认0
	private Integer source;		// 0邻帮_帮助信息表1社区公示表2意见箱3
	private Integer isReply;		// 0未回复1已回复
	private Integer screen;		// 是否屏蔽   0未屏蔽&amp;1屏蔽 默认0
	
	private Integer type;     //问题种类
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public SocialInteractionComment() {
		super();
	}

	public SocialInteractionComment(Integer id){
		super(id);
	}

	
	
	
	
	
	
	
	public Integer getSib_Id() {
		return sib_Id;
	}
		
	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	public void setSib_Id(Integer sib_Id) {
		this.sib_Id = sib_Id;
	}

	

	public Integer getCheckk() {
		return checkk;
	}

	public void setCheckk(Integer checkk) {
		this.checkk = checkk;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Length(min=0, max=255, message="评论内容长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}
	
	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}
	
	public Integer getIsReply() {
		return isReply;
	}

	public void setIsReply(Integer isReply) {
		this.isReply = isReply;
	}
	
	public Integer getScreen() {
		return screen;
	}

	public void setScreen(Integer screen) {
		this.screen = screen;
	}
	
}