package org.forten.sample.vo;

import java.util.Date;

public class BookVo {
	private int id;
	private String name;
	private String publisher;
	private String author;
	private double price;
	private Date pubDate;
	private Date createTime;

	public BookVo() {
		super();
	}

	public BookVo(int id, String name, String publisher, String author, double price, Date pubDate, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "BookVo [id=" + id + ", name=" + name + ", publisher=" + publisher + ", author=" + author + ", price="
				+ price + ", pubDate=" + pubDate + ", createTime=" + createTime + "]";
	}
}
