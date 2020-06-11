package org.forten.sample.vo;

public class FastEditNameVo {
	private int id;
	private String name;

	public FastEditNameVo() {
		super();
	}

	public FastEditNameVo(int id, String name) {
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
		return "FastEditNameVo [id=" + id + ", name=" + name + "]";
	}
}
