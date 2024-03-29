package com.example.demo.code.LogAnno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 日志注解
 */
@Target(ElementType.METHOD)  //方法主键
@Retention(RetentionPolicy.RUNTIME)  //运行时可见
public @interface LogAnno {
    String operateType();
}
