package com.crystal.SpringBootPractise.controller;

import com.crystal.SpringBootPractise.dao.OrderDao;
import com.crystal.SpringBootPractise.domain.Balance;
import com.crystal.SpringBootPractise.domain.Order;
import com.crystal.SpringBootPractise.service.IBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class MainController {
    @Autowired
    private IBalanceService balanceService;
    @Autowired
    private OrderDao orderDao;
    @GetMapping("/getTime")
    public String getTime(String name){
        String time = LocalDateTime.now().toString();
        log.info("应用日志:{}",name);
        return name+time;
    }
    @GetMapping("/getBalance")
    public Balance getBalance(){
       Balance balance = balanceService.getBalance(1);
        log.info("查询结果:{}",balance);
       return balance;
    }

    @PostMapping("testSharding")
    public String testSharding(){
        Order order = null;
        for(long i=0;i<20;i++){
            order = new Order();
            order.setOrderId(i);
            order.setUserId(i);
            orderDao.addOrder(order);
        }
        return "success";
    }


    @PostMapping("getOrder")
    public List<Order> getOrder(){
        List<Order> list = orderDao.getOrderList();
        return list;
    }
}
