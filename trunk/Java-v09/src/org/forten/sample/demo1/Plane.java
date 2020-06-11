package org.forten.sample.demo1;

public class Plane implements MoveFlyable {
	private String name;

	public Plane() {
		super();
	}

	public Plane(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fly() {
		System.out.println(name + "在天空中飞行");
	}

	@Override
	public void run() {
		System.out.println(name + "在跑道上滑行");
	}

	@Override
	public String toString() {
		return "Plane [name=" + name + "]";
	}

}
