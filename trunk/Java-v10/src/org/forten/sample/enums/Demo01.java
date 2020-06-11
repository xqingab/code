package org.forten.sample.enums;

public class Demo01 {

	public static void main(String[] args) {
		Clothes c1 = new Clothes("冲锋衣", 1400, Size.S);
		Clothes c2 = new Clothes("冲锋衣", 1400, Size.XXL);
		Clothes c3 = new Clothes("冲锋衣", 1400, Size.M);
		Clothes c4 = new Clothes("冲锋衣", 1400, Size.XXXXXL);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);

		// 枚举类的内置方法
		// values()方法会返回一个由某个枚举类中定义的所有枚举对象组成的一个数组
		// 数组元素的顺序由枚举类中枚举对象的定义顺序决定
		Size[] sizes = Size.values();
		for (Size size : sizes) {
			System.out.println(size);
		}

		// valueOf(String)方法可以按枚举对象的名称来得到其所对应的那个枚举对象
		// 如果字符串参数没有与枚举类型中的任何一个对象名称匹配，则会抛出java.lang.IllegalArgumentException
		Size size = Size.valueOf("S");
		System.out.println(size.getDesc() + ":" + size.getPriceIndex() + ":" + size);
		// size = Size.valueOf("NO");// 错误，会抛出java.lang.IllegalArgumentException
		
		// valueOf(Class<T>,String)方法可以按枚举的类型与名称得到所对应的那个枚举对象
		// Size.class实际参数代表Size这个类的类型对象
		size = Size.valueOf(Size.class, "XL");
		System.out.println(size.getDesc() + ":" + size.getPriceIndex() + ":" + size);
		
		// name()方法可以得到某个枚举对象的名称
		// ordinal()方法可以得到某个枚举对象的索引
		System.out.println(Size.XS.name()+"的索引是"+Size.XS.ordinal());
		System.out.println(Size.S.name()+"的索引是"+Size.S.ordinal());
		System.out.println(Size.M.name()+"的索引是"+Size.M.ordinal());
	}

}
