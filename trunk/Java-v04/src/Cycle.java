
public class Cycle {
	private final double PI = 3.1415926;
	private double r;

	// 当在类中没有任何的构造方法时，Java会默认生成一个无参构造方法
	// 当在类中出现了至少一个构造方法时，Java就不会再自动生成无参构造方法了
	// 当类中存在构造方法定义后，调用时，只能使用已定义的构造方法
	public Cycle(double r) {
		super();
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getLength() {
		return 2 * PI * r;
	}

	public double getArea() {
		return PI * r * r;
	}
	
	// 当此类的对象被垃圾回收时才会执行finalize()方法
	// 在程序中不能控制何时进行垃圾回收，所以此方法何时执行，是否执行是不可知的
	// 所以一些释放程序外部资源的操作（如关闭数据库连接、关闭文件流等资源）不应该依赖于此方法的执行
	protected void finalize(){
		System.out.println("GC");
	}
}
