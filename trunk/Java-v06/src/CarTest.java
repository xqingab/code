
public class CarTest {

	public static void main(String[] args) {
		Engine e1 = new Engine("宝马3.0T", 280);
		Engine e2 = new Engine("QQ1.2", 80);
		Engine e3 = new Engine("波音3200T", 1500);

		Car c1 = new Car("宝马", 230, e1);
		Car c2 = new Car("QQ", 5, e2);
		System.out.println(c1.getName()+"目前安装的是"+c1.getEngine().getName()+"引擎，速度是"+c1.getEngine().getSpeed()+"km/h");
		System.out.println(c2.getName()+"目前安装的是"+c2.getEngine().getName()+"引擎，速度是"+c2.getEngine().getSpeed()+"km/h");
		
		c1.setEngine(null);
		System.out.println(c1.getName()+"目前安装的是"+c1.getEngine().getName()+"引擎，速度是"+c1.getEngine().getSpeed()+"km/h");
		
		c2.setEngine(e3);
		System.out.println(c2.getName()+"目前安装的是"+c2.getEngine().getName()+"引擎，速度是"+c2.getEngine().getSpeed()+"km/h");
	}

}
