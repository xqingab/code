package org.forten.sample.test;

import org.forten.sample.thread.Thread01;

public class ThreadTest01 {

	public static void main(String[] args) {
		Thread01 t1 = new Thread01("T1");
		Thread01 t2 = new Thread01("T2");
		Thread01 t3 = new Thread01("T3");
		
		// 以下三条语句是让三个线程对象进入就绪状态
		// 而执行的顺序是由CPU来调度的
		// 所以每次执行顺序都可能不同
		t1.start();
		t2.start();
		t3.start();
	}

}
