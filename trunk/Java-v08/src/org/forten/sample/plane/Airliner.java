package org.forten.sample.plane;

public class Airliner extends Plane {
	private int quantity;

	public Airliner() {
		super();
	}

	public Airliner(String name, int speed, int flyHeight, int quantity) {
		super(name, speed, flyHeight);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public void start() {
		System.out.println(name + "需要在很长很的跑道上助跑，然后起飞...");
	}

	@Override
	public void fly() {
		System.out.println(
				name + "的驾驶员打开自动巡航模式，以" + speed + "km/h的速度在" + flyHeight + "米的高空平稳飞行，飞机上有" + quantity + "名乘客...");
	}

	@Override
	public void land() {
		System.out.println(name + "需要在很长很的跑道上降落...");
	}

	@Override
	public String toString() {
		return "Airliner [quantity=" + quantity + ", name=" + name + ", speed=" + speed + ", flyHeight=" + flyHeight
				+ "]";
	}
}
