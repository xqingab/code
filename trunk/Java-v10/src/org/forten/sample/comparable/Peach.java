package org.forten.sample.comparable;

public class Peach {
	private String name;
	private int weight;
	private String color;

	public Peach() {
		super();
	}

	public Peach(String name, int weight, String color) {
		super();
		this.name = name;
		this.weight = weight;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Peach [name=" + name + ", weight=" + weight + ", color=" + color + "]";
	}
}
