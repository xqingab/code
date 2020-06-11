package org.forten.sample.entity;

import java.util.Date;

public class Book {
	private int id;
	private String name;
	private String author;
	private String pubName;
	private double price;
	private Date pubDate;
	private Date createTime;

	public Book() {
		super();
		this.createTime = new Date();
	}

	public Book(int id, String name, String author, String pubName, double price, Date pubDate, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.pubName = pubName;
		this.price = price;
		this.pubDate = pubDate;
		this.createTime = createTime;
	}

	public Book(String name, String author, String pubName, double price, Date pubDate) {
		this();
		this.name = name;
		this.author = author;
		this.pubName = pubName;
		this.price = price;
		this.pubDate = pubDate;
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

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
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
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", pubName=" + pubName + ", price=" + price
				+ ", pubDate=" + pubDate + ", createTime=" + createTime + "]";
	}
}
