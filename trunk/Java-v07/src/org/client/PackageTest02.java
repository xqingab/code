package org.client;


// 使用import关键字可以引入本代码中要使用的其它包中的类
// 语法：import 类的全限定名;（一次引入一个类，从加载类的性能和代码的可读性方面考虑，推荐使用这种方式）
// 	   import 包1.包2.包n.*;（一次引入某个包下的所有类）
import org.forten.util.DateUtil;

public class PackageTest02 {

	public static void main(String[] args) {
		DateUtil du01 = new DateUtil();
		du01.printDate();
		
		
		// 如果在同一个类中要使用另一个与已经引入的类同名的类，则这个类必须使用全限定名称
		org.javalog.util.DateUtil du02 = new org.javalog.util.DateUtil();
		du02.printDate();

		// java.lang包下的所有类可以不用显式的引入
		String str = "Hahaha";
		// 同包的类可以不用显式的引入
		PackageTest01 pt1 = new PackageTest01();
		System.out.println(str);
	}

}
