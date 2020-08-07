package com.crystal.SpringBootPractise.common;

import lombok.Data;

/**
 * 响应码枚举
 * 
 * @author Administrator
 *
 */
public enum ResultCode {
	SUCCESS("000", "响应成功!"), SYSTEM_ERROR("111", "系统错误!"), INVALID_PARAM("222", "参数校验异常"),
	MISTYPE_PARAM("333", "参数格式有误"), MISSING_PARAM("444", "缺少参数"), UNSUPPORTED_METHOD("555","不支持的请求类型");
	private ResultCode(String code, String message) {
		this.code = code;
		this.message = message;
	};

	private String code;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
