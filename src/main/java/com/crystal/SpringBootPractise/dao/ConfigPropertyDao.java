package com.crystal.SpringBootPractise.dao;

import com.crystal.SpringBootPractise.domain.ConfigProperty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigPropertyDao {
    List<ConfigProperty> getList();
}
