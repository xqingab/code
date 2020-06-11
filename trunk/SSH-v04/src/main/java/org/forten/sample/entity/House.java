package org.forten.sample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.forten.utils.system.CurrentTimeKeyBuilder;

@Entity
@Table(name="test_house")
public class House implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	@Column
	private String title;
	@Column
	private String address;
	@Column
	private int price;
	@Column
	private String tel;
	@Column
	private String type;
	@Column(name="img_url")
	private String imgUrl;

	public House() {
		super();
		this.id = CurrentTimeKeyBuilder.getInstance(1).nextPK();
	}

	public House(String title, String address, int price, String tel, String type, String imgUrl) {
		this();
		this.title = title;
		this.address = address;
		this.price = price;
		this.tel = tel;
		this.type = type;
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		House other = (House) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", title=" + title + ", address=" + address + ", price=" + price + ", tel=" + tel
				+ ", type=" + type + ", imgUrl=" + imgUrl + "]";
	}
}
