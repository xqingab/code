package org.forten.sample.qo;

public class BookQo {
	private String name;
	private String author;
	private Integer type;

	private Integer pageNo;
	private Integer pageSize;

	private String orderField;
	private String orderType;

	public BookQo() {
		super();
		this.pageNo = 1;
		this.pageSize = 5;
		this.orderField = "id";
		this.orderType = "DESC";
	}

	public BookQo(String name, String author, Integer type) {
		this();
		this.name = name;
		this.author = author;
		this.type = type;
	}

	public BookQo(String name, String author, Integer type, Integer pageNo, Integer pageSize) {
		this();
		this.name = name;
		this.author = author;
		this.type = type;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public BookQo(String name, String author, Integer type, Integer pageNo, Integer pageSize, String orderField,
			String orderType) {
		super();
		this.name = name;
		this.author = author;
		this.type = type;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.orderField = orderField;
		this.orderType = orderType;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "BookQo [name=" + name + ", author=" + author + ", type=" + type + ", pageNo=" + pageNo + ", pageSize="
				+ pageSize + ", orderField=" + orderField + ", orderType=" + orderType + "]";
	}
}
