package com.crystal.SpringBootPractise.service.impl;

import com.crystal.SpringBootPractise.aop.AddLog;
import com.crystal.SpringBootPractise.dao.ProductDao;
import com.crystal.SpringBootPractise.domain.Balance;
import com.crystal.SpringBootPractise.dao.BalanceDao;
import com.crystal.SpringBootPractise.domain.Product;
import com.crystal.SpringBootPractise.service.IBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class BalanceServiceImpl implements IBalanceService {
    @Autowired
    private BalanceDao balanceDao;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    @AddLog(comment = "测试AOP")

    public Balance getBalance(int id) {
        return balanceDao.getBalance(1);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTrans() {
        Balance b = new Balance();
        b.setId(1);
        b.setUserBalance(new BigDecimal(900));

        kafkaTemplate.send("topic1","Kafka消息测试");

        balanceDao.updateBalance(b);
        int i = 1 / 0;

        Product p = new Product();
        p.setCount(15);
        p.setId(1);
        productDao.updateProduct(p);
    }
}
