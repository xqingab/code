package org.forten.sample.plane;

public class WarPlane extends Plane {
	private int loader;

	public WarPlane() {
		super();
	}

	public WarPlane(String name, int speed, int flyHeight, int loader) {
		super(name, speed, flyHeight);
		this.loader = loader;
	}

	public int getLoader() {
		return loader;
	}

	public void setLoader(int loader) {
		this.loader = loader;
	}

	@Override
	public void start() {
		System.out.println(name + "携带着" + loader + "导弹从航母上起飞");
	}

	@Override
	public void fly() {
		System.out.println(name + "携带着" + loader + "导弹在天空上寻找敌方目标");
	}

	@Override
	public void land() {
		System.out.println(name + "携带着" + loader + "导弹着陆到航母上");
	}

	public void attack() {
		System.out.println("哒哒哒...");
	}

	public void attack(int x) {
		if (loader >= x) {
			System.out.println(name + "向敌机发射了" + x + "枚导弹");
			loader = loader - x;
		} else {
			attack();
		}
	}

	@Override
	public String toString() {
		return "WarPlane [loader=" + loader + ", name=" + name + ", speed=" + speed + ", flyHeight=" + flyHeight + "]";
	}
}
