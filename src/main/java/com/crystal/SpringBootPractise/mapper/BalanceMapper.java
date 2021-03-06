package com.crystal.SpringBootPractise.mapper;

import com.crystal.SpringBootPractise.domain.Balance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceMapper {
    Balance getBalance(@Param("id") int id);
}
