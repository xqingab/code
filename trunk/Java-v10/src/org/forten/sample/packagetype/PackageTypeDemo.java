package org.forten.sample.packagetype;

public class PackageTypeDemo {

	public static void main(String[] args) {
		byte b1 = 1;// 基本数据类型中的byte类型
		Byte b2 = new Byte(b1);
		Byte b3 = new Byte("100");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b3+b2);
		// Byte类型可以表示的最小值
		System.out.println(Byte.MIN_VALUE);
		// Byte类型可以表示的最大值
		System.out.println(Byte.MAX_VALUE);
		// Byte类型数据占用的字节数
		System.out.println(Byte.SIZE);
		// parseByte(String)把一个字符串类型的数字转型成为byte类型
		System.out.println(Byte.parseByte("10")+Byte.parseByte("100"));
		// parseByte(String,int)把一个字符串类型的数字转型成为byte类型的十进制数，第二个参数说明了字符串数字的进制数
		System.out.println(Byte.parseByte("10000",2));
		System.out.println(Byte.parseByte("11",8));
		System.out.println(Byte.parseByte("1f",16));
		
		// valueOf方法与parseByte类似，只是返回类型不同
		// parseByte返回的是基本数据类型byte
		// valueOf返回的是基本数据类型包装类的对象（Byte）
		System.out.println(Byte.valueOf("10"));
		
		// 使用xxxValue()方法可以把Byte的对象转型成为xxx的基本数据类型
		System.out.println(b2.intValue());
		
		// byte => Byte
		// short => Short
		// int => Integer
		// long => Long
		// float => Float
		// double => Double
		// boolean => Boolean
		// char => Character
		
	}

}
