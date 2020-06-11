package org.forten.sample.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_general")
public class General implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column
	private String name;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "country_id")
	private Country country;

	public General() {
		super();
	}

	public General(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public General(int id, String name, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void addTo(Country country) {
		country.addGenerals(this);
	}

	public void removeFrom(Country country) {
		country.removeGenerals(this);
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
		return "General [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
}
