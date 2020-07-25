package com.crystal.SpringBootPractise.service.impl;

import com.crystal.SpringBootPractise.aop.AddLog;
import com.crystal.SpringBootPractise.domain.Balance;
import com.crystal.SpringBootPractise.dao.BalanceDao;
import com.crystal.SpringBootPractise.service.IBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements IBalanceService {
    @Autowired
    private BalanceDao balanceMapper;
    @Override
    @AddLog(comment = "测试AOP")
    public Balance getBalance(int id) {
        return balanceMapper.getBalance(1);
    }
}
