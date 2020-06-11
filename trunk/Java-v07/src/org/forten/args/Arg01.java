package org.forten.args;

public class Arg01 {
	public void changeValue(int x) {
		x = x * 2;
	}

	public void changeObject(Rec r) {
		r.setX(r.getX() * 10);
		r.setY(r.getY() * 10);
	}
	
	public void changeString(String str){
		str = "abc";
	}
	

	public static void main(String[] args) {
		Arg01 a1 = new Arg01();
		int x = 10;
		// 在Java中，参数的传递使用的是值传递方式，
		// 也就是说，把一个变量传递到方法参数时，会生成它的副本
		// 在方法内部对这个变量的使用其实是在使用它的副本，而方法外的变量本身的值不会被影响
		a1.changeValue(x);
		System.out.println(x);
		
		Rec r = new Rec(10, 5);
		System.out.println(r.getArea());
		// 在Java中，参数如果是引用类型，其传递方式还是值传递
		// 会生成原先对象引用的一个变量副本，值它们的值都是对某个对象的引用
		// 所以无论对哪个引用变量所引用的对象进行数据修改，另一变量也会共享结果
		a1.changeObject(r);
		System.out.println(r.getArea());
		
		String str = "123";
		a1.changeString(str);
		System.out.println(str);
	}
}
