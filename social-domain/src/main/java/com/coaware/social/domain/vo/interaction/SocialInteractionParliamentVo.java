package com.coaware.social.domain.vo.interaction;

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
public class SocialInteractionParliamentVo extends DataEntity<SocialInteractionParliamentVo> {
	
	private static final long serialVersionUID = 1L;
	private Integer areaId;		// 社区id
	private Integer userId;		// 用户id
	private Date time;		// 创建时间
	private String content;		// 评论内容
	

	private Integer socialAreaId;
	private String name;		// name
	private Integer parentId;		// parent_id
	private String code;		// code
	private String level;		// level
	
	private String parentName;

	public Integer getSocialAreaId() {
		return socialAreaId;
	}

	public void setSocialAreaId(Integer socialAreaId) {
		this.socialAreaId = socialAreaId;
	}

	@Length(min=0, max=100, message="name长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	@Length(min=0, max=20, message="code长度必须介于 0 和 20 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=11, message="level长度必须介于 0 和 11 之间")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	
	
	public SocialInteractionParliamentVo() {
		super();
	}

	public SocialInteractionParliamentVo(Integer id){
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