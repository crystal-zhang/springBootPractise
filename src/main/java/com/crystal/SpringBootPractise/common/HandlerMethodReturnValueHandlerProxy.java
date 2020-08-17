package com.crystal.SpringBootPractise.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class HandlerMethodReturnValueHandlerProxy implements org.springframework.web.method.support.AsyncHandlerMethodReturnValueHandler {
    private HandlerMethodReturnValueHandler proxyHandler;

    public HandlerMethodReturnValueHandlerProxy(HandlerMethodReturnValueHandler proxyHandler) {
        this.proxyHandler = proxyHandler;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return proxyHandler.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("responseCode", "0");
        map.put("message", "操作成功");
        map.put("data", returnValue);
        proxyHandler.handleReturnValue(map, returnType, mavContainer, webRequest);

    }

    @Override
    public boolean isAsyncReturnValue(Object returnValue, MethodParameter returnType) {
        return false;
    }
}
