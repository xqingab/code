package org.forten.sample.dp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Agent implements InvocationHandler {
	// 被代理的对象
	private RentHouse rh;
	
	public Agent(RentHouse rh) {
		super();
		this.rh = rh;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("为客户找房客");
		System.out.println("与房客签租赁合同");
		// 以下语句是要执行被代理对象的真正业务方法
		method.invoke(rh, new Object[0]);
		System.out.println("从客户那里收取佣金");
		
		return null;
	}
}
