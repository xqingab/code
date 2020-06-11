package org.forten.sample.vo;

public class UserAvgLevelVo {
	private String gender;
	private double avgLevel;

	public UserAvgLevelVo() {
		super();
	}

	public UserAvgLevelVo(String gender, double avgLevel) {
		super();
		this.gender = gender;
		this.avgLevel = avgLevel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getAvgLevel() {
		return avgLevel;
	}

	public void setAvgLevel(double avgLevel) {
		this.avgLevel = avgLevel;
	}

	@Override
	public String toString() {
		return "UserAvgLevelVo [gender=" + gender + ", avgLevel=" + avgLevel + "]";
	}
}
