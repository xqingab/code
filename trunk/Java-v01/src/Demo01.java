
public class Demo01 {
	public static void main(String[] args) {
		// 变量：是一个具有名称的内存空间，可以存放兼容类型的数据
		
		// 声明了一个名为num的int类型变量
		// 因为Java是强类型语言，所在声明变量时一定要先指定它的类型
		// 一旦变量的类型被声明完成，对此变量的赋值必须使用此类型的兼容类型
		int num;
		// 对声明的变量进行赋值，把100这个值赋给了变量num
		num = 100;
		// 在控制台上打印num is: 100这个字符串
		System.out.println("num is: " + num);
		
		// 把当前num的值乘以2以后，再赋值给num变量
		num = num * 2;
		System.out.print("num is: ");
		System.out.println(num);
	}
}
