
public class DriverTest {

	public static void main(String[] args) {
		Car c1 = new Car("途睿", 80, 420000);
		Car c2 = new Car("路虎", 120, 660000);
		Car c3 = new Car("QQ", 60, 7000);

		Driver d1 = new Driver("吕布", 35);
		d1.setCar(c2);
		d1.start();
		d1.drive();
		System.out.println(d1);
		
		Driver d2 = new Driver("赵云", 28, c1);
		d2.start();
		d2.drive();
		
		// 把吕布和路虎之间的关系解除
		d1.setCar(null);
		d1.start();
		d1.drive();
		
		d1.setCar(c3);
		d1.start();
		d1.drive();
		
		d2.setCar(c2);
		d2.start();
		d2.drive();
	}

}
