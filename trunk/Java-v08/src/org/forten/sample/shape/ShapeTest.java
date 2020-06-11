package org.forten.sample.shape;

public class ShapeTest {

	public static void main(String[] args) {
		Shape s1 = new Square(5);
		Shape s2 = new Rectangle(10, 7);
		
		s1.printInfo();
		s2.printInfo();
	}

}
