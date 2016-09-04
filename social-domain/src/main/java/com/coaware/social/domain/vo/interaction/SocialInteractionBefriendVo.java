package com.coaware.social.domain.vo.interaction;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.coaware.social.common.persistence.DataEntity;
import com.coaware.social.common.persistence.Page;
import com.coaware.social.domain.member.SocialMember;

/**
 * 邻邦帮助信息表Entity
 * @author Administrator
 * @version 2016-08-26
 */
public class SocialInteractionBefriendVo extends DataEntity<SocialInteractionBefriendVo> {
	
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
	
	private String userName;		// 用户名
	private String fullName;		// 姓名
	private String nickName;		//昵称
	private String password;		//密码
	private Integer sex;		// 性别 1:男 2：女
	private String mobile;		// 手机号
	private Integer verify;		// 身份验证 1:验证通过（审核通过），2：验证不通过（审核不通过），3：待审核 4：待提交
	private String idCard;		// 身份证号
	private String idCardFrontPath;		// 身份证正面
	private String idCardBackPath;		// 身份证反面
	private Date birthday;		// 生日
	private String rejection;		// 驳回理由
	private String headImg;		// 头像
	private Integer status;		// 状态 1：激活，2：禁用 0：未定义
	private String deviceToken;		// 手机设备token
	private Integer deviceType;	//token设备类型 1：iOS ，2：Android
	private Integer isCared;//是否关注社区

	public String getCharged() {
		return charged;
	}

	public void setCharged(String charged) {
		this.charged = charged;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getVerify() {
		return verify;
	}

	public void setVerify(Integer verify) {
		this.verify = verify;
	}

	public String getIdCardFrontPath() {
		return idCardFrontPath;
	}

	public void setIdCardFrontPath(String idCardFrontPath) {
		this.idCardFrontPath = idCardFrontPath;
	}

	public String getIdCardBackPath() {
		return idCardBackPath;
	}

	public void setIdCardBackPath(String idCardBackPath) {
		this.idCardBackPath = idCardBackPath;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRejection() {
		return rejection;
	}

	public void setRejection(String rejection) {
		this.rejection = rejection;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getIsCared() {
		return isCared;
	}

	public void setIsCared(Integer isCared) {
		this.isCared = isCared;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkTime() {
		return linkTime;
	}

	public void setLinkTime(String linkTime) {
		this.linkTime = linkTime;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

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

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getDisplayPhone() {
		return displayPhone;
	}

	public void setDisplayPhone(Integer displayPhone) {
		this.displayPhone = displayPhone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	

	
}