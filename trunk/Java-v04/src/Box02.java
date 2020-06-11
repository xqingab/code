
public class Box02 {
	// 这些数据在面向对象中被称为对象的属性或实例变量
	int x;
	int y;
	int z;

	// 以下是Java类中的方法，对应对象的行为
	// 没有被static修饰的方法被称为实例方法
	// 实例方法要通过实例对象的引用被调用，其中所使用的实例变量数据来自实例对象
	public int getArea() {
		return (x * y + x * z + y * z) * 2;
	}

	// Java程序中方法的签名是：访问修饰符 [其它修饰符] 返回类型 方法名称(参数列表)
	public int getVol() {
		return x * y * z;
	}

	public void setXYZ(int x, int y, int z) {
		// 哪个对象调用这个方法，下面的this就是哪个对象
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
