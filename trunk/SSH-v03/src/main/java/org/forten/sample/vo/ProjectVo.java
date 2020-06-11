package org.forten.sample.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ProjectVo {
	private int id;
	@NotBlank(message="项目名称不可为空白")
	@Length(min=4,max=20,message="项目名称长度应该在{min}~{max}之间")
	private String name;

	public ProjectVo() {
		super();
	}

	public ProjectVo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "ProjectVo [id=" + id + ", name=" + name + "]";
	}
}
