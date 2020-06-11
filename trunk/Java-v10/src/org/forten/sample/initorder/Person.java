package org.forten.sample.initorder;

// 对象数据的初始化顺序问题
// 1.静态部分（静态变量、静态常量、静态代码块）
// 2.非静态部分（实例变量、实例常量、非静态代码块）
// 3.构造方法（先父类后子类）
public class Person {
	// 静态变量的初始化和静态代码块会在类的字节码文件被装载时运行
	// 它们的执行顺序由代码中的定义顺序决定
	private static int count = 0;
	static{
		count =10;
		System.out.println("static block");
	}
	
	// 非静态变量的初始化和非静态代码块会在构造方法执行之前执行
	// 它们的执行顺序由代码中的定义顺序决定
	{
		this.name = "Tom";
		this.age=20;
		System.out.println("non-static block");
	}
	
	private String name = "Mike";
	private int age = 30;

	public Person() {
		super();
		System.out.println("Person()");
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("Person(x,y)");
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", count=" + count + "]";
	}

}
