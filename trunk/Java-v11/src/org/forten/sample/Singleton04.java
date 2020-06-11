package org.forten.sample;

// 再次改进的懒汉单例模式（聪明的懒汉）
// 使用两次判空和同步块来保证在多线程征用静态方法时只有一个对象实例被生成
// 因为使用了volatile关键字，所以只有在Java 5以后才能使用这种写法
public class Singleton04 {
	private volatile static Singleton04 instance;
	
	private Singleton04(){
		
	}
	
	public static Singleton04 getInstance(){
		if(instance==null){
			synchronized (Singleton04.class) {
				if(instance==null){
					instance = new Singleton04();
				}
			}
		}
		return instance;
	}
}
