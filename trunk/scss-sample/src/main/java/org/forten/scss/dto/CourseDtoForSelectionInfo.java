package org.forten.scss.dto;

import java.io.Serializable;

public class CourseDtoForSelectionInfo implements Serializable {
	private static final long serialVersionUID = -3895424819608899359L;

	private String name = "name";
	private String teachTime;
	private String teacherName;
	private int credit;
	private String studentNames;
	private int studentCount;

	public CourseDtoForSelectionInfo() {
		super();
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(String studentNames) {
		this.studentNames = studentNames;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credit;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + studentCount;
		result = prime * result
				+ ((studentNames == null) ? 0 : studentNames.hashCode());
		result = prime * result
				+ ((teachTime == null) ? 0 : teachTime.hashCode());
		result = prime * result
				+ ((teacherName == null) ? 0 : teacherName.hashCode());
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
		CourseDtoForSelectionInfo other = (CourseDtoForSelectionInfo) obj;
		if (credit != other.credit)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (studentCount != other.studentCount)
			return false;
		if (studentNames == null) {
			if (other.studentNames != null)
				return false;
		} else if (!studentNames.equals(other.studentNames))
			return false;
		if (teachTime == null) {
			if (other.teachTime != null)
				return false;
		} else if (!teachTime.equals(other.teachTime))
			return false;
		if (teacherName == null) {
			if (other.teacherName != null)
				return false;
		} else if (!teacherName.equals(other.teacherName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourseDtoForSelectionInfo [name=" + name + ", teachTime="
				+ teachTime + ", teacherName=" + teacherName + ", credit="
				+ credit + ", studentNames=" + studentNames + ", studentCount="
				+ studentCount + "]";
	}
}
