import java.util.Date;

public class Car {
	private String name;
	private int speed;
	private int price;
	private Date proDate;

	public Car() {
		super();
	}

	public Car(String name, int speed, int price, Date proDate) {
		super();
		this.name = name;
		this.speed = speed;
		this.price = price;
		this.proDate = proDate;
	}

	public Car(String name, int speed, int price) {
		super();
		this.name = name;
		this.speed = speed;
		this.price = price;
		this.proDate = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getProDate() {
		return proDate;
	}

	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((proDate == null) ? 0 : proDate.hashCode());
		result = prime * result + speed;
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
		Car other = (Car) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (proDate == null) {
			if (other.proDate != null)
				return false;
		} else if (!proDate.equals(other.proDate))
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", price=" + price + ", proDate=" + proDate + "]";
	}
}
