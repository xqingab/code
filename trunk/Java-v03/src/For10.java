/**
 * 计算1000以内不能被7整除的所有数字之和
 */
public class For10 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 7 == 0) {
				continue;
			}
			System.out.println(i);
			sum = sum + i;
		}
		System.out.println(sum);
	}
}
