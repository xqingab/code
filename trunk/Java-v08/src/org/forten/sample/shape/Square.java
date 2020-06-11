package org.forten.sample.shape;

public class Square extends Shape {
	private double x;

	public Square(double x) {
		super();
		this.x = x;
	}

	@Override
	public String getName() {
		return "正方形";
	}

	@Override
	public double getArea() {
		return x * x;
	}

}
