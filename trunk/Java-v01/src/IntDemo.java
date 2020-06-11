
public class IntDemo {
	public static void main(String[] args) {
		// 以下整型字面量是int类型（不加特殊后缀说明的整型字面量，默认为int类型）
		System.out.println(100);
		// 十六进制字面量以0X或0x作为前缀
		System.out.println(0xff);
		// 八进制字面量以0作为前缀
		System.out.println(010);
		// 从Java7开始可以使用0B或0b作为前缀来标识二进制数字面量
		System.out.println(0b1111);
		// 从Java7开始可以使用下划线作为长数字的分隔符，以提高可读性
		// 在编译源代码时，编译器会自动移除这些分隔符
		System.out.println(0b1111_1111);
		System.out.println(223_829_429);
		// 可以使用L或l作为long型字面量的后缀，建议使用L
		System.out.println(2829438293L);
		// Java不支持byte和short类型的字面量，需要使用强制转型
		System.out.println((byte)18);
		System.out.println((short)18);
		
		// 在算术表达式中如果只有整型数字，则结果会截去小数部分，只保留整数部分的商
		System.out.println(5/2);
	}
}
