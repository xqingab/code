/**
 * 计算10的阶乘
 */
public class While03 {
	public static void main(String[] args) {
		// 乘数
		int i = 2;
		// 阶乘结果
		int result = 1;
		while (i < 11) {
			System.out.print(result + " * " + i + " = ");
			// 计算阶乘，并改变计数器的值
			result = result * i++;
			System.out.println(result);
		}
		System.out.println("最终结果："+result);
	}
}
