package com.example.demo03work.config

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MyBatisConfig {

//    @Bean
//    open fun configurationCustomizer(): ConfigurationCustomizer {
////        return ConfigurationCustomizer() {
////            @Override
////            fun customize(configuration: org.apache.ibatis.session.Configuration) {
////                configuration.isMapUnderscoreToCamelCase = true
////            }
////        }
//        return ConfigurationCustomizer(object : org.apache.ibatis.session.Configuration() {
//            override fun customize(configuration:org.apache.ibatis.session.Configuration) {
//                this.isMapUnderscoreToCamelCase = true
//            }
//        })
//    }
    @Bean
    open fun configurationCustomizer(): ConfigurationCustomizer? {
        return ConfigurationCustomizer { configuration -> configuration.isMapUnderscoreToCamelCase = true }
    }
}