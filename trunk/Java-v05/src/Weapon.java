
public class Weapon {
	private String name;
	private int minAp;
	private int maxAp;

	public Weapon() {
		super();
	}

	public Weapon(String name, int minAp, int maxAp) {
		super();
		this.name = name;
		this.minAp = minAp;
		this.maxAp = maxAp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinAp() {
		return minAp;
	}

	public void setMinAp(int minAp) {
		this.minAp = minAp;
	}

	public int getMaxAp() {
		return maxAp;
	}

	public void setMaxAp(int maxAp) {
		this.maxAp = maxAp;
	}

	public int getHarm(){
		return (int)((maxAp+1)+(minAp-(maxAp+1))* Math.random());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxAp;
		result = prime * result + minAp;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Weapon other = (Weapon) obj;
		if (maxAp != other.maxAp)
			return false;
		if (minAp != other.minAp)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", minAp=" + minAp + ", maxAp=" + maxAp + "]";
	}
}
