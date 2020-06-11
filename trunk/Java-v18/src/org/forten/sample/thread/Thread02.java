package org.forten.sample.thread;

public class Thread02 implements Runnable {
	private String name;

	public Thread02(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Thread02，名字是" + name);
		}
	}

}
