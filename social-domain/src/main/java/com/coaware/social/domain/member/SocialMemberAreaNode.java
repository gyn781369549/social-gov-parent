package com.coaware.social.domain.member;

import java.util.ArrayList;
import java.util.List;

import com.coaware.social.common.persistence.DataEntity;
/**
 * 我的关注社区
 * @author Administrator
 *
 */
public class SocialMemberAreaNode {

	private String address;
	private List<SocialMemberAreaNode> childNodes= new ArrayList<SocialMemberAreaNode>();;
	private String grade;
	private String icon;
	private String id;
	private String name;
	private String pid;
	private String state;
	private String x;
	private String y;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<SocialMemberAreaNode> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<SocialMemberAreaNode> childNodes) {
		this.childNodes = childNodes;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	
}
