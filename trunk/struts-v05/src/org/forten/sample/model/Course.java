package org.forten.sample.model;

public class Course {
	private int id;
	private String name;
	private String teachTime;
	private String teacher;
	private int credit;

	public Course() {
		super();
	}

	public Course(int id, String name, String teachTime, String teacher, int credit) {
		super();
		this.id = id;
		this.name = name;
		this.teachTime = teachTime;
		this.teacher = teacher;
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeachTime() {
		return teachTime;
	}

	public void setTeachTime(String teachTime) {
		this.teachTime = teachTime;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
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
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teachTime=" + teachTime + ", teacher=" + teacher + ", credit="
				+ credit + "]";
	}
}
