package com.crystal.SpringBootPractise;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@MapperScan("com.crystal.SpringBootPractise.dao")
@EnableKafka
public class SpringBootPractiseApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootPractiseApplication.class, args);
	}

}
