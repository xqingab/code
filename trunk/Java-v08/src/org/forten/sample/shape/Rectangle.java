package org.forten.sample.shape;

// 如果在class的声明时使用了final关键字，则这个类是最终类，不可以被扩展（不可以有子类了）
// final和abstract关键字无论修饰什么程序成员，都不可以同时出现，因为它们的作用是互斥的
public final class Rectangle extends Shape {
	private double x;
	private double y;

	public Rectangle(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String getName() {
		return "矩形";
	}

	@Override
	public double getArea() {
		return x * y;
	}

}
