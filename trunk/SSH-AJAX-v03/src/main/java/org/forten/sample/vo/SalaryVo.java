package org.forten.sample.vo;

import java.util.Random;

public class SalaryVo {
	private String month;
	private int salary;

	public SalaryVo(String month) {
		super();
		this.month = month;
		Random random = new Random();
		this.salary = random.nextInt(5001) + 10000;
	}

	public String getMonth() {
		return month;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "SalaryVo [month=" + month + ", salary=" + salary + "]";
	}
}
