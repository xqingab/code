
public class Player {
	private String name;
	private int hp;
	private int ap;
	private Weapon weapon;

	public Player() {
		super();
	}

	public Player(String name, int hp, int ap, Weapon weapon) {
		super();
		this.name = name;
		this.hp = hp;
		this.ap = ap;
		this.weapon = weapon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int attack() {
		return ap + weapon.getHarm();
	}

	public boolean attack(Player other) {
		int harm = this.attack();
		other.setHp(other.getHp() - harm);
		if (other.getHp() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ap;
		result = prime * result + hp;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
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
		Player other = (Player) obj;
		if (ap != other.ap)
			return false;
		if (hp != other.hp)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weapon == null) {
			if (other.weapon != null)
				return false;
		} else if (!weapon.equals(other.weapon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hp=" + hp + ", ap=" + ap + ", weapon=" + weapon + "]";
	}
}
