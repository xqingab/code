/**
 * 输出100到200之间的素数
 */
public class For12 {
	public static void main(String[] args) {
		for (int i = 101; i <= 200; i++) {
			boolean flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.print(" " + i);
			}
		}
	}
}
