/**
 * 有1024个西瓜，每天卖出总数的一半多两个，问多少天卖完
 */
public class While07 {
	public static void main(String[] args) {
		int q = 1020;// 西瓜的总数
		int day = 0;// 天数
		while (q > 0) {
			q = q / 2 - 2;// 每天收摊时剩余西瓜的数量，是前一天总数的一半少两个
			day++;
		}
		System.out.println("卖完所有西瓜需要" + day + "天");
	}
}
