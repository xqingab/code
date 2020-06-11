package org.forten.sample;

// 改进的懒汉单例模式
// 使用synchronized同步方法
public class Singleton03 {
	private static Singleton03 instance;
	
	private Singleton03(){
		
	}
	
	// synchronized关键字是同步时使用的
	// 被此关键字修饰的代码块在一个时间点上只允许一条线程进入，
	// 线程执行完毕后其它线程才可以使用被它修饰的代码块
	// 可以保证线程的安全
	// 但是，性能急剧下降
	public static synchronized Singleton03 getInstance(){
		if(instance == null){
			instance = new Singleton03();
		}
		return instance;
	}
}
