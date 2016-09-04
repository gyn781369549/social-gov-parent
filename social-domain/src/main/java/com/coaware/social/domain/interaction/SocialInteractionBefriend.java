package com.coaware.social.domain.interaction;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.coaware.social.common.persistence.DataEntity;
import com.coaware.social.domain.member.SocialMember;

/**
 * 邻邦帮助信息表Entity
 * @author Administrator
 * @version 2016-08-26
 */
public class SocialInteractionBefriend extends DataEntity<SocialInteractionBefriend> {
	
	private static final long serialVersionUID = 1L;
	private Integer userId;		// 用户id
	private Integer checkk;		// 审核是否通过0待审核&amp;1审核通过 &amp;2被驳回 默认0
	private String phone;		// 联系电话
	private String address;		// 联系地址
	private String linkTime;		// 联系时间范围
	private Date time;		// 申请时间（年月日）
	private String content;		// 帮助内容简介
	private Integer isCharged;		// 是否收费 0免费&amp;1收费 默认0
	private String pic;		// 图片地址
	private Integer feature;		// 组织特性0公益&amp;1个人 默认0
	private Integer come;		// 状态 0求助&amp;1帮助 默认0
	
	private Integer areaId;    //社区id
	private Integer displayPhone;	//是否显示联系方式 0不显示 1显示
	private String code;    //组织机构代码
	private String log;    //经度
	private String lat;    //wei度
	private String charged;//收费标准
	
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getCharged() {
		return charged;
	}
	public void setCharged(String charged) {
		this.charged = charged;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getDisplayPhone() {
		return displayPhone;
	}
	public void setDisplayPhone(Integer displayPhone) {
		this.displayPhone = displayPhone;
	}

	public SocialInteractionBefriend() {
		super();
	}

	public SocialInteractionBefriend(Integer id){
		super(id);
	}

	@NotNull(message="用户id不能为空")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
	public Integer getCheckk() {
		return checkk;
	}
	public void setCheckk(Integer checkk) {
		this.checkk = checkk;
	}
	@Length(min=0, max=64, message="联系电话长度必须介于 0 和 64 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=64, message="联系地址长度必须介于 0 和 64 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=64, message="联系时间范围长度必须介于 0 和 64 之间")
	public String getLinkTime() {
		return linkTime;
	}

	public void setLinkTime(String linkTime) {
		this.linkTime = linkTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Length(min=0, max=255, message="帮助内容简介长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getIsCharged() {
		return isCharged;
	}

	public void setIsCharged(Integer isCharged) {
		this.isCharged = isCharged;
	}
	
	@Length(min=0, max=255, message="图片地址长度必须介于 0 和 255 之间")
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public Integer getFeature() {
		return feature;
	}

	public void setFeature(Integer feature) {
		this.feature = feature;
	}
	
	public Integer getCome() {
		return come;
	}

	public void setCome(Integer come) {
		this.come = come;
	}

	@NotNull(message="社区id不能为空")
	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	
}