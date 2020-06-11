import java.util.Random;

public class If01 {
	public static void main(String[] args) {
		// input表示天气代码
		// 0：晴，1：下雨：2：下雪
		
		// 实例化一个随机对象
		Random r = new Random();
		// 随机取从0到参数值-1中的某个整数
		int input = r.nextInt(4);
		System.out.println(input);
		// 在if或if else后要跟一对圆括号，其中定义进行某个分支语句块的条件
		// 条件是一个布尔表达式，如果返回true则进入分支语句块，如果返回false则跳过其分支语句块向后执行
		// 如果所有条件都不成立，则进入else语句块
		// else块可以省略，但为了程序逻辑的严谨，最好把不满足所有条件的情况会执行的逻辑封装到else块中
		if(input==0){
			System.out.println("去爬山");
		}else if(input == 1){
			System.out.println("去图书馆");
		}else if(input == 2){
			System.out.println("堆雪人");
		}else{
			System.out.println("发呆");
		}
		System.out.println("睡觉");
	}
}
