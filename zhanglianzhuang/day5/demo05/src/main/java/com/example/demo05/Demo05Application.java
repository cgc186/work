package com.example.demo05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class Demo05Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo05Application.class, args);
	}

}
