package org.forten.sample.demo1;

public interface Moveable {
	// 在接口中声明的变量都是公有的静态常量（public static final，可以省略这些修饰符）
	String desc = "可移动的";
	// 在接口中声明的方法都是公有的抽象方法（public abstract，可以省略这些修饰符）
	// 在Java8以后，接口中可以包含一种被称为默认方法的方法，它可以有方法体
	void run();
	
	// 从Java8以后，可以为接口添加一种被称为默认方法的方法
	// 它可以有方法体（方法实现）
	// 用途：在程序的维护工作中，如果对接口进行方法的添加，在Java8前，只能声明抽象的方法
	// 这样会对既有的接口实现类造成很大影响
	// 如果使用默认方法，则可以把这种影响降到最小
	// 一定要得到此接口的实现类的实例对象，才可以调用default的方法
	default void fastRun(){
		System.out.println("快速行动");
	}
	
	// Java8以后，可以为接口添加一种被称为静态方法的方法
	// 没必要一定得到此接口的实现类的实例对象就可以调用static的方法
	// 通过“接口名.静态方法”的形式进行调用
	static void slowRun(){
		System.out.println("慢慢慢慢的.....");
	}
}
