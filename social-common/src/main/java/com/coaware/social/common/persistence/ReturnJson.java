package com.coaware.social.common.persistence;

import com.coaware.social.constants.enums.EmReturnCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(value = Include.ALWAYS)
public class ReturnJson {
	private String msg;
	private int retcode;
	private Object retObj;
	private boolean success;
	public final static ReturnJson Success = new ReturnJson("操作成功", EmReturnCode.SUCCESS.getValue(), null,true);
	public final static ReturnJson Faild = new ReturnJson("操作失败", EmReturnCode.SUCCESS.getValue(), null,false);


	public ReturnJson(String msg, int retcode, Object retObj,boolean success) {
		super();
		this.msg = msg;
		this.retcode = retcode;
		this.retObj = retObj;
		this.success = success;
	}
	
	public ReturnJson(String msg, Object retObj) {
		super();
		this.msg = msg;
		this.retcode = EmReturnCode.SUCCESS.getValue();
		this.retObj = retObj;
		this.success = true;
	}
	
	public ReturnJson(String msg,boolean success) {
		super();
		this.msg = msg;
		this.retcode = EmReturnCode.SUCCESS.getValue();
		this.retObj = null;
		this.success = success;
	}
	
	public ReturnJson(boolean success) {
		super();
		this.msg = "";
		this.retcode = EmReturnCode.SUCCESS.getValue();
		this.retObj = null;
		this.success = success;
	}

	public ReturnJson() {
		super();
	}

	public String getmsg() {
		return msg;
	}

	public void setmsg(String msg) {
		this.msg = msg;
	}

	public int getRetcode() {
		return retcode;
	}

	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}

	public Object getRetObj() {
		return retObj;
	}

	public void setRetObj(Object retObj) {
		this.retObj = retObj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public static ReturnJson getSuccess() {
		return Success;
	}

	public static ReturnJson getFaild() {
		return Faild;
	}

}
