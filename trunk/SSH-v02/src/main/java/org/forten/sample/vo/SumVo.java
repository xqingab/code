package org.forten.sample.vo;

public class SumVo {
	private double sumJbgz;
	private double sumGwjt;
	private double sumYjj;
	private double sumYlbx;
	private double sumZfgjj;

	public SumVo() {
		super();
	}

	public SumVo(double sumJbgz, double sumGwjt, double sumYjj, double sumYlbx, double sumZfgjj) {
		super();
		this.sumJbgz = sumJbgz;
		this.sumGwjt = sumGwjt;
		this.sumYjj = sumYjj;
		this.sumYlbx = sumYlbx;
		this.sumZfgjj = sumZfgjj;
	}

	public double getSumJbgz() {
		return sumJbgz;
	}

	public void setSumJbgz(double sumJbgz) {
		this.sumJbgz = sumJbgz;
	}

	public double getSumGwjt() {
		return sumGwjt;
	}

	public void setSumGwjt(double sumGwjt) {
		this.sumGwjt = sumGwjt;
	}

	public double getSumYjj() {
		return sumYjj;
	}

	public void setSumYjj(double sumYjj) {
		this.sumYjj = sumYjj;
	}

	public double getSumYlbx() {
		return sumYlbx;
	}

	public void setSumYlbx(double sumYlbx) {
		this.sumYlbx = sumYlbx;
	}

	public double getSumZfgjj() {
		return sumZfgjj;
	}

	public void setSumZfgjj(double sumZfgjj) {
		this.sumZfgjj = sumZfgjj;
	}

	public double getFinalSalary() {
		return sumGwjt + sumJbgz + sumYjj - sumYlbx - sumZfgjj;
	}

	@Override
	public String toString() {
		return "SumVo [sumJbgz=" + sumJbgz + ", sumGwjt=" + sumGwjt + ", sumYjj=" + sumYjj + ", sumYlbx=" + sumYlbx
				+ ", sumZfgjj=" + sumZfgjj + "]";
	}
}
