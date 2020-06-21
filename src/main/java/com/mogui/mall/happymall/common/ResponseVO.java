package com.mogui.mall.happymall.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class ResponseVO implements Serializable{

	private static final long serialVersionUID = -1599411678301387889L;

	private int code = 0;
	
	private Object data = "";
	
	private String msg = "";
	
	private ResponseVO(){}
	
	public static ResponseVO build(){
		return new ResponseVO();
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public ResponseVO setData(Object data) {
		this.data = data == null ? "" : data;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResponseVO setMsg(String msg) {
		if(msg != null && !msg.trim().equals("")){
			this.code = 1;
			this.msg = msg;
		}
		return this;
	}
	
	public ResponseVO setMsg(int rtnCode, String msg) {
		this.code = rtnCode;
		this.msg = msg;
		return this;
	}
	
	public String toJSON(){
		return JSON.toJSONString(this);
	}

	@Override
	public String toString() {
		return "ResponseVO [code=" + code + ", data=" + data + ", msg=" + msg
				+ "]";
	}
	
	
}