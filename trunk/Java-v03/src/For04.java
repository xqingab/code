/**
 * 使用for循环进行数组元素的遍历
 */
public class For04 {
	public static void main(String[] args) {
		int[] arr1 = new int[20];
		// 对一个长度是20的int数组进行元素赋值，每个元素的值是它的index+1
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i + 1;
		}
		// 遍历数组的每一个元素，并且把值输出到控制台上
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		// 遍历数组的每一个元素，并且把元素的值扩大5倍
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr1[i] * 5;
		}
		// 遍历数组的每一个元素，并且把值输出到控制台上
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
	}
}
