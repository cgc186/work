package com.example.demo04;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo04.mapper")
@SpringBootApplication
public class Demo04Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo04Application.class, args);
    }

}
