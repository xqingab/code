package org.forten.sample.enums;

// Java 1.5后可以声明枚举类型对象
// 使用enum关键字来声明枚举类，可以有实例变量、方法、构造方法
// 所有Java中的枚举类都是继承自Enum类的
// 但Java中的自定义枚举类不能被继承
// 枚举的用途：一般用于值会被限定在某些取值之中的数据上（类似于数据字典）
public enum Size {
	// 每一个变量其实都是这个枚举类型的一个实例对象
	// 它们都是public static final的，类型就是所在的enum类型（Size类型）
	// 因为在语法上规定了枚举类的构造方法一定是private的，所以在枚举类的外部不能new出它的对象实例
	// XS("超小号") =》 public static final Size XS = new Size("超小号");
	XS("超小号", 0.95), S("小号", 0.975), M("中号", 1.0), L("大号", 1.025), XL("超大号", 1.05), XXL("超超大号", 1.075), XXXL("超超超大号",
			1.1), XXXXL("超超超超大号", 1.125), XXXXXL("超超超超超大号", 1.15);

	private String desc;
	private double priceIndex;

	private Size(String desc, double priceIndex) {
		this.desc = desc;
		this.priceIndex = priceIndex;
	}

	public String getDesc() {
		return this.desc;
	}

	public double getPriceIndex() {
		return priceIndex;
	}
}
