package org.forten.sample.model;

public class Bomb {
	private String name;
	private int weight;

	public Bomb() {
		super();
	}

	public Bomb(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Bomb [name=" + name + ", weight=" + weight + "]";
	}
}
