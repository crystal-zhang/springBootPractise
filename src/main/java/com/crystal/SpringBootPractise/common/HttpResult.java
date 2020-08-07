package com.crystal.SpringBootPractise.common;

/**
 * controller统一返回对象
 * 
 * @author Administrator
 *
 */
@lombok.Data
public class HttpResult<T> {
	/**
	 * 返回数据
	 */
	private T Data;
	/**
	 * 是否成功标志位
	 */
	private boolean success;
	/**
	 * 响应码
	 */
	private String responseCode;
	/**
	 * 响应信息
	 */
	private String message;
}
