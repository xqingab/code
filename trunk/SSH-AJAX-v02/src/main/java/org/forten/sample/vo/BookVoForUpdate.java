package org.forten.sample.vo;

import java.util.Date;

public class BookVoForUpdate {
	private int id;
	private String name;
	private String author;
	private int type;
	private Date pubDate;
	private double price;
	private double discount;

	public BookVoForUpdate() {
		super();
	}

	public BookVoForUpdate(int id, String name, String author, int type, Date pubDate, double price, double discount) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.type = type;
		this.pubDate = pubDate;
		this.price = price;
		this.discount = discount;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
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
}
