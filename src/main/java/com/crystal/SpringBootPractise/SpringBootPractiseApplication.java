package com.crystal.SpringBootPractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.crystal.SpringBootPractise")
public class SpringBootPractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPractiseApplication.class, args);
	}

}
