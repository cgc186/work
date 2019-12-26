package com.example.demo.code.aop;

import com.example.demo.code.LogAnno.LogAnno;
import com.example.demo.code.commod.HttpContextUtil;
import com.example.demo.entity.Log;
import com.example.demo.mapper.LogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Order(3)
@Component
@Aspect
public class LogAopect{

       @Autowired
       private LogMapper logMapper;

 /**
  * 通过环形通知将自定义注解所调用的方法记录到数据库
  * @param pip
  * @return
  * @throws Throwable
  */
 @Around("@annotation(com.example.demo.code.LogAnno.LogAnno)")
 public Object aroundAdive(ProceedingJoinPoint pip)throws Throwable{
        //1.获取方法签名
        MethodSignature methodSignature=(MethodSignature)pip.getSignature();

        //2获取方法名称
        Method method = methodSignature.getMethod();

        //3.获取注解
        LogAnno logAnno =method.getAnnotation(LogAnno.class);

        //4.获取操作描述
        String operType=logAnno.operateType();

        //5.创建日志对象
        Log log =new Log();
        log.setOperation(operType);
        log.setUsername("wei");
        log.setIp(HttpContextUtil.getIpAddress());

        //6.方法获取
        String classname=pip.getTarget().getClass().getName();
        String method1=methodSignature.getName();
        log.setMethod(classname+"."+method1);

        //7.参数获取
        Object[] args=pip.getArgs();
        LocalVariableTableParameterNameDiscoverer u=new LocalVariableTableParameterNameDiscoverer();
        String[] parmName=u.getParameterNames(method);
        if(args!=null && parmName!=null){
         String parm="";
         for(int i=0;i<args.length;i++){
          parm+=" "+parmName[i]+":"+args[i];
         }
         log.setParms(parm);
        }

        //8.获取执行方法的时间
        Object result=null;
        try{
              long benginTime=System.currentTimeMillis();
              result =pip.proceed();  //执行调用接口的方法
              long endTime=System.currentTimeMillis()-benginTime;
              log.setTime(endTime);

        }catch (Exception e){

        }
        log.setCreatetime(new Date());
        //保存数据
        logMapper.insert(log);
        return result;


        }


}
