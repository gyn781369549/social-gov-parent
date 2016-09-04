package com.coaware.social.domain.vo.data;

import java.util.Date;

import com.coaware.social.common.persistence.DataEntity;
/**
 * 网格员 传值对象
 * */
public class SocialGridMemberVo extends DataEntity<SocialGridInfoVo>{ 
	private Integer areaId;		// 行政区id
	private String communityName;	//社区
	private String committeeName;	//居委会
	private String userName;    //网格员姓名
	private String tel ;        //网格员电话
	private String userId;
	private String gridNum;		// 网格编号
	private String gridName;		// 网格名称
	private Integer gridType;		// 网格类型
	private Double gridArea;		// 网格面积
	private Integer gridHouseholds;		// 网格户数
	private String gridAddress;		// 网格地址
	private String gridDescribe;		// 网格描述	  
	private String conditions;
	private String keyWord;
	private String maxGridNum;  //最大的网格号
	
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getCommitteeName() {
		return committeeName;
	}
	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGridNum() {
		return gridNum;
	}
	public void setGridNum(String gridNum) {
		this.gridNum = gridNum;
	}
	public String getGridName() {
		return gridName;
	}
	public void setGridName(String gridName) {
		this.gridName = gridName;
	}
	public Integer getGridType() {
		return gridType;
	}
	public void setGridType(Integer gridType) {
		this.gridType = gridType;
	}
	public Double getGridArea() {
		return gridArea;
	}
	public void setGridArea(Double gridArea) {
		this.gridArea = gridArea;
	}
	public Integer getGridHouseholds() {
		return gridHouseholds;
	}
	public void setGridHouseholds(Integer gridHouseholds) {
		this.gridHouseholds = gridHouseholds;
	}
	public String getGridAddress() {
		return gridAddress;
	}
	public void setGridAddress(String gridAddress) {
		this.gridAddress = gridAddress;
	}
	public String getGridDescribe() {
		return gridDescribe;
	}
	public void setGridDescribe(String gridDescribe) {
		this.gridDescribe = gridDescribe;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getMaxGridNum() {
		return maxGridNum;
	}
	public void setMaxGridNum(String maxGridNum) {
		this.maxGridNum = maxGridNum;
	}
	
	
	
}
