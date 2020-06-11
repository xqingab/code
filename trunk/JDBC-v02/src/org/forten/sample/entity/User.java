package org.forten.sample.entity;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String gender;
	private Date birthday;
	private String password;
	private String email;
	private Date createTime;

	public User() {
		super();
	}

	public User(int id, String name, String gender, Date birthday, String password, String email, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.password = password;
		this.email = email;
		this.createTime = createTime;
	}

	public User(String name, String gender, Date birthday, String password, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.password = password;
		this.email = email;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", password="
				+ password + ", email=" + email + ", createTime=" + createTime + "]";
	}
}
