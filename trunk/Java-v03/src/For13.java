/**
 * 有10个数字，去掉一个最大的和一个最小的，计算其它8个数字的平均值
 */
public class For13 {
	public static void main(String[] args) {
		double[] arr = { 9, 8.3, 6.3, 8.2, 7.9, 9.8, 9.2, 9.0, 9.9, 6.9 };
		double temp = 0.0;
		for (int i = arr.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (arr[j + 1] < arr[j])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
		for (double d : arr) {
			System.out.println(d);
		}
		double sum = 0.0;
		for (int i = 1; i < arr.length-1; i++) {
			sum += arr[i];
		}
		System.out.println(sum/8);
	}
}
