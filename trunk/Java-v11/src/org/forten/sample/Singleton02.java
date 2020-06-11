package org.forten.sample;

// 懒汉单例模式
// 正常情况下懒汉单例模式比饿汉单例模式要更科学
// 但在多线程并发调用这个类中的静态方法时，可能出现多个实例的生成
public class Singleton02 {
	private static Singleton02 instance;
	
	private Singleton02(){
		
	}
	
	public static Singleton02 getInstance(){
		if(instance == null){
			instance = new Singleton02();
		}
		return instance;
	}
}
