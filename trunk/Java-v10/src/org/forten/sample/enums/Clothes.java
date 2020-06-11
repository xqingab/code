package org.forten.sample.enums;

public class Clothes {
	private String name;
	private double price;
	// private int size;
	private Size size;

	public Clothes() {
		super();
	}

	public Clothes(String name, double price, Size size) {
		super();
		this.name = name;
		this.price = price;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Clothes [name=" + name + ", price=" + Math.round((price * size.getPriceIndex())*100.0/100.0) + ", size=" + size.getDesc() + "]";
	}
}
