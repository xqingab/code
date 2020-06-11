
public class Car {
	private String name;
	private int price;
	private Engine engine;

	public Car() {
		super();
	}

	public Car(String name, int price, Engine engine) {
		super();
		this.name = name;
		this.price = price;
		this.engine = engine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		if (engine == null) {
			this.engine = new Engine("小马达", 5);
		} else {
			this.engine = engine;
		}
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", engine=" + engine + "]";
	}
}
