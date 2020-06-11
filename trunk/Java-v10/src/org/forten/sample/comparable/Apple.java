package org.forten.sample.comparable;

public class Apple implements Comparable<Apple> {
	private String name;
	private int weight;
	private String color;

	public Apple() {
		super();
	}

	public Apple(String name, int weight, String color) {
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
		return "Apple [name=" + name + ", weight=" + weight + ", color=" + color + "]";
	}

	// 用于两个对象相比较的方法
	// 其中要定义对象的比较策略
	@Override
	public int compareTo(Apple that) {
		// if (this.weight < that.weight) {
		// return -1;
		// } else if (this.weight > that.weight) {
		// return 1;
		// } else {
		// return 0;
		// }

		// 本类的比较策略定义是重量大的对象算大
		// this所引用的对象的某个值如果比that所引用的对象的那个值大返回正值
		// this所引用的对象的某个值如果比that所引用的对象的那个值小返回负值
		// this所引用的对象的某个值如果与that所引用的对象的那个值相等返回零
		// 如果本类的比较策略定义变为重量大的对象算小
		// this所引用的对象的某个值如果比that所引用的对象的那个值大返回负值
		// this所引用的对象的某个值如果比that所引用的对象的那个值小返回正值
		// this所引用的对象的某个值如果与that所引用的对象的那个值相等返回零
		return this.weight - that.weight;// 重的算大
		// return -(this.weight - that.weight);// 重的算小
	}
}
