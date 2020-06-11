package org.forten.sample.qo;

public class SalaryQoForAdmin {
	private String name;
	private String month;

	public SalaryQoForAdmin() {
		super();
	}

	public SalaryQoForAdmin(String name, String month) {
		super();
		this.name = name;
		this.month = month;
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

	@Override
	public String toString() {
		return "SalaryQoForAdmin [name=" + name + ", month=" + month + "]";
	}
}
