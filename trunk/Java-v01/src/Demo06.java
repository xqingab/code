
public class Demo06 {
	public static void main(String[] args) {
		// 条件运算符（?:）
		// 第一操作数通常是一个boolean表达式
		// 如果boolean表达式返回true，则运算结果为第二操作数
		// 如果boolean表达式返回false，则运算结果为第三操作数
		int a = (5 * 2 >= 10) ? 1 : 0;
		System.out.println(a);
		a = (5 >= 10) ? 1 : 0;
		System.out.println(a);
		String s = (5 * 2 >= 10) ? "Yes" : "No";
		System.out.println(s);
		s = (5 >= 10) ? "Yes" : "No";
		System.out.println(s);

		// 赋值运算符
		// =、+=、-=、*=、/=、%=、|=、&=、^=、>>=、>>>=、<<=
		// =：把右侧的字面量或表达式的结果赋值给左侧的变量
		// opt=：先对右侧的表达式求值，然后把左侧变量的原始值与求得的右侧表达式的值进行指定运算，结果再赋值给左变量

		int x = 10;
		// 以下语句等同于x = x + 2;可读性更强
		x += 2;// 性能会更好一些
	}
}
