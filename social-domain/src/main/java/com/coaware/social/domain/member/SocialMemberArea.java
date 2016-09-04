package com.coaware.social.domain.member;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 系统用户关注社区表Entity
 * @author Administrator
 * @version 2016-06-03
 */
public class SocialMemberArea extends DataEntity<SocialMemberArea> {
	
	private static final long serialVersionUID = 1L;
	private Integer memberId;		 
	private Integer areaId;		 
	
	 
	public SocialMemberArea() {
		super();
	}

	public SocialMemberArea(Integer id){
		super(id);
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	 
}