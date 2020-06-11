/**
 * 输入一个价格
 * 
 * 如果价格>0并且<=1000则不打折
 * 
 * 如果价格>1000并且<=3000则折95折
 * 
 * 如果价格>3000并且<=5000则折9折
 * 
 * 如果价格>5000并且<=10000则折8折
 * 
 * 如果价格>10000则折7折
 * 
 * 如果价格<=0则输出“请输入正确的价格”
 */
public class If02 {
	public static void main(String[] args) {
		int price = 800;
		// 如果if块、else if块、else块中只有一条语句，则可以省略花括号
		// 否则必须使用花括号把语句封装在一起
		// 省略花括号的写法不推荐使用
		// 在真实开发场景中无论分支块有多少条语句都应该把它们包括在一对花括号之间
		// 此规则对于while、do-while、for循环结果的语句也同样适用
		if (price > 0 && price <= 1000)
			System.out.println(price);
		else if (price > 1000 && price <= 3000)
			System.out.println(price * 0.95);
		else if (price > 3000 && price <= 5000)
			System.out.println(price * 0.9);
		else if (price > 5000 && price <= 10000)
			System.out.println(price * 0.8);
		else if (price > 10000)
			System.out.println(price * 0.7);
		else
			System.out.println("请输入正确的价格");

		// 以下代码调整了判断条件的顺序，简化了系统逻辑，功能与上边代码段一致
		if (price > 10000) {
			System.out.println(price * 0.7);
		} else if (price > 5000) {
			System.out.println(price * 0.8);
		} else if (price > 3000) {
			System.out.println(price * 0.9);
		} else if (price > 1000) {
			System.out.println(price * 0.95);
		} else if (price > 0) {
			System.out.println(price);
		} else {
			System.out.println("请输入正确的价格");
		}
	}
}
