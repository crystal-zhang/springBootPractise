package com.crystal.SpringBootPractise.service;

import com.crystal.SpringBootPractise.domain.ConfigProperty;

import java.util.List;

public interface IConfigPropertyService {
    void refreshConfig();
    List<ConfigProperty> getList();
}
