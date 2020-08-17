package com.crystal.SpringBootPractise.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.crystal.SpringBootPractise.common.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;



/**
 * 统一异常处理
 * 
 * @author Administrator
 *
 */
/*@RestControllerAdvice*/
@Slf4j
public class GlobalExceptionHandler  {
	@Autowired
	private HttpServletRequest request;

	/**
	 * 异常日志记录
	 * 
	 * @param e
	 */
	private void logErrorRequest(Exception e) {
		String info = String.format("报错API URL: %s%nQuery String: %s", request.getRequestURI(),
				request.getQueryString());
		log.error(info);
		log.error(e.getMessage(), e);
		String ipInfo = "报错访问者IP信息：" + request.getRemoteAddr() + "," + request.getRemoteHost();
		log.error(ipInfo);
	}

	/**
	 * 参数校验异常
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected HttpResult methodArgumentNotValid(MethodArgumentNotValidException exception) {
		logErrorRequest(exception);
		HttpResult<String> result = new HttpResult<>();
		return result;
	}

	/**
	 * 参数格式有误
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class })
	protected HttpResult typeMismatch(Exception exception) {
		logErrorRequest(exception);
		HttpResult<String> result = new HttpResult<>();
		return result;
	}
	/**
	 * 缺少参数
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	protected HttpResult missingServletRequestParameter(MissingServletRequestParameterException exception) {
	    logErrorRequest(exception);
	    HttpResult<String> result = new HttpResult<>();
	    return result;
	}

	/**
	 * 不支持的请求类型
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected HttpResult httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
	    logErrorRequest(exception);
		HttpResult<String> result = new HttpResult<>();
		return result;
	}

	/**
	 * 业务层异常
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(ServiceEx.class)
	protected HttpResult serviceException(ServiceEx exception) {
	    logErrorRequest(exception);
		HttpResult<String> result = new HttpResult<>();
		return result;
	}



}
