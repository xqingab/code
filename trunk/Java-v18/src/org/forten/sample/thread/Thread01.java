package org.forten.sample.thread;

// 第一种实现自定义线程的方法
// 直接继承Thread类
public class Thread01 extends Thread {
	private String name;

	public Thread01(String name) {
		super();
		this.name = name;
	}

	// run()方法不能被程序直接调用，应该由CPU决定何时执行，表示线程进入运行状态
	// 如果要执行一条线程，程序员是没有任何办法的，只能使用start()方法让线程进入就绪状态
	// 线程何时执行由CPU的调度决定
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Thread01，名字是"+name);
		}
	}
}
