package com.crystal.SpringBootPractise.controller;

import com.crystal.SpringBootPractise.domain.Balance;
import com.crystal.SpringBootPractise.service.IBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class MainController {
    @Autowired
    private IBalanceService balanceService;
    @GetMapping("/getTime")
    public String getTime(String name){
        String time = LocalDateTime.now().toString();
        log.info("应用日志:{}",name);
        return name+time;
    }
    @GetMapping("/getBalance")
    public Balance getBalance(){
       Balance balance = balanceService.getBalance(1);
       return balance;
    }
}
