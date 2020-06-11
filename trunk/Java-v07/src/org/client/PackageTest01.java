package org.client;

public class PackageTest01 {
	public static void main(String[] args) {
		// 可以使用包名加类名的方式（类的全限定名称）引用类
		// 优点：出错机率小
		// 缺点：代码量大
		org.forten.util.DateUtil du01 = new org.forten.util.DateUtil();
		du01.printDate();
		org.javalog.util.DateUtil du02 = new org.javalog.util.DateUtil();
		du02.printDate();
	}
}
