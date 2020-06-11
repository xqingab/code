/**
 * 计算1加到100的和
 */
public class For01 {
	public static void main(String[] args) {
		int sum = 0;
		// for(初始化计数器;进入循环的条件表达式;修改计数器值)
		// 第一步：初始化计数器
		// 第二步：判断进入循环的条件是否成立，如果不成立则执行循环体后的语句
		// 		否则执行循环体中的语句
		// 第三步：当循环体中的语句执行完毕，会执行修改计数器值部分的操作
		// 第四步：再次进入第二步骤
		for(int i = 1;i<=100;i++){
			sum = sum+i;
		}
		System.out.println(sum);
	}
}
