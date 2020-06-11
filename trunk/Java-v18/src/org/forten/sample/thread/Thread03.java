package org.forten.sample.thread;

public class Thread03 implements Runnable {
	private boolean flag = true;

	// 线程的stop()方法用于中断线程的执行，但因为其实现方式有很大缺陷，所以已经被废弃了
	// 如果想中断线程的执行可以使用条件置位的方式来对线程进行中止操作
	@Override
	public void run() {
		while (true) {
			if (!flag) {
				break;
			}
			System.out.println("===Thread===");
		}
	}

	public void stop() {
		flag = false;
	}
}
