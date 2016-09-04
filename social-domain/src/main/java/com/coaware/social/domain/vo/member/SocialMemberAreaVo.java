package com.coaware.social.domain.vo.member;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 系统用户关注社区表Entity
 * @author Administrator
 * @version 2016-06-03
 */
@JsonInclude(value = Include.ALWAYS)
public class SocialMemberAreaVo  {
 
	private String memberId;//注册用户id		 
	private String areaId;	//社区id
	private String name;//社区名字
	 
	public SocialMemberAreaVo() {
		super();
	}

	 

	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getAreaId() {
		return areaId;
	}



	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
}