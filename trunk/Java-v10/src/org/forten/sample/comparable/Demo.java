package org.forten.sample.comparable;

import java.util.Arrays;
import java.util.Comparator;

public class Demo {

	public static void main(String[] args) {
		Apple a1 = new Apple("富士", 300, "红");
		Apple a2 = new Apple("黄香蕉", 200, "黄");
		Apple a3 = new Apple("蛇果", 230, "红");
		Apple a4 = new Apple("国光", 100, "青");
		Apple a5 = new Apple("红元帅", 400, "红");

		Apple[] apples = { a1, a2, a3, a4, a5 };

		for (Apple apple : apples) {
			System.out.println(apple);
		}
		
		// Arrays是Java提供的一个专门操作数组对象的工具类
		// 其中的sort方法会对传递来的数组进行排序
		// 要求这个数组的元素类型一定要实现java.lang.Comparable接口
		// 否则会抛出java.lang.ClassCastException
		Arrays.sort(apples);
		System.out.println("-----------------------");
		for (Apple apple : apples) {
			System.out.println(apple);
		}
		
		Peach p1 = new Peach("大久保", 530, "红");
		Peach p2 = new Peach("小久保", 380, "红");
		Peach p3 = new Peach("蟠桃", 180, "粉");
		Peach p4 = new Peach("黄桃", 230, "黄");
		Peach p5 = new Peach("水蜜桃", 300, "粉");
		
		Peach[] peaches = {p1,p2,p3,p4,p5};
		System.out.println("-----------------------");
		for (Peach peach : peaches) {
			System.out.println(peach);
		}
		
		PeachComparator pc  = new Demo().new PeachComparator();
		Arrays.sort(peaches,pc);
		System.out.println("-----------------------");
		for (Peach peach : peaches) {
			System.out.println(peach);
		}
		
		// 匿名内部内，没有类名，匿名内部类的对象只在这行语句中使用一次
		Arrays.sort(peaches,new Comparator<Peach>() {
			@Override
			public int compare(Peach o1, Peach o2) {
				return o2.getWeight()-o1.getWeight();
			}
		});
		System.out.println("-----------------------");
		for (Peach peach : peaches) {
			System.out.println(peach);
		}
	}

	// 如果某些逻辑要封装到类中，而这个类又只有在有限的类型对象中才被使用，就可以把这个类定义为一个嵌套类
	// 符合面向对象的封装思想
	private class PeachComparator implements Comparator<Peach>{

		@Override
		public int compare(Peach o1, Peach o2) {
			return o1.getWeight()-o2.getWeight();
		}
		
	}
}
