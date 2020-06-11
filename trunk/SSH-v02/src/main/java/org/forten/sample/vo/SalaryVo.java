package org.forten.sample.vo;

public class SalaryVo {
	private long id;
	private String name;
	private String month;
	private double jbgz;
	private double gwjt;
	private double yjj;
	private double ylbx;
	private double zfgjj;

	public SalaryVo() {
		super();
	}

	public SalaryVo(long id, String name, String month, double jbgz, double gwjt, double yjj, double ylbx,
			double zfgjj) {
		super();
		this.id = id;
		this.name = name;
		this.month = month;
		this.jbgz = jbgz;
		this.gwjt = gwjt;
		this.yjj = yjj;
		this.ylbx = ylbx;
		this.zfgjj = zfgjj;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getJbgz() {
		return jbgz;
	}

	public void setJbgz(double jbgz) {
		this.jbgz = jbgz;
	}

	public double getGwjt() {
		return gwjt;
	}

	public void setGwjt(double gwjt) {
		this.gwjt = gwjt;
	}

	public double getYjj() {
		return yjj;
	}

	public void setYjj(double yjj) {
		this.yjj = yjj;
	}

	public double getYlbx() {
		return ylbx;
	}

	public void setYlbx(double ylbx) {
		this.ylbx = ylbx;
	}

	public double getZfgjj() {
		return zfgjj;
	}

	public void setZfgjj(double zfgjj) {
		this.zfgjj = zfgjj;
	}

	public double getFinalSalary() {
		return jbgz + gwjt + yjj - ylbx - zfgjj;
	}

	@Override
	public String toString() {
		return "SalaryVoForAdmin [id=" + id + ", name=" + name + ", month=" + month + ", jbgz=" + jbgz + ", gwjt="
				+ gwjt + ", yjj=" + yjj + ", ylbx=" + ylbx + ", zfgjj=" + zfgjj + "]";
	}
}
