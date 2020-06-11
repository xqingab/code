package org.forten.sample.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test_country")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column
	private String name;
	@OneToMany(mappedBy = "country", cascade = { CascadeType.ALL })
	private Set<General> generalSet;

	public Country() {
		super();
		this.generalSet = new HashSet<General>();
	}

	public Country(int id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	public Country(int id, String name, General... generals) {
		this();
		this.id = id;
		this.name = name;
		for (General general : generals) {
			this.generalSet.add(general);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<General> getGeneralSet() {
		return generalSet;
	}

	public void setGeneralSet(Set<General> generalSet) {
		this.generalSet = generalSet;
	}

	public int getId() {
		return id;
	}

	public void addGenerals(General... generals) {
		for (General general : generals) {
			this.generalSet.add(general);
			general.setCountry(this);
		}
	}

	public void removeGenerals(General... generals) {
		for (General general : generals) {
			this.generalSet.remove(general);
			general.setCountry(null);
		}
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
		Country other = (Country) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", generalSet=" + generalSet + "]";
	}
}
