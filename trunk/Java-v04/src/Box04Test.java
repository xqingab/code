
public class Box04Test {

	public static void main(String[] args) {
		Box04 box1 = new Box04();
		
		System.out.println("box1的表面积是"+box1.getArea());
		System.out.println("box1的体积是"+box1.getVol());
		
		box1.setX(10);
		box1.setY(20);
		box1.setZ(5);
		System.out.println("box1的表面积是"+box1.getArea());
		System.out.println("box1的体积是"+box1.getVol());
		
		box1.setX(-10);
		box1.setY(-10);
		box1.setZ(-10);
		System.out.println("box1的表面积是"+box1.getArea());
		System.out.println("box1的体积是"+box1.getVol());
	}

}
