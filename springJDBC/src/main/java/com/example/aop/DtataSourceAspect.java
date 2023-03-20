package com.example.aop;

import java.lang.reflect.Proxy;

import javax.sql.DataSource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;


@Component
@Aspect
public class DtataSourceAspect {
	
	
	@Around("target(javax.sql.DataSource)")
	public Object dataSourceConnectionIfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String name = proceedingJoinPoint.getSignature().getName();
		Object proceed = proceedingJoinPoint.proceed();
		System.out.println("DataSource Tracker: "+name);
		System.out.println("procced: "+proceed);
		
		
		
		return proceed;
	}
	
	
	

}
