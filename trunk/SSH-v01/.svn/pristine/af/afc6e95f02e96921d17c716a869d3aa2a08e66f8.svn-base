package org.forten.sample.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_notebook")
public class Notebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column
	private String username;
	@Column
	private String content;
	@Column(name = "create_time")
	private Date createTime;

	public Notebook() {
		super();
		this.createTime = new Date();
	}

	public Notebook(String username, String content) {
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
		Notebook other = (Notebook) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notebook [id=" + id + ", username=" + username + ", content=" + content + ", createTime=" + createTime
				+ "]";
	}
}
