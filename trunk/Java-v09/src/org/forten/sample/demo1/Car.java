package org.forten.sample.demo1;

public class Car implements Moveable, Attackable {
	private String name;
	private int speed;

	public Car() {
		super();
	}

	public Car(String name, int speed) {
		super();
		this.name = name;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void run() {
		System.out.println(name + "以" + speed + "km/h的速度行驶");
	}

	@Override
	public void fastRun() {
		System.out.println(name + "以" + (speed * 2) + "km/h的速度高速行驶");
	}

	public void attack() {
		System.out.println(name + "以" + (speed * 20) + "km/h的速度冲撞对方");
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + "]";
	}

}
