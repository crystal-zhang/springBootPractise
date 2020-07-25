package com.crystal.SpringBootPractise.service.impl;

import com.crystal.SpringBootPractise.config.GlobalConstant;
import com.crystal.SpringBootPractise.dao.ConfigPropertyDao;
import com.crystal.SpringBootPractise.domain.ConfigProperty;
import com.crystal.SpringBootPractise.service.IConfigPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ConfigPropertyServiceImpl implements IConfigPropertyService {
    @Autowired
    private ConfigPropertyDao configPropertyDao;
    @Override
    public void refreshConfig() {
        List<ConfigProperty> list = configPropertyDao.getList();
        list.forEach(e->{
            if("1".equalsIgnoreCase(e.getType())){
                GlobalConstant.CONSTANT_STRING_MAP.put(e.getCode(),e.getValue());
            }else{
                GlobalConstant.CONSTANT_LIST_MAP.put(e.getCode(),Arrays.asList(e.getValue().split(","))) ;
            }
        });
    }

    @Override
    public List<ConfigProperty> getList() {
        return configPropertyDao.getList();
    }


}
