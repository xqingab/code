package org.forten.sample.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_book")
public class Book {
	@Id
	private int id;
	@Column
	private String name;
	@Column(name="pub_name")
	private String publisher;
	@Column
	private String author;
	@Column
	private double price;
	@Column(name="pub_date")
	private Date pubDate;
	@Column(name="create_time")
	private Date createTime;

	public Book() {
		super();
		this.createTime = new Date();
	}

	public Book(String name, String publisher, String author, double price, Date pubDate) {
		this();
		this.name = name;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.pubDate = pubDate;
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
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publisher=" + publisher + ", author=" + author + ", price="
				+ price + ", pubDate=" + pubDate + ", createTime=" + createTime + "]";
	}
}
