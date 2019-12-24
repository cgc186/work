package com.example.demo.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket applicationApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("fak")
                .select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()).build()
                .apiInfo(appicationInfo());
    }

    private ApiInfo appicationInfo(){
        val apiInfo=new ApiInfo(title:"接口管理"
        ,description:"api接口说明"
        ,version:"0.1"
        ,termsOfServiceUrl：""
        ,new Contact(name:"ma",url:"",email:"")
        ,license:"连接显示文字"
        ,licenseUrl:"");
        return apiInfo;
    }
}
