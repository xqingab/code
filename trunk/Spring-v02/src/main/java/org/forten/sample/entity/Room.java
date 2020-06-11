package org.forten.sample.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_room")
public class Room {
	@Id
	private int id;
	@Column
	private String title;
	@Column
	private int price;
	@Column
	private String tel;
	@Column(name="create_time")
	private Date createTime;

	public Room() {
		super();
		this.createTime = new Date();
	}

	public Room(String title, int price, String tel) {
		this();
		this.title = title;
		this.price = price;
		this.tel = tel;
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

	public int getId() {
		return id;
	}

	public Date getCreateTime() {
		return createTime;
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
		Room other = (Room) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", title=" + title + ", price=" + price + ", tel=" + tel + ", createTime="
				+ createTime + "]";
	}
}
