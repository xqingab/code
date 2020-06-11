/**
 * 使用增强for循环进行数组元素的遍历
 */
public class For05 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// 遍历数组的每一个元素，并且把值输出到控制台上
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		// Java 5以后引入了以下增强for循环语法（foreach循环）
		// 这种语法是专门用于遍历数组或容器对象中所有元素的
		// for(被遍历的当前元素:被遍历的数组或容器)
		// 进入foreach循环，会从被遍历的数组或容器中顺序访问每一个元素
		// 每次循环会把当前取出的一个元素分配给i变量
		// 与一般的for循环不同，此处的i变量表示元素本身的值
		// 而一般for循环里的i表示的是数组元素的index值
		for (int i : arr1) {
			System.out.println(i);
		}
	}
}
