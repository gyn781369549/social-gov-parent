package com.coaware.social.domain.sys;

import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 用户Entity
 * @author Administrator
 * @version 2016-06-03
 */
public class SocialSysUser extends DataEntity<SocialSysUser> {
	
	private static final long serialVersionUID = 1L;
	private String loginName;		// login_name
	private String userName;		// user_name
	private String mobile;		// mobile
	private String password;		// password
	private String sex;		// sex
	private String qq;		// qq
	private String tel;		// tel
	private String email;		// email
	private String roleId;		// role_id
	private String communityId;		// community_id
	private String netId;		// net_id
	private String deptId;		// dept_id
	private String roleName;
	private String deptname ;  
	private String areaname;
	private String position;
	private String netName;
	
	private Integer userType;//用户种类（1：后台；2：网格员；3：运营人员）
	
	private String classtype;
	private String otherdelFlag;
	private String otherclasstype;
	
	private String net0name;
	private String net1name;
	private String net2name;
	private String net3name;
	
	private Integer order;
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}	
	public SocialSysUser() {
		super();
	}

	public SocialSysUser(Integer id){
		super(id);
	}

	@Length(min=1, max=20, message="login_name长度必须介于 1 和 20 之间")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Length(min=1, max=50, message="user_name长度必须介于 1 和 50 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=20, message="mobile长度必须介于 0 和 20 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=50, message="password长度必须介于 0 和 50 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=1, message="sex长度必须介于 0 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=20, message="qq长度必须介于 0 和 20 之间")
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Length(min=0, max=20, message="tel长度必须介于 0 和 20 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Length(min=0, max=200, message="email长度必须介于 0 和 200 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=11, message="role_id长度必须介于 0 和 11 之间")
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	@Length(min=0, max=11, message="community_id长度必须介于 0 和 11 之间")
	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}
	
	@Length(min=0, max=11, message="net_id长度必须介于 0 和 11 之间")
	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}
	
	@Length(min=0, max=11, message="dept_id长度必须介于 0 和 11 之间")
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

	public String getOtherdelFlag() {
		return otherdelFlag;
	}

	public void setOtherdelFlag(String otherdelFlag) {
		this.otherdelFlag = otherdelFlag;
	}

	public String getOtherclasstype() {
		return otherclasstype;
	}

	public void setOtherclasstype(String otherclasstype) {
		this.otherclasstype = otherclasstype;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNet0name() {
		return net0name;
	}

	public void setNet0name(String net0name) {
		this.net0name = net0name;
	}

	public String getNet1name() {
		return net1name;
	}

	public void setNet1name(String net1name) {
		this.net1name = net1name;
	}

	public String getNet2name() {
		return net2name;
	}

	public void setNet2name(String net2name) {
		this.net2name = net2name;
	}

	public String getNet3name() {
		return net3name;
	}

	public void setNet3name(String net3name) {
		this.net3name = net3name;
	}

	public String getNetName() {
		return netName;
	}

	public void setNetName(String netName) {
		this.netName = netName;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
}