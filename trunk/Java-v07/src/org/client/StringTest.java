package org.client;

public class StringTest {

	public static void main(String[] args) {
		String s1 = "abc";// 在串池不存在"abc"，生成一个
		String s2 = "abc";// 在串池里已经存在"abc"，共享
		String s3 = new String("abc");// 在堆里生成一个内容是"abc"的字符串对象
		String s4 = new String("abc");// 在堆里生成一个内容是"abc"的字符串对象

		System.out.println(s1 == s2);// true，共享串池中的同一个对象"abc"
		System.out.println(s3 == s4);// false，堆中的两块独立对象空间
		System.out.println(s1 == s3);// false，串池中的一个对象与堆中的一个对象，引用不等
		
		System.out.println(s1.equals(s2));
		System.out.println(s3.equals(s4));
		System.out.println(s1.equals(s3));
		
		System.out.println("==============================");
		
		s3 = s3.intern();
		System.out.println(s1 == s3);// true，intern()方法会把s3的内容共享到串池，并返回
		System.out.println(s1 == s4);// false，s4没有调用intern()方法，所以它引用的字符串对象还在普通的堆内存中
	}

}
