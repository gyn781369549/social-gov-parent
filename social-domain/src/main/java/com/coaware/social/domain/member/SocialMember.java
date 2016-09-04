package com.coaware.social.domain.member;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 社区管家注册用户Entity
 * @author Administrator
 * @version 2016-06-25
 */
public class SocialMember extends DataEntity<SocialMember> {
	
	private static final long serialVersionUID = 1L;
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
	
	private String code;//短信验证码
	private Integer isCared;//是否关注社区
	
	private List<Integer> selverify;
	
	public SocialMember() {
		super();
	}

	public SocialMember(Integer id){
		super(id);
	}

	@Length(min=0, max=20, message="用户名长度必须介于 0 和 20 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=50, message="姓名长度必须介于 0 和 50 之间")
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
	
	@Length(min=0, max=20, message="手机号长度必须介于 0 和 20 之间")
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
	
	@Length(min=0, max=20, message="身份证号长度必须介于 0 和 20 之间")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=200, message="身份证正面长度必须介于 0 和 200 之间")
	public String getIdCardFrontPath() {
		return idCardFrontPath;
	}

	public void setIdCardFrontPath(String idCardFrontPath) {
		this.idCardFrontPath = idCardFrontPath;
	}
	
	@Length(min=0, max=200, message="身份证反面长度必须介于 0 和 200 之间")
	public String getIdCardBackPath() {
		return idCardBackPath;
	}

	public void setIdCardBackPath(String idCardBackPath) {
		this.idCardBackPath = idCardBackPath;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=500, message="驳回理由长度必须介于 0 和 500 之间")
	public String getRejection() {
		return rejection;
	}

	public void setRejection(String rejection) {
		this.rejection = rejection;
	}
	
	@Length(min=0, max=200, message="头像长度必须介于 0 和 200 之间")
	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Length(min=0, max=100, message="手机设备token长度必须介于 0 和 100 之间")
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getIsCared() {
		return isCared;
	}

	public void setIsCared(Integer isCared) {
		this.isCared = isCared;
	}

	public List<Integer> getSelverify() {
		return selverify;
	}

	public void setSelverify(List<Integer> selverify) {
		this.selverify = selverify;
	}

	

	 
	
}