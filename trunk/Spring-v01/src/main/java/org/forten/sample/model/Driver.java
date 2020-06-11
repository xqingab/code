package org.forten.sample.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("d3")
public class Driver {
	@Value("徐晃")
	private String name;
	@Value("35")
	private int age;
	@Resource(name = "c3")
	// @Autowired
	private Car car;

	public Driver() {
		super();
	}

	public Driver(String name, int age, Car car) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void drive() {
		System.out.println(name + "正在驾驶" + car.getName());
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
