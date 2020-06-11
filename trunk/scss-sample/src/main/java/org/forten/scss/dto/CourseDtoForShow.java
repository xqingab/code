/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.forten.scss.dto;

import java.io.Serializable;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
public class CourseDtoForShow implements Serializable {
	private static final long serialVersionUID = 3015803634985769571L;

	private int id;
	private String name;
	private String teachTime;
	private String teacherName;
	private int credit;

	/**
	 * 
	 */
	public CourseDtoForShow() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param teachTime
	 * @param teacherName
	 * @param credit
	 */
	public CourseDtoForShow(int id, String name, String teachTime,
			String teacherName, int credit) {
		super();
		this.id = id;
		this.name = name;
		this.teachTime = teachTime;
		this.teacherName = teacherName;
		this.credit = credit;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the teachTime
	 */
	public String getTeachTime() {
		return teachTime;
	}

	/**
	 * @param teachTime
	 *            the teachTime to set
	 */
	public void setTeachTime(String teachTime) {
		this.teachTime = teachTime;
	}

	/**
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName
	 *            the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * @param credit
	 *            the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credit;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((teachTime == null) ? 0 : teachTime.hashCode());
		result = prime * result
				+ ((teacherName == null) ? 0 : teacherName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDtoForShow other = (CourseDtoForShow) obj;
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
		if (teacherName == null) {
			if (other.teacherName != null)
				return false;
		} else if (!teacherName.equals(other.teacherName))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseDtoForShow [id=" + id + ", name=" + name + ", teachTime="
				+ teachTime + ", teacherName=" + teacherName + ", credit="
				+ credit + "]";
	}
}
