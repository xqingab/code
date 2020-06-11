package ${basePackage}.vo;

public class UserVoForLogin {
	private long id;
	private String name;
	private String roleName;

	public UserVoForLogin() {
		super();
	}

	public UserVoForLogin(long id, String name, String roleName) {
		super();
		this.id = id;
		this.name = name;
		this.roleName = roleName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "UserVoForLogin [id=" + id + ", name=" + name + ", roleName="
				+ roleName + "]";
	}
}
