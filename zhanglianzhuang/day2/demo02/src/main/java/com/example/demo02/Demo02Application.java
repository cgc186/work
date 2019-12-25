package com.example.demo02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = "com.example.demo02.dao")
//@MapperScan("com.example.demo02.service")
public class Demo02Application {
	public static void main(String[] args) {
			SpringApplication.run(Demo02Application.class, args);
	}

}
