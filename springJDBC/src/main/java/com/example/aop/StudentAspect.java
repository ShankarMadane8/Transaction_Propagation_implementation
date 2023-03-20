package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudentAspect {
	
	@Pointcut("within(com..Service.*) || within(com..dao.*)")
	public void studentPointCut() {
		
	}
	
//	@Before("studentPointCut()")
//	public void logBeforeMethodCall() {
//		System.out.println("method is starting..");
//	}
	
	
//	@After("studentPointCut()")
//	public void logAfterMethodCall() {
//		System.out.println("method is end..");
//	}
	
	

	@Around("studentPointCut()")
	public Object logAroundMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String name = proceedingJoinPoint.getSignature().getName();
		System.out.println("method start: "+name);
		Object object = proceedingJoinPoint.proceed();
		System.out.println(object);
		System.out.println("method end: "+name);
		//System.out.println("method is around..");
		return object;
	}
	
	
	

}
