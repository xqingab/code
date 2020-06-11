/**
 * 10000元，年利率2.25%，5年后有多少钱
 */
public class For09 {
	public static void main(String[] args) {
		double money = 10000;
		for (int i = 0; i < 5; i++) {
			money = money * 1.0225;
		}
		System.out.println(money);
	}
}
