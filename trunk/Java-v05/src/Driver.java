
public class Driver {
	private String name;
	private int age;
	// 通过Car类型的实例变量，可以让Driver类型的对象持有一个Car类型的对象
	// 这是依赖关系（use-a），司机对象使用汽车对象
	private Car car;

	public Driver() {
	}

	public Driver(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Driver(String name, int age, Car car) {
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void start() {
		// 以下逻辑会判断所依赖的对象如果是null时如何执行程序
		// 判断空操作
		// 主要为了避免NullPointerException的出现
		if (this.car == null) {
			System.out.println(this.name + "先去摇号~");
		} else {
			System.out.println(this.name + "正在发动" + car.getName());
		}
	}

	public void drive() {
		if (this.car == null) {
			System.out.println(this.name + "奔跑吧~");
		} else {
			System.out.println(this.name + "正在以" + car.getSpeed() + "km/h的时速驾驶" + car.getName());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
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
		Driver other = (Driver) obj;
		if (age != other.age)
			return false;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
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
		return "Dirver [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
