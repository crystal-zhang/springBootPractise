package com.crystal.SpringBootPractise.service.impl;

import com.crystal.SpringBootPractise.domain.Balance;
import com.crystal.SpringBootPractise.mapper.BalanceMapper;
import com.crystal.SpringBootPractise.service.IBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements IBalanceService {
    @Autowired
    private BalanceMapper balanceMapper;
    @Override
    public Balance getBalance(int id) {
        return balanceMapper.getBalance(1);
    }
}
