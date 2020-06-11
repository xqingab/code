package org.forten.sample.plane;

// 标有abstract关键字的类是抽象类
// 如果一个类中至少有一个抽象方法，则这个类必须是抽象类
// 如果一个类是抽象类，其中可以不包含任何抽象方法
// 抽象类不可以为实例化成为对象
public abstract class Plane {
	protected String name;
	protected int speed;
	protected int flyHeight;

	public Plane() {
		super();
	}

	public Plane(String name, int speed, int flyHeight) {
		super();
		this.name = name;
		this.speed = speed;
		this.flyHeight = flyHeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getFlyHeight() {
		return flyHeight;
	}

	public void setFlyHeight(int flyHeight) {
		this.flyHeight = flyHeight;
	}

	// 使用abstract关键字可以声明一个方法是抽象方法
	// 抽象方法没有方法的具体实现部分（方法体）
	// 在方法签名后直接以分号结束
	// 抽象方法的作用是声明一种高层的、抽象概念上的策略（算法的规范）
	// 具体的算法或逻辑由子类具体实现
	// 所有在抽象类中定义的抽象方法，必须在其子类中被实现，除非子类也是抽象类
	public abstract void start();

	public abstract void fly();

	public abstract void land();

	@Override
	public String toString() {
		return "Plane [name=" + name + ", speed=" + speed + ", flyHeight=" + flyHeight + "]";
	}
}
