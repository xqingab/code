package org.forten.sample.vo;

public class HouseVo {
	private long id;
	private String title;
	private String address;
	private int price;
	private String tel;
	private String type;
	private String imgUrl;

	public HouseVo() {
		super();
	}

	public HouseVo(long id, String title, String address, int price, String tel, String type, String imgUrl) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
		this.price = price;
		this.tel = tel;
		this.type = type;
		this.imgUrl = imgUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "HouseVo [id=" + id + ", title=" + title + ", address=" + address + ", price=" + price + ", tel=" + tel
				+ ", type=" + type + ", imgUrl=" + imgUrl + "]";
	}
}
