
public class Demo03 {
	public static void main(String[] args) {
		int a = 20;
		int b = 10;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		// 取余结果的符号由左操作数决定
		System.out.println(7 % 5);
		System.out.println(7 % -5);
		System.out.println(-7 % 5);
		System.out.println(-7 % -5);

		System.out.println(+10);
		System.out.println(-10);

		int i = 10;
		// ++是自增1的运算符；--是自减1的运算符
		// i++：先用后加
		// ++i：先加后用
		// i--：先用后减
		// --i：先减后用
		System.out.println(i++);
		System.out.println(i);
		i = 10;
		System.out.println(++i);
		System.out.println(i);
		i = 10;
		System.out.println(i--);
		System.out.println(i);
		i = 10;
		System.out.println(--i);
		System.out.println(i);

		int x = 10;
		// 第一步y=x;
		// 第二步x = x+1;
		int y = x++;
		System.out.println(x);
		System.out.println(y);

		x = 10;
		// 第一步：x=x+1;
		// 第二步：y=x;
		y = ++x;
		System.out.println(x);
		System.out.println(y);
		
		x = 10;
		// 单独使用++或--，而不使用它们所操作的变量，效果相同
		x++;
		++x;
		x--;
		--x;
	}
}
