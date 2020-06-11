package org.forten.sample.emp;

public class Employee {
	// protected是一种访问修饰符，可以让子类访问到它所修饰的程序成员
	protected String name;
	protected int salary;

	public Employee() {
		super();
		System.out.println("Employee()");
	}

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
		System.out.println("Employee(String name, int salary)");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void work(){
		System.out.println("干活。。。");
	}

	public int getFinalSalary(){
		return salary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
}
