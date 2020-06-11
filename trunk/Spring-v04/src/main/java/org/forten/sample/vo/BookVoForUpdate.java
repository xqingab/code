package org.forten.sample.vo;

public class BookVoForUpdate {
	// 修改逻辑定义为：只可以修改书籍的名称、作者、出版社和价格
	// 因为id是要作为WHERE子句的条件的，所以也一定需要
	// 其它不允许修改的实例变量不可以在VoForUpdate中出现
	private int id;
	private String name;
	private String author;
	private String publisher;
	private double price;

	public BookVoForUpdate() {
		super();
	}

	public BookVoForUpdate(int id, String name, String author, String publisher, double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
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

	@Override
	public String toString() {
		return "BookVoForUpdate [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + "]";
	}
}
