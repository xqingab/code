package org.forten.sample.qo;

public class SalaryQoForUser {
	private String name;
	private String month;
	private Double finalSalary;

	public SalaryQoForUser() {
		super();
	}

	public SalaryQoForUser(String name, String month, Double finalSalary) {
		super();
		this.name = name;
		this.month = month;
		this.finalSalary = finalSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getFinalSalary() {
		return finalSalary;
	}

	public void setFinalSalary(Double finalSalary) {
		this.finalSalary = finalSalary;
	}

	@Override
	public String toString() {
		return "SalaryQoForUser [name=" + name + ", month=" + month + ", finalSalary=" + finalSalary + "]";
	}
}
