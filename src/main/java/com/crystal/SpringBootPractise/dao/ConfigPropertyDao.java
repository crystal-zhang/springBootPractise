package com.crystal.SpringBootPractise.dao;

import com.crystal.SpringBootPractise.domain.ConfigProperty;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigPropertyDao {
    @Select("select * from config_property")
    List<ConfigProperty> getList();
}
