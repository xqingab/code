package org.forten.sample.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test_general")
public class General implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column
	private String name;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name="test_rel_general_role",joinColumns={@JoinColumn(name="general_id")},
		inverseJoinColumns={@JoinColumn(name="role_id")})
	private Set<Role> roleSet;

	public General() {
		super();
		this.roleSet = new HashSet<Role>();
	}

	public General(int id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
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
		General other = (General) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "General [id=" + id + ", name=" + name + ", roleSet=" + roleSet + "]";
	}
}
