package org.forten.sample.demo1;

// 一个类可以同时实现多个接口
public class Bird implements Flyable,Moveable {

	@Override
	public void fly() {
		System.out.println("小鸟飞在天上");
	}

	@Override
	public void run() {
		System.out.println("小鸟在陆地上行动");
	}

}
