package com.example.demo04.code.aop


import com.example.demo04.code.command.HttpContextUtil
import com.example.demo04.code.logAnno.LogAnno
import com.example.demo04.entity.Log
import com.example.demo04.mapper.LogMapper
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.LocalVariableTableParameterNameDiscoverer
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

import java.util.*

@Order(3)
@Component
@Aspect
class LogAopect {

    @Autowired
    lateinit var logMapper :LogMapper

    /**
     * 通过环形通知将自定义注解所调用的方法记录到数据库
     * @return
     * @throws Throwable
     */
    @Throws(Throwable::class)
    @Around("@annotation(com.example.demo04.code.logAnno.LogAnno)")
    fun around(pip: ProceedingJoinPoint): Any {
        //1.获取方法签名
        val methodSignature = pip.signature as MethodSignature

        //2.获取方法名称
        val method = methodSignature.method

        //3.获取注解
        val logAnno:LogAnno = method.getAnnotation(LogAnno::class.java)

        //4.获取注解描述
        val openType :String = logAnno.operateType

        //5.创建日志对象
        val log = Log()
        log.operation = openType

        log.username = "cgc"
        log.ip = HttpContextUtil.getIpAddress()
        //方法获取
        val classname = pip.target.javaClass.name
        val method1 = methodSignature.name
        log.method = "$classname.$method1"

        //参数获取
        val args = pip.args
        val u = LocalVariableTableParameterNameDiscoverer()
        val paramName = u.getParameterNames(method)
        if (paramName != null && args != null) {
            var param = ""
            for (i in args.indices) {
                param += " " + paramName[i] + ":" + args[i]
            }
            log.params = param
        }

        //获取执行方法的时间
        var result: Any = Any()
        try {
            val beginTime = System.currentTimeMillis()
            result = pip.proceed()
            val endTime = System.currentTimeMillis() - beginTime
            log.time = endTime
        } catch (e: Exception) {

        }
        log.createTime = Date()

        logMapper.insert(log)

        return result
    }
}