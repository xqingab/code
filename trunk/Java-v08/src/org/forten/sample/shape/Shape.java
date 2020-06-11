package org.forten.sample.shape;

// 这个包中的代码是模板方法模式的一种实现
// 是面向对象设计原则中开闭原则的实践
// final和abstract关键字无论修饰什么程序成员，都不可以同时出现，因为它们的作用是互斥的
public abstract class Shape {
	// 模板方法
	// 这个具体方法是不变的逻辑步骤
	public void printInfo(){
		System.out.println(getName()+"的面积是"+getArea());
	}
	
	// 抽象方法的逻辑是不稳定的
	// 不同的子类一般会有各自的实现逻辑
	// 所以在父类中我们把这种行为定义为抽象的，让它们到子类中去具体实现
	public abstract String getName();
	public abstract double getArea();
}
