package org.forten.sample.entity;

public class User {
	private int id;
	private String name;
	private String password;
	private int roleName;

	public User() {
		super();
	}

	public User(int id, String name, String password, int roleName) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.roleName = roleName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleName() {
		return roleName;
	}

	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", roleName=" + roleName + "]";
	}
}
