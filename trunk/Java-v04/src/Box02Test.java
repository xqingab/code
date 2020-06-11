
public class Box02Test {

	public static void main(String[] args) {
		Box02 box1 = new Box02();
		box1.x=10;
		box1.y=5;
		box1.z=3;
		
		System.out.println("box1的表面积是"+box1.getArea());
		System.out.println("box1的体积是"+box1.getVol());
		
		Box02 box2 = new Box02();
		box2.x = 100;
		box2.y = 30;
		box2.z = 20;
		System.out.println("box2的表面积是"+box2.getArea());
		System.out.println("box2的体积是"+box2.getVol());
		
		Box02 box3 = new Box02();
		box3.setXYZ(18, 10, 6);
		System.out.println("box3的表面积是"+box3.getArea());
		System.out.println("box3的体积是"+box3.getVol());

		Box02 box4 = new Box02();
		box4.setXYZ(15, 8, 4);
		System.out.println("box4的表面积是"+box4.getArea());
		System.out.println("box4的体积是"+box4.getVol());
	}

}
