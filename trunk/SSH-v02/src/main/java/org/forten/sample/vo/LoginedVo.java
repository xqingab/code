package org.forten.sample.vo;

public class LoginedVo {
	private int id;
	private String name;
	private String roleName;

	public LoginedVo() {
		super();
	}

	public LoginedVo(int id, String name, String roleName) {
		super();
		this.id = id;
		this.name = name;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public boolean isAdminRole(){
		return this.roleName.equals("A");
	}

	@Override
	public String toString() {
		return "LoginedVo [id=" + id + ", name=" + name + ", roleName=" + roleName + "]";
	}
}
