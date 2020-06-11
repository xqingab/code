package org.forten.statictest;

public class Box {
	// static修饰的成员被称为类级别的，可以通过"类名.成员名"的方式或"对象引用名.成员名"的方式进行访问，推荐使用"类名.成员名"的方式。
	// static修饰的成员是在字节码文件被加载到JVM后就可以使用的
	// 多个对象可以共享同一份static修饰的变量或常量

	// 非static的成员被称为对象（引用）级别的，只能通过"对象引用名.成员名"的方式进行访问
	// 非static的成员是在类被实例化成为某个对象后才可以使用的
	// 每个对象独占自己的那份非static成员，多个对象之间不会互相干扰
	private static int count = 0;
	
	public static final String NAME = "长方体";

	private int x;
	private int y;
	private int z;

	public Box(int x, int y, int z) {
		super();
		count++;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getCount() {
		return count;
	}

	public static void printInfoError() {
		// 在static方法中不可以访问非static的变量，不可调用非static的方法
		// 所以以下语句是错误的
		// System.out.println("盒子的长是" + x + "宽是" + y + "高是" + z);
	}
	
	public void printInfo(){
		// 在非static的方法中可以访问static及非static的全部成员
		System.out.println("盒子的长是" + x + "宽是" + y + "高是" + z+" 计数器目前是"+count+"个");
	}

	public int getArea() {
		return (x * y + x * z + y * z) * 2;
	}
}
