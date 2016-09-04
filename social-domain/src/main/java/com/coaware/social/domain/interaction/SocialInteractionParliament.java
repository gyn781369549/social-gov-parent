package com.coaware.social.domain.interaction;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 居民议事会Entity
 * @author Administrator
 * @version 2016-08-26
 */
public class SocialInteractionParliament extends DataEntity<SocialInteractionParliament> {
	
	private static final long serialVersionUID = 1L;
	private Integer areaId;		// 社区id
	private Integer userId;		// 用户id
	private Date time;		// 创建时间
	private String content;		// 评论内容
	
	public SocialInteractionParliament() {
		super();
	}

	public SocialInteractionParliament(Integer id){
		super(id);
	}

	@NotNull(message="社区id不能为空")
	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
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
	
	@Length(min=0, max=255, message="评论内容长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}