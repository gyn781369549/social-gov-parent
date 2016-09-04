/**
 * 
 */
package com.coaware.social.common.persistence;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.coaware.social.common.utils.CookieUtils;
import com.coaware.social.common.utils.StringUtils;
import com.coaware.social.common.web.Servlets;
import com.coaware.social.constants.web.CookieConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 数据Entity类
 * @author Administrator
 * @version 2015-09-16
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	protected String remarks;	// 备注
	protected String createBy;	// 创建者
	protected Date createDate;	// 创建日期
	protected String updateBy;	// 更新者
	protected Date updateDate;	// 更新日期
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核；3：禁用）
 
	
	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public DataEntity(Integer id) {
		super(id);
	}
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert(){
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord){
			//setId(IdGen.uuid());
		}
		String userId = CookieUtils.getCookie(Servlets.getRequest(), CookieConsts.COOKIE_USER_ID);
		if(StringUtils.isNotBlank(userId)){
			this.createBy = userId;
			this.updateBy = userId;
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate(){
		this.updateBy = CookieUtils.getCookie(Servlets.getRequest(), CookieConsts.COOKIE_USER_ID);
		this.updateDate = new Date();
	}
	
	@Length(min=0, max=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
 

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

 
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	//@JsonIgnore
	@Length(min=1, max=1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
