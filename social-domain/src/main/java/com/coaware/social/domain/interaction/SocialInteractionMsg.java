package com.coaware.social.domain.interaction;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.coaware.social.common.persistence.DataEntity;

/**
 * 消息Entity
 * @author Administrator
 * @version 2016-09-02
 */
public class SocialInteractionMsg extends DataEntity<SocialInteractionMsg> {
	
	private static final long serialVersionUID = 1L;
	private Integer from;		// 消息来源&mdash;&mdash;用户id
	private Integer to;		// 消息目标&mdash;&mdash;用户id
	private String message;		// 消息内容
	private Date time;		// 发送消息时间
	private Date readTime;		// 读取消息时间
	private String status;		// 消息状态：0：未读；1：已读；2：忽略
	private String msgType;		// 消息类型：0；私信；2：系统消息；以此类推
	
	public SocialInteractionMsg() {
		super();
	}

	public SocialInteractionMsg(Integer id){
		super(id);
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}
	
	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}
	
	@Length(min=0, max=1000, message="消息内容长度必须介于 0 和 1000 之间")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	
	@Length(min=0, max=2, message="消息状态：0：未读；1：已读；2：忽略长度必须介于 0 和 2 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=2, message="消息类型：0；私信；2：系统消息；以此类推长度必须介于 0 和 2 之间")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
}