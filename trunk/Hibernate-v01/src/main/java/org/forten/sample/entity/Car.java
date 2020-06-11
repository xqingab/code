package org.forten.sample.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_car")
public class Car {
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String color;
	@Column
	private int price;
	@Column
	private int speed;
	@Column(name="pro_date")
	private Date proDate;

	public Car() {
		super();
	}

	public Car(String name, String color, int price, int speed, Date proDate) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.speed = speed;
		this.proDate = proDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public Date getProDate() {
		return proDate;
	}

	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", speed=" + speed
				+ ", proDate=" + proDate + "]";
	}
}
