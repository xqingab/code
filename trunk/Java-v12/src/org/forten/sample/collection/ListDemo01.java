package org.forten.sample.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.forten.sample.model.Apple;

public class ListDemo01 {

	public static void main(String[] args) {
		// Java 5之前容器的使用方式
		// 当时没有泛型技术，无论是否知道容器中的元素的确切类型，在取得元素时，它们都会成为Object类型的
		// 后续需要对得到的元素进行手动的向下转型
		
		Apple a1 = new Apple("富士", 300);
		Apple a2 = new Apple("国光", 120);
		Apple a3 = new Apple("蛇果", 230);
		Apple a4 = new Apple("黄香蕉", 320);
		Apple a5 = new Apple("红元帅", 400);
		
		// 在Java中通常是以更抽象的类型来声明变量，以具体的实现类来构造对象
		List bag = new ArrayList();
		
		// 通过add(obj)方法向容器中追加元素
		bag.add(a1);
		bag.add(a2);
		bag.add(a4);
		bag.add(a5);
		
		// 通过add(index,obj)方法向容器中的第index索引位置插入一个元素
		bag.add(2, a3);
		System.out.println(bag);
		// 通过size()方法得到容器中的元素数量
		System.out.println(bag.size());
		
		// 通过get(index)方法可以得到某个索引值所对应的元素对象
		Apple secondApple = (Apple) bag.get(1);
		// 通过get(size()-1)可以得到容器中的最后一个元素对象
		Apple lastApple = (Apple) bag.get(bag.size()-1);
		System.out.println(secondApple);
		System.out.println(lastApple);
		
		// 通过remove(index)可以移除容器中的第index索引处的元素
		bag.remove(2);
		System.out.println(bag);
		// 通过remove(obj)可以把第一个obj对象从容器中移除
		bag.remove(a1);
		System.out.println(bag);
		
		// List中的元素可以重复
		bag.add(a1);
		bag.add(a1);
		bag.add(a1);
		System.out.println(bag);
		// 即使在容器中有若干个重复的对象，remove(obj)方法的一次调用也只能移除第一个obj，而不是移除全部obj
		bag.remove(a1);
		System.out.println(bag);
		
		// 通过set(index,obj)方法来替换index索引位置上的元素对象为obj
		// 用obj对象覆盖了容器中index对应的原有对象
		bag.set(3, a3);
		System.out.println(bag);
		
		System.out.println("============================");
		
		// 遍历List容器中所有元素的第一种方式
		// 利用元素索引来进行遍历
		for (int i = 0; i < bag.size(); i++) {
			Apple apple = (Apple) bag.get(i);
			System.out.println(apple);
		}
		
		System.out.println("============================");
		// 遍历List容器中所有元素的第二种方式
		// 利用迭代器来进行遍历
		Iterator it = bag.iterator();
		// hasNext()方法判断当前被迭代的容器是否还有下一个元素
		while(it.hasNext()){
			// next()方法会把迭代器的元素指针指向下一个元素并返回
			Apple apple = (Apple) it.next();
			System.out.println(apple);
		}
		
		System.out.println("============================");
		// 遍历List容器中所有元素的第三种方式
		// 利用增强for循环语法进行遍历
		// for(当前循环所要取出的那个元素对象的引用 : 要被遍历的容器)
		for (Object obj : bag) {
			Apple apple = (Apple) obj;
			System.out.println(apple);
		}

		System.out.println("============================");
		// 把一个List对象转型成为数组
		// 使用Java5以前的转换方法，只能得到Object类型的数组
		Object[] arr = bag.toArray();
		for (Object object : arr) {
			Apple apple = (Apple) object;
			System.out.println(apple);
		}
		
		System.out.println("============================");
		// 数组转换成为List对象
		List list = Arrays.asList(arr);
		for (Object object : list) {
			Apple apple = (Apple) object;
			System.out.println(apple);
		}
	}

}
