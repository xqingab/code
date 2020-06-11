/**
 * 计算1的阶乘到10的阶乘之和
 */
public class While05 {
	public static void main(String[] args) {
		int sum = 0;// 阶乘累加的结果
		int i = 1;// 阶乘基数
		// 计算!1到!10结果的累加和
		while (i < 11) {
			sum = sum + getJC(i);
			i++;
		}
		System.out.println(sum);
	}

	// 封装了计算x的阶乘结果
	public static int getJC(int x) {
		if(x<=0){
			return 1;
		}
		// 乘数
		int i = 2;
		// 阶乘结果
		int result = 1;
		while (i <= x) {
			result = result * i++;
		}
		return result;
	}
}
