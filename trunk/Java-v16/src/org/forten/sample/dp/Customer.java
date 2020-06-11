package org.forten.sample.dp;

public class Customer implements RentHouse {
	private String name;

	public Customer() {
		super();
	}

	public Customer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void rent() {
		System.out.println(name + "出租自己的房屋，拿月租金。");
	}
}
