package org.forten.sample.file;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	private String hometown;
	private String stuNo;

	public Student() {
		super();
	}

	public Student(String name, int age, String hometown, String stuNo) {
		super();
		this.name = name;
		this.age = age;
		this.hometown = hometown;
		this.stuNo = stuNo;
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((hometown == null) ? 0 : hometown.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stuNo == null) ? 0 : stuNo.hashCode());
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
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (hometown == null) {
			if (other.hometown != null)
				return false;
		} else if (!hometown.equals(other.hometown))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stuNo == null) {
			if (other.stuNo != null)
				return false;
		} else if (!stuNo.equals(other.stuNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", hometown=" + hometown + ", stuNo=" + stuNo + "]";
	}
}