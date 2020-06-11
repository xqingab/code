package org.forten.sample.vo;

import java.util.Date;

public class RoomVo {
	private int id;
	private String title;
	private int price;
	private String tel;
	private Date createTime;

	public RoomVo() {
		super();
	}

	public RoomVo(int id, String title, int price, String tel, Date createTime) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.tel = tel;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "RoomVo [id=" + id + ", title=" + title + ", price=" + price + ", tel=" + tel + ", createTime="
				+ createTime + "]";
	}
}
