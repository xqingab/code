import java.util.Random;

/**
 * 随机得一个0到9之间的数字并打印，如果出现5，则退出循环
 */
public class Break {
	public static void main(String[] args) {
		Random r = new Random();
		for (;;) {
			int n = r.nextInt(10);
			if (n == 5) {
				// 当执行break后循环会被终止
				break;
			}
			System.out.println(n);
		}
		System.out.println("5了");
	}
}
