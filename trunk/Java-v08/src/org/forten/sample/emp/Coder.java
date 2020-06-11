package org.forten.sample.emp;

public class Coder extends Employee {
	private int restDays;

	public Coder() {
		super();
	}

	public Coder(String name, int salary) {
		super(name, salary);
	}

	public Coder(String name, int salary, int restDays) {
		this(name, salary);
		this.restDays = restDays;
	}

	public int getRestDays() {
		return restDays;
	}

	public void setRestDays(int restDays) {
		this.restDays = restDays;
	}

	public int getFinalSalary() {
		return restDays * 8 * 6 + salary;
	}

	public int getBaseSalary() {
		// super.xxx或super.xxx()是super关键字的另一种用法
		// 它指代的是当前对象类型的父类，可以访问父类中可以访问的实例变量，也可以调用父类里的某个方法
		return super.getSalary();
		// return super.salary;
	}

	@Override
	public String toString() {
		return "程序员 [剩余调休天数：" + restDays + ", 姓名：" + name + ", 工资：" + salary + "]";
	}
}
