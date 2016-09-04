package com.coaware.social.domain.vo.data;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.persistence.DataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 网格信息Entity
 * @author Administrator
 * @version 2016-06-28
 */
public class SocialGridInfoVo extends DataEntity<SocialGridInfoVo> {
	
	private static final long serialVersionUID = 1L;
	private Integer areaId;		// 行政区id
	private String communityName;	//社区
	private String committeeName;	//居委会
	private String gridNum;		// 网格编号
	private String gridName;		// 网格名称
	private Integer gridType;		// 网格类型
	private Double gridArea;		// 网格面积
	private Integer gridHouseholds;		// 网格户数
	private String gridAddress;		// 网格地址
	private String gridDescribe;		// 网格描述	
	Date createDate;
	private String updateBy;
	private String  createBy;
	private String conditions;
	private String keyWord;
	private String maxGridNum;  //最大的网格号
	
	public String getMaxGridNum() {
		return maxGridNum;
	}

	public void setMaxGridNum(String maxGridNum) {
		this.maxGridNum = maxGridNum;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public SocialGridInfoVo() {
		super();
	}

	public SocialGridInfoVo(Integer id){
		super(id);
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	@Length(min=0, max=50, message="网格编号长度必须介于 0 和 50 之间")
	public String getGridNum() {
		return gridNum;
	}

	public void setGridNum(String gridNum) {
		this.gridNum = gridNum;
	}
	
	@Length(min=0, max=30, message="网格名称长度必须介于 0 和 30 之间")
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
	
	@Length(min=0, max=30, message="网格地址长度必须介于 0 和 30 之间")
	public String getGridAddress() {
		return gridAddress;
	}

	public void setGridAddress(String gridAddress) {
		this.gridAddress = gridAddress;
	}
	
	@Length(min=0, max=100, message="网格描述长度必须介于 0 和 100 之间")
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
	
}