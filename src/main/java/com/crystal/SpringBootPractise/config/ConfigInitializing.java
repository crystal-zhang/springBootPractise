package com.crystal.SpringBootPractise.config;

import com.crystal.SpringBootPractise.service.IConfigPropertyService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 初始化系统参数
 */
@Component
public class ConfigInitializing implements InitializingBean {
    @Autowired
    private IConfigPropertyService configPropertyService;
    @Override
    public void afterPropertiesSet() throws Exception {
        //项目启动的时候从数据库加载系统参数
        configPropertyService.refreshConfig();
    }
}
