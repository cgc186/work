package com.example.demo.controller;

import com.example.demo.code.LogAnno.LogAnno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class LogController {

	@LogAnno(operateType = "sayhello")
	@GetMapping("/hello")
	public void hello(){
		System.out.println("外部调用此方法!");
	}
}
