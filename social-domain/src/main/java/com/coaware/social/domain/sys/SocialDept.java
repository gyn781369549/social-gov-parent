package com.coaware.social.domain.sys;

import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 部门Entity
 * @author Administrator
 * @version 2016-06-03
 */
public class SocialDept extends DataEntity<SocialDept> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String note;		// note
	private String connecter;		// connecter
	private String conphone;		// conphone
	private String leader;		// leader
	private String lphone;		// lphone
	private String address;		// address
	private Integer parentId;		// parent_id
	private String email;		// email
	
	private String smallnote;
	private String smalladdress;
	private String classtype;
	private String otherdelFlag;
	private String otherclasstype;
	public SocialDept() {
		super();
	}

	public SocialDept(Integer id){
		super(id);
	}

	@Length(min=0, max=100, message="name长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="note长度必须介于 0 和 255 之间")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Length(min=0, max=100, message="connecter长度必须介于 0 和 100 之间")
	public String getConnecter() {
		return connecter;
	}

	public void setConnecter(String connecter) {
		this.connecter = connecter;
	}
	
	@Length(min=0, max=20, message="conphone长度必须介于 0 和 20 之间")
	public String getConphone() {
		return conphone;
	}

	public void setConphone(String conphone) {
		this.conphone = conphone;
	}
	
	@Length(min=0, max=100, message="leader长度必须介于 0 和 100 之间")
	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	@Length(min=0, max=20, message="lphone长度必须介于 0 和 20 之间")
	public String getLphone() {
		return lphone;
	}

	public void setLphone(String lphone) {
		this.lphone = lphone;
	}
	
	@Length(min=0, max=500, message="address长度必须介于 0 和 500 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	@Length(min=0, max=150, message="email长度必须介于 0 和 150 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSmallnote() {
		return smallnote;
	}

	public void setSmallnote(String smallnote) {
		this.smallnote = smallnote;
	}

	public String getSmalladdress() {
		return smalladdress;
	}

	public void setSmalladdress(String smalladdress) {
		this.smalladdress = smalladdress;
	}

	
	
}