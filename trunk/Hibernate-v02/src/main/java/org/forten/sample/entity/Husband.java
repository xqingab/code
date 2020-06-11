package org.forten.sample.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="test_husband")
public class Husband implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="wife_id")
	private Wife wife;

	public Husband() {
		super();
	}

	public Husband(int id,String name, int age, Wife wife) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.wife = wife;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Husband other = (Husband) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Husband [id=" + id + ", name=" + name + ", age=" + age + ", wife=" + wife + "]";
	}
}
