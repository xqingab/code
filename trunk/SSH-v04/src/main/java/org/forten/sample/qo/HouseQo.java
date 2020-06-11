package org.forten.sample.qo;

public class HouseQo {
	private String title;
	private String address;
	private String type;
	private Integer minPrice;
	private Integer maxPrice;

	private Integer pageNo;
	private Integer pageSize;

	public HouseQo() {
		super();
		this.pageNo = 1;
		this.pageSize = 3;
	}

	public HouseQo(String title, String address, String type, Integer minPrice, Integer maxPrice) {
		this();
		this.title = title;
		this.address = address;
		this.type = type;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
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
		return "HouseQo [title=" + title + ", address=" + address + ", type=" + type + ", minPrice=" + minPrice
				+ ", maxPrice=" + maxPrice + ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}
}
