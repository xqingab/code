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
package org.forten.scss.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
@Entity
@Table(name = "SCSS_COURSE")
public class Course extends BaseEntity {
	private static final long serialVersionUID = -6057098184987928617L;

	@Column
	private String name;
	@Column(name = "TEACH_TIME")
	private String teachTime;
	@Column(name = "TEACHER_NAME")
	private String teacherName;
	@Column
	private int credit;

	// 被控方，mappedBy的含义是指明本方实体对象被主控方的哪个属性所保存
	@ManyToMany(mappedBy = "courseSet")
	private Set<User> userSet = new HashSet<User>();

	/**
	 * 
	 */
	public Course() {
		super();
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

	/**
	 * @return the userSet
	 */
	public Set<User> getUserSet() {
		return userSet;
	}

	/**
	 * @param userSet
	 *            the userSet to set
	 */
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [name=" + name + ", teachTime=" + teachTime
				+ ", teacherName=" + teacherName + ", credit=" + credit
				+ ", id=" + id + "]";
	}
}
