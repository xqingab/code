package org.forten.sample.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.forten.sample.model.Apple;

public class SetDemo01 {

	public static void main(String[] args) {
		Apple a1 = new Apple("富士", 300);
		Apple a2 = new Apple("国光", 120);
		Apple a3 = new Apple("蛇果", 230);
		Apple a4 = new Apple("黄香蕉", 320);
		Apple a5 = new Apple("红元帅", 400);
		
		// List容器中可以放置若干相等的元素对象
		List<Apple> appleBag = new ArrayList<>();
		appleBag.add(a1);
		appleBag.add(a2);
		appleBag.add(a3);
		appleBag.add(a4);
		appleBag.add(a5);
		appleBag.add(a1);
		appleBag.add(a2);
		appleBag.add(a3);
		appleBag.add(a4);
		appleBag.add(a5);
		appleBag.add(a1);
		appleBag.add(a2);
		appleBag.add(a3);
		appleBag.add(a4);
		appleBag.add(a5);
		
		// 如果多个相等对象放置到同一个Set容器中
		// Set容器只会存储一份此对象，Set是不允许有重复的元素的
		
		// 如何判断一个要被添加到Set中的对象是否已经存在于Set中？
		// 调用要添加对象的hashCode()方法，与Set中的每个元素对象的hashCode()方法运行结果相比较
		// 如果没有任何元素与此对象的hashCode一致，则表示此对象没有被添加到Set中，可以进行进行添加
		// 如果有一个元素与此对象的hashCode一致，调用对象的equals()方法来进行进一步的判断
		// 如果equals()返回true则不添加此对象
		// 否则继续比较下一个元素
		Set<Apple> appleSet = new HashSet<>();
		appleSet.add(a1);
		appleSet.add(a2);
		appleSet.add(a3);
		appleSet.add(a4);
		appleSet.add(a5);
		appleSet.add(a1);
		appleSet.add(a2);
		appleSet.add(a3);
		appleSet.add(a4);
		appleSet.add(a5);
		appleSet.add(a1);
		appleSet.add(a2);
		appleSet.add(a3);
		appleSet.add(a4);
		appleSet.add(a5);
		
		System.out.println(appleBag.size());
		System.out.println(appleSet.size());
		
		// Set的两种遍历方式，因为Set是无序的，所以比List少了一种按index遍历的方式
		// Set在一般概念上来说是无序的，所以遍历的顺序与添加元素的顺序可能不同
		System.out.println("============================");
		Iterator<Apple> it = appleSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("============================");
		for (Apple apple : appleSet) {
			System.out.println(apple);
		}
		
		// TreeSet是一种可安排的Set，其中的元素必须实现Comparable<T>接口
		// 遍历时是按Comparable<T>的实现逻辑进行升序排序的
		Set<Person> bus = new TreeSet<>();
		bus.add(new Person("Tom1",18));
		bus.add(new Person("Tom2",28));
		bus.add(new Person("Tom3",8));
		System.out.println("============================");
		for (Person per : bus) {
			System.out.println(per);
		}
	}

}
