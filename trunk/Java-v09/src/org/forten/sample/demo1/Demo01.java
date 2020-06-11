package org.forten.sample.demo1;

public class Demo01 {

	public static void main(String[] args) {
		Moveable qq = new Car("QQ", 50);
		Moveable xm = new Person("小明", 15);
		
		qq.run();
		qq.fastRun();
		xm.run();
		
		MoveFlyable f22 = new Plane("F22");
		Flyable bird = new Bird();
		f22.run();
		f22.fly();
		bird.fly();
		
		Attackable qq2 = new Car("QQ2代", 180);
		qq2.attack();
	}

}
