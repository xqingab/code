/**
 * 打印前20个斐波那契数列，每五个数字一行
 * 前两个数字是1，从第三个数字开始是前两个数字之和
 */
public class For11 {
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		System.out.print(a + "\t" + b + "\t");
		for(int i = 3;i<=20;i++){
			int n = a+b;
			a = b;
			b = n;
			System.out.print(n);
			if(i%5==0){
				System.out.println();
			}else{
				System.out.print("\t");
			}
		}
	}
}
