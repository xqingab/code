package org.forten.sample.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.forten.sample.model.Apple;

public class MapDemo01 {

	public static void main(String[] args) {
		Apple a1 = new Apple("富士", 300);
		Apple a2 = new Apple("国光", 120);
		Apple a3 = new Apple("蛇果", 230);
		Apple a4 = new Apple("黄香蕉", 320);
		Apple a5 = new Apple("红元帅", 400);

		Map<Integer, Apple> appleMap = new HashMap<>();

		// 添加条目
		// 如果一个map中没有put方法中所传入的key
		// 则进行条目的添加
		appleMap.put(1, a1);
		appleMap.put(2, a2);
		appleMap.put(3, a3);
		appleMap.put(4, a4);
		appleMap.put(5, a5);

		System.out.println(appleMap);

		// 替换条目
		// 如果一个map中已经存在put方法中所传入的key
		// 则进行条目的替换
		appleMap.put(3, new Apple("假苹果", 50));
		System.out.println(appleMap);

		// replace(key,oldV,newV)方法：
		// 当map中的键值对与key和oldV完全一致时才会把值替换成newV
		// 否则不做任何操作
		appleMap.replace(2, a5, new Apple("塑料苹果",5));
		System.out.println(appleMap);
		appleMap.replace(2, a2, new Apple("塑料苹果",5));
		System.out.println(appleMap);
		
		// putIfAbsent(k,v)方法可以比较安全的进行条目的添加
		// 在添加条目前会进行判断，如果key已经在map中存在
		// 则不添加（即不会像put方法一样进行key所对应值的替换）
		// 如果key不在map中存在，则会添加
		appleMap.putIfAbsent(2, new Apple("橡胶苹果",150));
		System.out.println(appleMap);
		appleMap.putIfAbsent(6, new Apple("橡胶苹果",150));
		System.out.println(appleMap);
		
		// 通过get(k)方法，按照key得到相应的value
		System.out.println(appleMap.get(5));
		
		// getOrDefault(key,defaultObj)用于获得一个key所对象的value
		// 当key不存在于map中时，会返回defaultObj对象（默认值）
		// 而当key存在，而value=null时，会返回null
		System.out.println(appleMap.getOrDefault(10, new Apple("意念中的苹果",-10)));
		appleMap.put(10,null);
		System.out.println(appleMap.getOrDefault(10, new Apple("意念中的苹果",-10)));
		System.out.println(appleMap);
		
		// 通过containsKey(key)判断一个map中是否存在参数key
		System.out.println(appleMap.containsKey(10));
		System.out.println(appleMap.containsKey(100));
		
		// 通过containsValue(value)判断一个map中是否存在参数value
		System.out.println(appleMap.containsValue(new Apple("橡胶苹果",150)));
		System.out.println(appleMap.containsValue(a1));
		System.out.println(appleMap.containsValue(new Apple("橡胶苹果果",150)));
		
		// 按map中的key进行元素遍历
		// 通过keySet()方法可以得到map中所有key组成的一个Set容器
		Set<Integer> keySet = appleMap.keySet();
		System.out.println(keySet);
		// 通过遍历key组成的Set容器得到每个key及它所对应的值
		for (Integer key : keySet) {
			System.out.println(key+":"+appleMap.get(key));
		}
		
		// 按map中的Entry进行元素遍历
		// 通过entrySet()方法可以得到map中所有entry组成的一个Set容器
		Set<Entry<Integer, Apple>> entrySet = appleMap.entrySet();
		System.out.println(entrySet);
		// 通过遍历entry组成的Set容器，得到所有条目对象（键值对）
		// 通过entry类型对象的getkey()和getValue()方法可以分别得到每个条目的key和value
		for (Entry<Integer, Apple> entry : entrySet) {
			System.out.println(entry.getKey()+"=>"+entry.getValue());
		}
	}

}
