package com.crystal.SpringBootPractise.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.nio.charset.Charset;

@WebFilter(urlPatterns = "/**",description = "记录请求和响应日志")
@Slf4j
@Component
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //过滤掉静态资源请求
        //String resquest = IOUtils.toString(servletRequest.getInputStream(), "utf-8");
       log.info("请求日志:{}",servletRequest);
       filterChain.doFilter(servletRequest,servletResponse);
       log.info("响应日志:{}",servletResponse.getOutputStream());
    }
}
