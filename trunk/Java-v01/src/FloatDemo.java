
public class FloatDemo {
	public static void main(String[] args) {
		// 以下浮点型字面量是double类型（不加特殊后缀说明的浮点型字面量，默认为double类型）
		System.out.println(3.5);
		// 可以使用科学计数法表示浮点字面量
		System.out.println(1.5e3);
		System.out.println(1.5e-3);
		// 可以使用F或f作为float型字面量的后缀
		System.out.println(1.5f);
		// 可以使用D或d作为double型字面量的后缀
		System.out.println(1.5D);
		
		System.out.println(5.0/2.0);
		// 当算术表达式中有double类型的字面量或变量时非double类型的数据会自动转型成为double类型，然后再继续运算
		System.out.println(5.0/2);
		// 在做浮点类型数学运行的过程中可能会出现算术误差
		System.out.println(2.0-1.1);
		// 如果在算术表达式中除以了0，并且在操作数中有浮点类型的值，则会得到正（负）无穷
		System.out.println(1/0.0);
		System.out.println(-1/0.0);
		// 如果0.0/0或0/0.0会得到非数字（NaN）
		System.out.println(0.0/0);
		System.out.println(0/0.0);
		// 任意两个结果是NaN的表达式都不相等（两个都不是数字的结果没有可比性）
		System.out.println(0/0.0==0.0/0);
		// 如果算术表达式中的操作数都是整型，则会抛出被0除的算术异常
		System.out.println(1/0);
	}
}
