package org.forten.sample.vo;

import java.util.Date;

public class BookVo {
	private int id;
	private String name;
	private String author;
	private String publisher;
	private double price;
	private double discount;
	private Date pubDate;
	private Date createTime;

	public BookVo() {
		super();
	}

	public BookVo(int id, String name, String author, String publisher, double price, double discount, Date pubDate,
			Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.discount = discount;
		this.pubDate = pubDate;
		this.createTime = createTime;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getFinalPrice() {
		return price * discount * 0.1;
	}

	@Override
	public String toString() {
		return "BookVo [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", price="
				+ price + ", discount=" + discount + ", pubDate=" + pubDate + ", createTime=" + createTime
				+ ", getFinalPrice()=" + getFinalPrice() + "]";
	}
}
