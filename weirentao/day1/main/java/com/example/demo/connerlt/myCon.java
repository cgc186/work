package com.example.demo.connerlt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import  java.util.concurrent.Executor;
@Configuration//该类为启用配置信息
@EnableAsync//开启异步事件的注解

public class myCon {

    //配置执行任务的相关值
    private int corePoolSize=10;
    private int maxPoolSize=200;
    private int queueCapactiy=10;
    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapactiy);
        executor.initialize();
        return executor;
    }
}
