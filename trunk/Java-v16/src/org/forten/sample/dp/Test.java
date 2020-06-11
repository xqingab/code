package org.forten.sample.dp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		// 真实的要被代理的对象（客户）
		RentHouse rh = new Customer("张辽");
		// 中间代理对象，只是对被代理对象进行了包装
		InvocationHandler proxy = new Agent(rh);
		
		// proxyRh是真正的代理对象
		RentHouse proxyRh = (RentHouse) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
				rh.getClass().getInterfaces(), proxy);
		
		proxyRh.rent();
	}

}
