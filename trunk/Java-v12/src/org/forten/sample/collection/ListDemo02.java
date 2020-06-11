package org.forten.sample.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.forten.sample.model.Apple;
import org.forten.sample.model.Bomb;

public class ListDemo02 {
	public static void main(String[] args) {
		// 不使用泛型技术的容器有以下问题：
		// 1. 从容器中取得元素时，不得不进行向具体类型的强制转换
		// 2. 向容器中添加元素时，不能保证元素的类型安全
		Apple a1 = new Apple("富士", 300);
		Apple a2 = new Apple("国光", 120);
		Apple a3 = new Apple("蛇果", 230);
		Apple a4 = new Apple("黄香蕉", 320);
		Apple a5 = new Apple("红元帅", 400);

		// 在Java中通常是以更抽象的类型来声明变量，以具体的实现类来构造对象
		List bag = new ArrayList();

		bag.add(a1);
		bag.add(a2);
		bag.add(a3);
		bag.add(a4);
		bag.add(a5);
		// 在菜篮子里放了不安全的东西
		// 类型不安全
		// bag.add(new Bomb("TNT", 2000));

		for (Object object : bag) {
			Apple apple = (Apple) object;
			System.out.println(apple);
		}

		System.out.println("============================");

		// 使用泛型技术进行容器的声明*
		List<Apple> appleBag = new ArrayList<Apple>();
		appleBag.add(a1);
		appleBag.add(a2);
		appleBag.add(a3);
		appleBag.add(a4);
		appleBag.add(a5);
		// 禁止向苹果袋子中放炸弹
		// appleBag.add(new Bomb("TNT", 2000));

		// Java7以后，泛型对象的声明，在实例化实现类的语法里可以只使用<>，而省略其中的泛型类型
		// Java7中的钻石语法
		List<Bomb> bombBox = new ArrayList<>();
		bombBox.add(new Bomb("TNT", 2000));
		bombBox.add(new Bomb("飞毛腿", 20000));
		// 禁止向弹药箱中放水果
		// bombBox.add(a1);

		for (Bomb bomb : bombBox) {
			System.out.println(bomb);
		}

		System.out.println("============================");
		// 把一个List对象转型成为数组
		// 使用泛型的容器可以用toArray(T[] arr)的方法来得到T类型的数组对象
		// appleBag.toArray(new Apple[]{});// 推荐使用下边语句的写法，可以精确的生成要转换数组对象的容量
		Apple[] arr = appleBag.toArray(new Apple[appleBag.size()]);
		for (Apple apple : arr) {
			System.out.println(apple);
		}
		
		System.out.println("============================");
		// 数组转换成为List对象
		List<Apple> list = Arrays.asList(arr);
		for (Apple apple : list) {
			System.out.println(apple);
		}
		
		System.out.println("============================");
		List<Apple> newBag = Arrays.asList(a1,a2,a3,a4,a5,a1,a2,new Apple("大苹果",1000));
		for (Apple apple : newBag) {
			System.out.println(apple);
		}
	}
}
