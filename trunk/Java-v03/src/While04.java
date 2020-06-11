/**
 * 计算1的阶乘到10的阶乘之和 
 */
public class While04 {
	public static void main(String[] args) {
		int sum = 0;// 阶乘累加的结果
		int i = 1;// 阶乘基数
		// 计算!1到!10结果的累加和
		while (i < 11) {
			int j = 1;// 阶乘的起始值
			int result = 1;// 阶乘的结果
			// 计算i的阶乘（i从1到10）
			while (j <= i) {
				result = result * j;
				j++;
			}
			i++;
			sum = sum + result;
		}
		System.out.println(sum);
	}
}
