
public class Demo04 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int t = a;
		a = b;
		b = t;
		System.out.println(a);
		System.out.println(b);
		
		a = 10;
		b =20;
		// 01010^10100=11110
		// a = 11110;b= 10100
		a = a^b;
		// 10100^11110=01010
		// a = 11110;b=01010
		b = b^a;
		// 11110^01010=10100
		// a = 10100;b=01010
		a = a^b;
		System.out.println(a);
		System.out.println(b);
		
		a = 10;
		b = 20;
		// 00001010|00010100=00011110
		System.out.println(a|b);
		// 00001010&00010100=00000000
		System.out.println(a&b);
		// ~00001010=11110101
		System.out.println(~a);
		System.out.println(~42);
		System.out.println(~-43);
		
		// 左移：把操作数变为二进制，进行向左移位，最高n位被移出，最低位补0
		// 左移n位，原数值乘以2的n次方
		// 00000101<<2 => 00010100(20)
		System.out.println(5<<2);
		// 00000101<<3 => 00101000(40)
		System.out.println(5<<3);
		
		System.out.println(-5<<3);
		
		// 对于int类型的数字最多左移30位，对于long类型的数字最多左移62位，如果大于30或62，原数字会丢失
		System.out.println(5<<32);
		
		// 右移：把操作数变为二进制，进行向右移位，最低n位被移出，最高位补符号位（正数补0，负数补1）
		// 右移n位，原数值除以2的n次方并去掉小数部分
		// 0000_0001_0000_0000>>2 =>0000_0000_0100_0000(64)
		System.out.println(256>>2);
		// 1111_1111_1101_0110>>2 => 1111_1111_1111_0101(-11)
		System.out.println(-42>>2);
		
		// 无符号右移：把操作数变为二进制，进行向右移位，最低n位被移出，无论原数字是正还是负，最高位都补0
		System.out.println(256>>>2);
		System.out.println(-42>>>2);
	}
}
