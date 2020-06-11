package org.forten.sample.test;

import org.forten.sample.thread.Thread02;

public class ThreadTest02 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread02("T1111111"));
		Thread t2 = new Thread(new Thread02("T2222222"));
		
		// 如果线程类中的run()方法逻辑不会被重用，则没必要定义外部线程类
		// 通常比较喜欢使用匿名内部类来完成此情况下的线程逻辑编写
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("=");
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}

}
