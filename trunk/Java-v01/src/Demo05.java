
public class Demo05 {
	public static void main(String[] args) {
		// 逻辑与（&）/短路与（&&）
		// 逻辑与：无论左表达式返回何值，都会对右表达式进行运算
		// 短路与：左表达式结果为假则不会运算右表达式，直接返回false
		// 左表达式结果为真，才会运算右表达式，返回最终结果
		boolean flag = false;
		boolean result = (10 > 6) && (flag = 5 < 10);
		System.out.println(flag);
		System.out.println(result);

		flag = false;
		result = (10 < 6) && (flag = 5 < 10);
		System.out.println(flag);
		System.out.println(result);

		flag = false;
		result = (10 < 6) & (flag = 5 < 10);
		System.out.println(flag);
		System.out.println(result);

		System.out.println("=======================");

		// 逻辑或（|）/短路或（||）
		// 逻辑或：无论左表达式返回何值，都会对右表达式进行运算
		// 短路或：左表达式结果为真则不会运算右表达式，直接返回true
		// 左表达式结果为假，才会运算右表达式，返回最终结果
		flag = true;
		result = (10 < 6) || (flag = 5 > 10);
		System.out.println(flag);
		System.out.println(result);

		flag = true;
		result = (10 > 6) || (flag = 5 > 10);
		System.out.println(flag);
		System.out.println(result);

		flag = true;
		result = (10 > 6) | (flag = 5 > 10);
		System.out.println(flag);
		System.out.println(result);
	}
}
