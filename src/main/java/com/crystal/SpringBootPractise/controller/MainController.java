package com.crystal.SpringBootPractise.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class MainController {
    @GetMapping("/getTime")
    public String getTime(String name){
        String time = LocalDateTime.now().toString();
        log.info("应用日志:{}",name);
        return name+time;
    }
}
