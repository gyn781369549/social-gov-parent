package com.coaware.social.domain.sys;

import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 系统用户表Entity
 * @author Administrator
 * @version 2016-06-03
 */
public class SocialArea extends DataEntity<SocialArea> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private Integer parentId;		// parent_id
	private String code;		// code
	private String level;		// level
	
	private String parentName;
	public SocialArea() {
		super();
	}

	public SocialArea(Integer id){
		super(id);
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
	
}