import java.util.Random;

/**
 * 随机出一个0到999999999之间的数，求这个数字有多少位
 */
public class While08 {
	public static void main(String[] args) {
		Random r = new Random();
		// 随机出一个0到999999999之间的数
		int n = r.nextInt(1000000000);
		System.out.print(n);
		int x = 0;// 数字的位数
		// 当n不等于0时会进入循环
		while (n != 0) {
			x++;// 位数自增
			n = n / 10;// 数字循环整除10，并赋值给原有数字变量
		}
		System.out.println("的位数是" + x);
	}
}
