package org.forten.sample.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c3")
public class Car {
	@Value("路虎")
	private String name;
	@Value("1000000")
	private int price;
	@Value("180")
	private int speed;

	public Car() {
		super();
	}

	public Car(String name, int price, int speed) {
		super();
		this.name = name;
		this.price = price;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", speed=" + speed + "]";
	}
}
