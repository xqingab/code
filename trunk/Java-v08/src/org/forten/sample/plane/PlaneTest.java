package org.forten.sample.plane;

public class PlaneTest {

	public static void main(String[] args) {
		Plane a1 = new Airliner("波音777", 800, 12000, 300);
		Plane w1 = new WarPlane("F22", 1200, 20000, 20);
		
		// 因为Plane这个类是抽象类，所以不可以被实例化为对象
		// Plane p = new Plane();// 错误
		
		a1.start();
		a1.fly();
		a1.land();

		w1.start();
		w1.fly();
		
		((WarPlane)w1).attack();
		((WarPlane)w1).attack(2);
		w1.land();
	}

}
