package org.forten.sample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.forten.utils.system.CurrentTimeKeyBuilder;

@Entity
@Table(name = "test_salary")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	@Column
	private String name;
	@Column
	private String month;
	@Column
	private double jbgz;
	@Column
	private double gwjt;
	@Column
	private double yjj;
	@Column
	private double ylbx;
	@Column
	private double zfgjj;

	public Salary() {
		super();
		this.id = CurrentTimeKeyBuilder.getInstance(1).nextPK();
	}

	public Salary(String name, String month, double jbgz, double gwjt, double yjj, double ylbx, double zfgjj) {
		this();
		this.name = name;
		this.month = month;
		this.jbgz = jbgz;
		this.gwjt = gwjt;
		this.yjj = yjj;
		this.ylbx = ylbx;
		this.zfgjj = zfgjj;
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

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", name=" + name + ", month=" + month + ", jbgz=" + jbgz + ", gwjt=" + gwjt
				+ ", yjj=" + yjj + ", ylbx=" + ylbx + ", zfgjj=" + zfgjj + "]";
	}
}
