package org.forten.sample.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component // 声明这个类是要被Spring管理的，这个类的对象是Spring容器中的一个Bean
@Aspect // 声明这个Bean是一个切面
public class LogAspect {
	@Before("execution(* *..*.bo.*Bo.*(..))")
	public void before(JoinPoint jp) {
		// 获得方法签名对象
		MethodSignature ms = (MethodSignature) jp.getSignature();
		// 通过方法签名对象获得方法对象
		Method method = ms.getMethod();
		System.out.println("准备执行" + method.getDeclaringClass().getName() + "." + method.getName() + "方法");
	}

	@After("execution(* *..*.bo.*Bo.do*(..))")
	public void after(JoinPoint jp) {
		MethodSignature ms = (MethodSignature) jp.getSignature();
		Method method = ms.getMethod();
		System.out.println("执行" + method.getDeclaringClass().getName() + "." + method.getName() + "方法完毕");
	}

	@AfterThrowing("execution(* *..*.bo.*Bo.*(..))")
	public void throwException() {
		System.out.println("执行方法出现异常");
	}

	@AfterReturning("execution(* *..*.bo.*Bo.query*(..))")
	public void returning() {
		System.out.println("方法返回值完毕");
	}
}
