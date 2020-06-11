
public class Box03 {
	int x;
	int y;
	int z;

	// 以下程序成员是Java中的构造方法，用于构造类的一个对象实例，总是与new操作符一起调用的
	// 通常在构造方法内部进行对象实例的数据初始化
	// 是一个特殊的方法，没有返回类型，方法名称与类名完全一致
	public Box03() {
		// 进行对象实例的数据初始化
		// 设置长宽高都是10（默认值）
		this.x = 10;
		this.y = 10;
		this.z = 10;
	}
	
	// 在一个类中有名字相同但参数列表不同（参数个数不同或者参数类型不同）的多个方法，被称为Java中的方法重载
	// 利用构造方法的重载特性，构造一个边长为len的立方体
	public Box03(int len){
		this.x = len;
		this.y = len;
		this.z = len;
	}
	
	// 利用构造方法的重载特性，构造一个长为x，宽为y，高为z的长方体
	public Box03(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getArea() {
		return (x * y + x * z + y * z) * 2;
	}

	public int getVol() {
		return x * y * z;
	}
}
