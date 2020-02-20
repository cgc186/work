package com.example.demo03work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.demo03work.mapper")
@MapperScan("com.example.demo03work.dao")
@SpringBootApplication
public class Demo03workApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo03workApplication.class, args);
    }

}
