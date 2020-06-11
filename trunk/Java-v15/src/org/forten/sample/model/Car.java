package org.forten.sample.model;

import org.forten.sample.model.annotation.NotEmpty;

public class Car {
	private String name;
	private int price;
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

	@NotEmpty(msg="汽车的名字不可以为空")
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + speed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", speed=" + speed + "]";
	}
}
