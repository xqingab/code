package org.forten.sample.vo;

import java.util.Date;

public class NotebookVoForAdmin {
	private int id;
	private String username;
	private String content;
	private Date createTime;

	public NotebookVoForAdmin() {
		super();
	}

	public NotebookVoForAdmin(int id, String username, String content, Date createTime) {
		super();
		this.id = id;
		this.username = username;
		this.content = content;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getShortContent(){
		if(this.content.trim().length()>15){
			return this.content.substring(0, 15);
		}else{
			return this.content;
		}
	}

	@Override
	public String toString() {
		return "NotebookVoForAdmin [id=" + id + ", username=" + username + ", content=" + content + ", createTime="
				+ createTime + "]";
	}
}
