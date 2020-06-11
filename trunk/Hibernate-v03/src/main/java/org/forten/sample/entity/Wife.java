package org.forten.sample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_wife")
public class Wife implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	@OneToOne(mappedBy = "wife")
	private Husband husband;

	public Wife() {
		super();
	}

	public Wife(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
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
		Wife other = (Wife) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wife [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
