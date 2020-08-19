package com.crystal.SpringBootPractise.dao;

import com.crystal.SpringBootPractise.domain.Balance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceDao {
    Balance getBalance(@Param("id") int id);

    void updateBalance(Balance balance);
}
