/**
 * 打印等腰三角形
 *      *
 *     ***
 *    *****
 *   *******
 *  *********
 */
public class For07 {
	public static void main(String[] args) {
		// 行的循环
		for (int i = 1; i <= 10; i++) {
			// 打印每行星号前的空格
			for (int j = 0; j < (10 - i); j++) {
				System.out.print(" ");
			}
			// 打印每行的星号
			for (int j = 0; j < (i * 2 - 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
