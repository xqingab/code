package org.forten.sample.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 声明此类是一个Hibernate或JPA的实体类
@Entity
// 让此类与数据库中的某张表建立映射关系，如果表名与类名一致，可以省略(name="xxx")
@Table(name="test_user")
public class User {
	// 标有@Id的实例变量是主键，在一个实体类中有且仅有一个实例变量可以标@Id
	@Id
	// 指定实例变量对应数据表中的哪个字段，如果变量名与表中的字段名一致，可以省略(name="xxx")
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private String gender;
	@Column(name="hometown")
	private String hometown;
	@Column(name="birthday")
	private Date birthday;
	@Column(name="level")
	private int level;
	@Column(name="regist_time")
	private Date registTime;

	public User() {
		super();
		this.level = 1;
		this.registTime = new Date();
	}

	public User(String name, String gender, String hometown, Date birthday) {
		this();
		this.name = name;
		this.gender = gender;
		this.hometown = hometown;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public Date getRegistTime() {
		return registTime;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", hometown=" + hometown + ", birthday="
				+ birthday + ", level=" + level + ", registTime=" + registTime + "]";
	}
}
