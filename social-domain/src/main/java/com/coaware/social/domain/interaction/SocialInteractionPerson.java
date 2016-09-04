package com.coaware.social.domain.interaction;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 议员表Entity
 * @author Administrator
 * @version 2016-08-26
 */
public class SocialInteractionPerson extends DataEntity<SocialInteractionPerson> {
	
	private static final long serialVersionUID = 1L;
	private Integer parliamentId;		// 居民议事会表id
	private Date time;		// 创建时间
	private String content;		// 简要说明
	private String type;		// 职位类型
	private String name;		// 名字
	private String phone;		// 手机
	private String pic;		// 头像
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public SocialInteractionPerson() {
		super();
	}

	public SocialInteractionPerson(Integer id){
		super(id);
	}

	@NotNull(message="居民议事会表id不能为空")
	public Integer getParliamentId() {
		return parliamentId;
	}

	public void setParliamentId(Integer parliamentId) {
		this.parliamentId = parliamentId;
	}
	
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Length(min=0, max=255, message="简要说明长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}