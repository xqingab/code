package org.forten.sample.model;

import org.forten.sample.model.annotation.NotEmpty;

public class Course {
	private String name;
	private String classroom;
	private String teachTime;
	private String teacher;

	public Course() {
		super();
	}

	public Course(String name, String classroom, String teachTime, String teacher) {
		super();
		this.name = name;
		this.classroom = classroom;
		this.teachTime = teachTime;
		this.teacher = teacher;
	}

	@NotEmpty(msg="课程的名字不可以为空")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty(msg="请指明上课地点")
	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classroom == null) ? 0 : classroom.hashCode());
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
		return "Course [name=" + name + ", classroom=" + classroom + ", teachTime=" + teachTime + ", teacher=" + teacher
				+ "]";
	}
}
