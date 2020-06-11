package org.forten.sample.entity;

import java.util.Date;

public class Course {
	private int id;
	private String name;
	private String classroom;
	private String teacher;
	private Date teachTime;
	private int credit;

	public Course() {
		super();
	}

	public Course(int id, String name, String classroom, String teacher, Date teachTime, int credit) {
		super();
		this.id = id;
		this.name = name;
		this.classroom = classroom;
		this.teacher = teacher;
		this.teachTime = teachTime;
		this.credit = credit;
	}

	public Course(String name, String classroom, String teacher, Date teachTime, int credit) {
		super();
		this.name = name;
		this.classroom = classroom;
		this.teacher = teacher;
		this.teachTime = teachTime;
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

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Date getTeachTime() {
		return teachTime;
	}

	public void setTeachTime(Date teachTime) {
		this.teachTime = teachTime;
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
		result = prime * result + ((classroom == null) ? 0 : classroom.hashCode());
		result = prime * result + credit;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teachTime == null) ? 0 : teachTime.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
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
		if (classroom == null) {
			if (other.classroom != null)
				return false;
		} else if (!classroom.equals(other.classroom))
			return false;
		if (credit != other.credit)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teachTime == null) {
			if (other.teachTime != null)
				return false;
		} else if (!teachTime.equals(other.teachTime))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", classroom=" + classroom + ", teacher=" + teacher
				+ ", teachTime=" + teachTime + ", credit=" + credit + "]";
	}
}
