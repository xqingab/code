package org.forten.sample.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String author;
	@Column
	private String publisher;
	@Column
	private double price;
	@Column
	private double discount;
	@Column(name="pub_date")
	private Date pubDate;
	@Column(name="create_time")
	private Date createTime;

	public Book() {
		super();
		this.createTime = new Date();
	}

	public Book(String name, String author, String publisher, double price, double discount, Date pubDate) {
		this();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.discount = discount;
		this.pubDate = pubDate;
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
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", price="
				+ price + ", discount=" + discount + ", pubDate=" + pubDate + ", createTime=" + createTime + "]";
	}
}
