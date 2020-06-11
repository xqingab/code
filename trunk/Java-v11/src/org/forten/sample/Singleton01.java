package org.forten.sample;

// 饿汉单例模式
// 即时加载的，如果没有任何客户代码使用这个类的对象，也一定会生成这个类的单独对象实例
public class Singleton01 {
	private static final Singleton01 instance = new Singleton01();

	private Singleton01() {
		super();
	}

	public static Singleton01 getInstance() {
		return instance;
	}
}
