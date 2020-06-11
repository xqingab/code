package org.forten.sample.vo;

import java.util.Date;

public class NotebookVoForUser {
	private String username;
	private String content;
	private Date createTime;

	public NotebookVoForUser() {
		super();
	}

	public NotebookVoForUser(String username, String content, Date createTime) {
		super();
		this.username = username;
		this.content = content;
		this.createTime = createTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content.replace("\n", "<br>");
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

	@Override
	public String toString() {
		return "NotebookVoForUser [username=" + username + ", content=" + content + ", createTime=" + createTime + "]";
	}
}
