/**
 * 计算1到100之间的偶数和
 */
public class Continue {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1;i<=100;i++){
			if(i%2!=0){
				// 结束当次循环，不再执行循环体以后的语句，而是开始下次循环
				continue;
			}
			sum = sum+i;
		}
		System.out.println(sum);
	}
}
