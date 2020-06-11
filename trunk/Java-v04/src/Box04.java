
public class Box04 {
	// 隐藏所有实例变量（使用private把实例变量声明为私有的）
	// 公开每个实例变量的读取器（getter方法）和设置器（setter方法）
	// 优点：读写粒度可控
	// 可以在getter/setter方法中写入对数据格式、范围等的控制逻辑

	// 如果没有显式的为实例变量进行赋值，Java会使用默认值
	// byte,short,int,long => 0
	// float,double => 0.0
	// char => \u0000（空字符）
	// boolean => false
	// 引用类型 => null
	private int x;
	private int y;
	private int z;

	public Box04() {

	}

	public Box04(int len) {
		super();
		this.x = len;
		this.y = len;
		this.z = len;
	}

	public Box04(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x <= 0) {
			this.x = 10;
			System.out.println("长设置的值为[" + x + "]系统认为不合法，设置了默认值10");
		} else {
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y <= 0) {
			this.y = 10;
			System.out.println("宽设置的值为[" + y + "]系统认为不合法，设置了默认值10");
		} else {
			this.y = y;
		}
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		if (z <= 0) {
			this.z = 10;
			System.out.println("高设置的值为[" + z + "]系统认为不合法，设置了默认值10");
		} else {
			this.z = z;
		}
	}

	public int getArea() {
		return (x * y + x * z + y * z) * 2;
	}

	public int getVol() {
		return x * y * z;
	}
}
