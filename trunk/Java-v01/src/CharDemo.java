
public class CharDemo {
	public static void main(String[] args) {
		// char类型的字面量是用单引号括起来的单个字符
		System.out.println('a');
		// System.out.println('aa');
		
		// 当char类型与整型数据进行算数运算时，char类型的字符会先转型成为int（字符的Unicode编码值），再与数字进行运算
		System.out.println('a'+0);
		// 可以对int类型的字面量进行char类型的强制转型，得到数值对应的Unicode编码字符
		System.out.println((char)97);
		
		// 转义符
		System.out.println('\t');// 水平制表
		System.out.print('\f');// 换页
		System.out.print('\r');// 回车
		System.out.print('\n');// 换行
		System.out.println();
		System.out.println("abc\r123\nxyz");
		System.out.println("abc\b");// 退格
		System.out.println("This\'s an apple");// 单引号
		System.out.println("This\'s an \"apple\"");// 双引号
		System.out.println("This\'s \\ an \"apple\"");// 反斜线
		
		// \\uxxxx表示Unicode编码中的某个字符
		System.out.println('\u0061');
		// 基本汉字的Unicode范围是4e00到9fa5
		System.out.println('\u4e00');
		System.out.println('\u9fa5');
		
	}
}
