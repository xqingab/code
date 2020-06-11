package org.forten.sample;

// Java5以后提供的enum类就是原生的单例（多例）模式的实现
// 以下就是一个使用enum类编写的单例类
public enum Singleton05 {
	INSTANCE;
	// 除了生成单个实例对象外，还可以生成数量可控的多个实例
	// INSTANCE1,INSTANCE2;
	
	// 可以有自己的业务方法
	public void test(){
		
	}
}
