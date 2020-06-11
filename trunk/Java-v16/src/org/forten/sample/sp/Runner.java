package org.forten.sample.sp;

import java.util.Random;

public class Runner implements CanRun{
	private String name;

	public Runner() {
		super();
	}

	public Runner(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println(name + "正在冲向终点...");
		Random r = new Random();
		try {
			Thread.sleep((long) r.nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
