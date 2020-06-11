package org.forten.sample.model;

import java.io.Serializable;

import org.forten.sample.model.annotation.NotEmpty;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String gender;
	private int age;

	public User() {
		super();
	}

	public User(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	@NotEmpty(msg = "姓名不可为空")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty(msg = "性别不可为空")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
}
