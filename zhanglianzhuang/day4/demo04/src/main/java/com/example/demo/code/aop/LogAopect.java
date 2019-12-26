package com.example.demo.code.aop;

import com.example.demo.code.Command.HttpContextUtil;
import com.example.demo.code.LogAnno.LogAnno;
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

public class LogAopect {

	@Autowired
	private LogMapper logMapper;

	/**
	 * 通过环形通知将自定义注解所调用的方法记录到数据库
	 * @param pip
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(com.example.demo.code.LogAnno.LogAnno)")
	public Object aroundAdive(ProceedingJoinPoint pip) throws Throwable{
		//1.获取方法签名
		MethodSignature methodSignature=(MethodSignature)pip.getSignature();
		//2.获取方法名称
		Method method=methodSignature.getMethod();
		//3.获取注解
		LogAnno logAnno=method.getAnnotation(LogAnno.class);
		//4.获取注解描述
		String operType=logAnno.operateType();
		//5.创建日志对象
		Log log=new Log();
		log.setOperation(operType);

		log.setUsername("zzz");
		log.setIp(HttpContextUtil.getIpAddress());
		//6.方法获取
		String classname=pip.getTarget().getClass().getName();
		String method1=methodSignature.getName();
		log.setMethod(classname+"."+method1);
		//7.参数获取
		Object[] args=pip.getArgs();
		LocalVariableTableParameterNameDiscoverer u=new LocalVariableTableParameterNameDiscoverer();
		String[] parmName=u.getParameterNames(method);
		if (args != null && parmName != null) {
			String parm="";
			for (int i=0;i<args.length;i++){
				parm+=" "+parmName[i]+":"+args[i];
			}
			log.setParams(parm);
		}
		//8.获取执行方法的时间
		Object result=null;
		try {
			long beginTime=System.currentTimeMillis();
			result=pip.proceed();	//执行调用接口的方法
			long endTime=System.currentTimeMillis()-beginTime;
			log.setTime(endTime);
		}catch (Exception e){ }
		log.setCreatetime(new Date());
		//保存到数据库中
		logMapper.insert(log);
		return result;
	}
}
