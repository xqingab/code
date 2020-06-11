package org.forten.sample;

public class StaticFactory {
	private String name;
	private int age;
	private String hometown;

	private StaticFactory(String name, int age, String hometown) {
		super();
		this.name = name;
		this.age = age;
		this.hometown = hometown;
	}

	// 静态工厂方法模式
	// 与构造方法相比，优点在于：
	// 1.可以使用方法名称提高生成对象特性的详细描述
	// 2.可以返回本类型及其子类的对象，而构造方法只能返回本类对象
	public static StaticFactory getInstance(String name, int age, String hometown) {
		return new StaticFactory(name, age, hometown);
	}

	// 静态工厂方法模式
	public static StaticFactory getBeijingPerson(String name, int age) {
		return new StaticFactory(name, age, "北京");
	}

	// 静态工厂方法模式
	public static StaticFactory getYoungPerson(String name, String hometown) {
		return new StaticFactory(name, 18, hometown);
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	@Override
	public String toString() {
		return "StaticFactory [name=" + name + ", age=" + age + ", hometown=" + hometown + "]";
	}
}
