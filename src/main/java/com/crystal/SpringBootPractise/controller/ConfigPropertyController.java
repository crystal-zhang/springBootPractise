package com.crystal.SpringBootPractise.controller;

import com.crystal.SpringBootPractise.domain.ConfigProperty;
import com.crystal.SpringBootPractise.service.IConfigPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class ConfigPropertyController {
    @Autowired
    private IConfigPropertyService configPropertyService;

    /**
     * 刷新系统配置
     * @return
     */
    @GetMapping("/refresh")
    public String refreshConfig(){
        configPropertyService.refreshConfig();
        return "success";
    }

    /**
     * 查看系统配置
     * @return
     */
    @GetMapping("/getConfigList")
    public List<ConfigProperty> getConfigList(){
        List<ConfigProperty> result = configPropertyService.getList();
        return result;
    }

    /**
     * 更新系统配置
     * @param list
     * @return
     */
    @PostMapping("updateConfig")
    public String updateConfig(@RequestBody  List<ConfigProperty> list){
        return "success";
    }

    /**
     * 添加系统配置参数
     * @param list
     * @return
     */
    @PostMapping("addConfig")
    public String addConfig(@RequestBody  List<ConfigProperty> list){
        return "success";
    }


}
