package com.crystal.SpringBootPractise;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude  = DataSourceAutoConfiguration.class)
@EnableWebMvc
@MapperScan("com.crystal.SpringBootPractise.dao")
public class SpringBootPractiseApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootPractiseApplication.class, args);
	}

}
