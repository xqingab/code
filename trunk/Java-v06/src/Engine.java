
public class Engine {
	private String name;
	private int speed;

	public Engine() {
		super();
	}

	public Engine(String name, int speed) {
		super();
		this.name = name;
		this.speed = speed;
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

	@Override
	public String toString() {
		return "Engine [name=" + name + ", speed=" + speed + "]";
	}
}
