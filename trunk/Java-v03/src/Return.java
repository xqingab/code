import java.util.Random;

/**
 * 随机得一个0到9之间的数字并打印，如果出现5，则退出程序
 */
public class Return {
	public static void main(String[] args) {
		Random r = new Random();
		for (;;) {
			int n = r.nextInt(10);
			if (n == 5) {
				// 当执行return后方法的执行会被终止
				return;
			}
			System.out.println(n);
		}
		// 因为在循环体中出现了return语句，以下语句可能不可到达，会出现编译错误
		// System.out.println("5了");
	}
}
