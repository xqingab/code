/**
 * 计算1的阶乘到10的阶乘之和
 */
public class While06 {
	public static void main(String[] args) {
		// 乘数
		int i = 1;
		// 阶乘结果
		int result = 1;
		int sum = 0;
		while (i < 11) {
			System.out.print(result + " * " + i + " = ");
			// 计算阶乘，并改变计数器的值
			result = result * i++;
			System.out.println(result);
			sum = sum +result;
		}
		System.out.println("!10结果是："+result);
		System.out.println("!1+!2+!3+...+!10的结果是：" + sum);
	}
}
