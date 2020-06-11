package org.forten.sample.test;

import java.util.HashSet;
import java.util.Set;

public class Word {
	private String eng;
	private String chi;
	private Set<String> desc;

	public Word() {
		super();
		this.desc = new HashSet<>();
	}

	public Word(String eng, String chi) {
		this();
		this.eng = eng;
		this.chi = chi;
	}

	public Word(String eng, String chi, String... d) {
		this();
		this.eng = eng;
		this.chi = chi;
		for (String string : d) {
			this.desc.add(string);
		}
	}

	public Word(String eng, String chi, Set<String> desc) {
		super();
		this.eng = eng;
		this.chi = chi;
		this.desc = desc;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getChi() {
		return chi;
	}

	public void setChi(String chi) {
		this.chi = chi;
	}

	public Set<String> getDesc() {
		return desc;
	}

	public void setDesc(Set<String> desc) {
		this.desc = desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chi == null) ? 0 : chi.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((eng == null) ? 0 : eng.hashCode());
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
		Word other = (Word) obj;
		if (chi == null) {
			if (other.chi != null)
				return false;
		} else if (!chi.equals(other.chi))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (eng == null) {
			if (other.eng != null)
				return false;
		} else if (!eng.equals(other.eng))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("英文：");
		sb.append(eng);
		sb.append("\n中文：");
		sb.append(chi);
		sb.append("\n解释：");
		for (String d : desc) {
			sb.append("\n\t");
			sb.append(d);
		}
		sb.append("\n");
		return sb.toString();
	}
}
