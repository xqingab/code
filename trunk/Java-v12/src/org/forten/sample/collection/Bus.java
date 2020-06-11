package org.forten.sample.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Bus {

	public static void main(String[] args) {
		List<Person> bus = new ArrayList<>();
		Person p1 = new Person("Tom", 18);
		Person p2 = new Person("Mike", 48);
		Person p3 = new Person("Mary", 32);
		Person p4 = new Person("Jack", 28);
		Person p5 = new Person("Jone", 36);

		// 上车
		bus.add(p1);
		bus.add(p2);
		bus.add(p3);
		bus.add(p4);
		bus.add(p5);
		bus.add(new Person("Hellon", 12));

		for (Person person : bus) {
			System.out.println(person);
		}
		System.out.println("============================");

		// 第二个位置的人下车
		bus.remove(1);
		// p3这个对象下车
		bus.remove(p3);
		for (Person person : bus) {
			System.out.println(person);
		}
		System.out.println("============================");

		// 新上来一个人，坐到最后
		bus.add(new Person("小明", 16));
		// 上来一个人，坐到第四个位置，其它人向后错一个座位
		bus.add(3, new Person("小刚", 45));
		for (Person person : bus) {
			System.out.println(person);
		}
		System.out.println("============================");
		
		// 排序
		Collections.sort(bus);
		for (int i = 0; i < bus.size(); i++) {
			Person p = bus.get(i);
			System.out.println(p);
		}
		System.out.println("============================");
		
		// 倒序排序（注意：在使用reverse方法前一定要先调用sort方法）
		Collections.reverse(bus);
		Iterator<Person> it = bus.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
