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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
@Entity
@Table(name = "SCSS_USER")
public class User extends BaseEntity {
	private static final long serialVersionUID = 3744637384069132313L;

	@Column
	private String name;
	@Column
	private String password;
	@Column
	private String type;
	@ManyToMany(cascade = CascadeType.ALL)
	// @JoinTable中的name是定义双方实体的中间关联表的名称;joinColumns中的JoinColumn定义的是本方ID在中间表中被存储的字段;inverseJoinColumns中的JoinColumn定义的是对方ID在中间表中被存储的字段
	@JoinTable(name = "SCSS_USER_COURSE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	private Set<Course> courseSet = new HashSet<Course>();

	/**
	 * 
	 */
	public User() {
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the courseSet
	 */
	public Set<Course> getCourseSet() {
		return courseSet;
	}

	/**
	 * @param courseSet
	 *            the courseSet to set
	 */
	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}

	public void addCourse(Course course) {
		this.courseSet.add(course);
	}

	public void removeCourse(Course course) {
		this.courseSet.remove(course);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", type="
				+ type + ", id=" + id + "]";
	}

}
