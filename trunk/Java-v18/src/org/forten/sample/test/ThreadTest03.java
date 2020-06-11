package org.forten.sample.test;

import org.forten.sample.thread.Thread02;

public class ThreadTest03 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread02("T1111111"));
		Thread t2 = new Thread(new Thread02("T2222222"));
		Thread t3 = new Thread(new Thread02("T2222222"));
		
		// 使用setPriority(int)方法可以设置线程的优先级
		// 1最低，10最高，5是默认优先级取值
		// 对线程优先级的设置，并不能保证高优先级的线程执行完成后才执行低优先级的线程
		// 次序还是主要由CPU决定，优先级的设置只不过是给CPU一个建议
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
