package com.explore.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
	
	
	
	@Pointcut("execution(* com.explore.spring.aop.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
	@Pointcut("execution(* com.explore.spring.aop.dao.*.get*(..))")
	public void getterMethods() {
		
	}
	
	@Pointcut("execution(* com.explore.spring.aop.dao.*.set*(..))")
	public void setterMethods() {
		
	}
	
	@Pointcut("(forDaoPackage() && !(getterMethods() || setterMethods() ))")
	public void forDAOPackageNoGetterAndSetter() {
		
	}
	
	
	@Before("forDAOPackageNoGetterAndSetter()")
	public void performLogging() {
	
		System.out.println(" ===> Performing Logging \n");
		
	}
	
	@Before("forDAOPackageNoGetterAndSetter()")
	public void performAPIAnalytics() {
		System.out.println(" ===> Performing API Analytics");
	}
	
	

}
