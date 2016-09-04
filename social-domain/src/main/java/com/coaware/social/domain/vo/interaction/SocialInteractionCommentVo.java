package com.coaware.social.domain.vo.interaction;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 帮助信息评论表Entity
 * @author Administrator
 * @version 2016-08-26
 */
public class SocialInteractionCommentVo extends DataEntity<SocialInteractionCommentVo> {
	
	private static final long serialVersionUID = 1L;
	private Integer userId;		// 用户id
	private Integer sibId;		// 邻帮_帮助信息表id
	private Integer checkk;		// 审核是否通过0待审核&amp;1审核通过 &amp;2被驳回默认0
	private Date time;		// 申请时间（年月日时分秒）
	private String content;		// 评论内容
	private Integer star;		// 评级 满意度1-5星星 默认0
	private Integer source;		// 0邻帮_帮助信息表1社区公示表2意见箱3
	private Integer isReply;		// 0未回复1已回复
	private Integer screen;		// 是否屏蔽   0未屏蔽&amp;1屏蔽 默认0
	
	
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

	private Integer type;     //问题种类
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public SocialInteractionCommentVo() {
		super();
	}

	public SocialInteractionCommentVo(Integer id){
		super(id);
	}

	
	
	//@NotNull(message="用户id不能为空")


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSibId() {
		return sibId;
	}

	public void setSibId(Integer sibId) {
		this.sibId = sibId;
	}

	

	public Integer getCheckk() {
		return checkk;
	}

	public void setCheckk(Integer checkk) {
		this.checkk = checkk;
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
	
	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}
	
	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}
	
	public Integer getIsReply() {
		return isReply;
	}

	public void setIsReply(Integer isReply) {
		this.isReply = isReply;
	}
	
	public Integer getScreen() {
		return screen;
	}

	public void setScreen(Integer screen) {
		this.screen = screen;
	}
	
}