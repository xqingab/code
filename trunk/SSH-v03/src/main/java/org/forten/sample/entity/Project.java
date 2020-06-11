package org.forten.sample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "test_project")
@Cache(region="projectCache",usage=CacheConcurrencyStrategy.READ_WRITE)
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column
	@NotBlank(message="项目名称不可为空白")
	@Length(min=4,max=20,message="项目名称长度应该在{min}~{max}之间")
	private String name;

	public Project() {
		super();
	}

	public Project(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
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
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
}
