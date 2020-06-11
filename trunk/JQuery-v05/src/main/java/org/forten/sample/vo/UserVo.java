package org.forten.sample.vo;

import java.util.Date;

import org.forten.utils.common.DateUtil;

public class UserVo {
	private int id;
	private String name;
	private String tel;
	private Date birthday;

	public UserVo() {
		super();
	}

	public UserVo(int id, String name, String tel, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthdayStr() {
		if (birthday == null) {
			return "";
		}
		return DateUtil.convertDateToString(birthday,"yyyy年MM月dd日");
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + ", tel=" + tel + ", birthday=" + birthday + "]";
	}
}
