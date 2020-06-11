package org.forten.statictest;

// 可以使用import static 包名.类名.static成员名;来引入static的变量、常量、方法等程序成员
// 即Java5以后加入的静态导入特性
import static org.forten.statictest.Box.NAME;

public class BoxTest {
	public static void main(String[] args) {
		Box b1 = new Box(10, 20, 15);
		System.out.println("当前有" + b1.getCount() + "个盒子");
		// 使用静态导入方式访问NAME常量
		System.out.println(NAME + "b1实例的表面积是" + b1.getArea());

		Box b2 = new Box(5, 10, 15);
		System.out.println("当前有" + b2.getCount() + "个盒子");
		// 不使用静态导入方式访问NAME常量
		System.out.println(Box.NAME + "b2实例的表面积是" + b2.getArea());
	}
}
