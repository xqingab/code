package org.forten.sample.qo;

public class NotebookQo {
	private String username;
	private String content;
	private Integer pageNo;
	private Integer pageSize;

	public NotebookQo() {
		super();
		this.pageNo = 1;
		this.pageSize = 10;
	}

	public NotebookQo(String username, String content) {
		this();
		this.username = username;
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "NotebookQo [username=" + username + ", content=" + content + ", pageNo=" + pageNo + ", pageSize="
				+ pageSize + "]";
	}
}
