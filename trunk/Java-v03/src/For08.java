/**
 * 打印以下平行四边形
 *      *****
 *     *****
 *    *****
 *   *****
 *  *****
 */
public class For08 {
	public static void main(String[] args) {
		// 行数的循环
		for(int i = 1;i<=10;i++){
			// 内层循环会输出每行星号前的空格
			for(int j = 0;j<(10-i);j++){
				System.out.print(" ");
			}
			System.out.println("****************************************");
		}
	}
}
