
public class Box01Test {

	public static void main(String[] args) {
		// 从一个类生产一个对象的过程被称为实例化过程，生产出来的对象又可以被称为类的一个实例
		// Box01是自定义的类，属性Java的引用类型，在声明它的变量时与使用基本数据类型一致
		// 下边语句会在内存的栈空间中开辟一个变量的空间，这个变量的值是null;
		// Box01是一个引用类型（自定义的一个类），box1是一个Box01类型对象的引用，简称Box01的一个对象
		Box01 box1;

		// new Box01()语句会在内存的堆空间中生成一个对象实例，这个实例具有x,y,z三个属性，但值是0
		// 语句中的box1=部分的功能是把栈空间中box1的存储内容变量指向由new Box01()生产出的对象的内存地址（Hashcode哈稀码）
		// 把box1变量指向了一个新生产出来的Box01类型对象
		box1 = new Box01();
		// 经过以下三行语句，会把box1所引用的对象三个属性分别设置为10,5,3
		box1.x = 10;
		box1.y = 5;
		box1.z = 3;
		System.out.println("box1的表面积是" + ((box1.x * box1.y + box1.x * box1.z + box1.y * box1.z) * 2));
		System.out.println("box1的体积是" + (box1.x * box1.y * box1.z));

		// 实例化另一个Box01类型的对象box2
		// 以下语句会在栈中开辟一个空间来存储box2引用，在堆中生成一个Box01类型的实例，让box2引用到这个新的实例对象
		Box01 box2 = new Box01();
		// 为box2所引用的新实例对象的x,y,z属性分别赋值为100,30,20
		// box2和box1分别引用了两个堆中的不同Box01类型的对象，它们不会相互干扰
		box2.x = 100;
		box2.y = 30;
		box2.z = 20;
		System.out.println("box2的表面积是" + ((box2.x * box2.y + box2.x * box2.z + box2.y * box2.z) * 2));
		System.out.println("box2的体积是" + (box2.x * box2.y * box2.z));
		
		// 把box2的引用赋值为box1的引用值，这样，box1和box2都会引用最早box1指向的堆中的实例
		// 所以box1和box2两个引用变量共享同一个对象，以前box2引用的对象现在没有被任何引用变量引用，等待垃圾回收
		box2 = box1;
		System.out.println("box1的表面积是" + ((box1.x * box1.y + box1.x * box1.z + box1.y * box1.z) * 2));
		System.out.println("box1的体积是" + (box1.x * box1.y * box1.z));
		System.out.println("box2的表面积是" + ((box2.x * box2.y + box2.x * box2.z + box2.y * box2.z) * 2));
		System.out.println("box2的体积是" + (box2.x * box2.y * box2.z));
		
		// 因为box1和box2引用了同一个对象，所以一个变量对对象属性的操作会影响到另一个变量的操作
		box2.x=100;
		System.out.println("box1的表面积是" + ((box1.x * box1.y + box1.x * box1.z + box1.y * box1.z) * 2));
		System.out.println("box1的体积是" + (box1.x * box1.y * box1.z));
	}

}
