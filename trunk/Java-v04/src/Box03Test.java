
public class Box03Test {

	public static void main(String[] args) {
		Box03 box1 = new Box03();
		System.out.println("box1的表面积是"+box1.getArea());
		System.out.println("box1的体积是"+box1.getVol());

		Box03 box2 = new Box03(10,20,30);
		System.out.println("box2的表面积是"+box2.getArea());
		System.out.println("box2的体积是"+box2.getVol());
		
		Box03 box3 = new Box03(20);
		System.out.println("box3的表面积是"+box3.getArea());
		System.out.println("box3的体积是"+box3.getVol());
		
		box3.x = 40;
		System.out.println("box3的表面积是"+box3.getArea());
		System.out.println("box3的体积是"+box3.getVol());
	}

}
