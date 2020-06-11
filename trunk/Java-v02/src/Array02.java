
public class Array02 {
	public static void main(String[] args) {
		// 二维数组对应一张二维表格，是由数组作为元素组成的一个数组
		// 声明二维数组
		// new int[3][4]声明了一个元素由三个数组组成的数组，每个数组元素中有4个int类型的元素
		// [3]表示大数组中有3个小数组元素，表示行数量
		// [4]表示小数组元素由4个int类型的元素构成，表示每行的单元格数量
		// {{0,0,0,0},{0,0,0,0},{0,0,0,0}}
		int[][] arr1 = new int[3][4];
		System.out.println("arr1的长度是："+arr1.length);
		System.out.println("arr1[0]的长度是："+arr1[0].length);
		System.out.println("arr1[1]的长度是："+arr1[1].length);
		System.out.println("arr1[2]的长度是："+arr1[2].length);
		
		// 获取每一个子数组对象
		System.out.println("arr1[0]的值："+arr1[0]);
		System.out.println("arr1[1]的值："+arr1[1]);
		System.out.println("arr1[2]的值："+arr1[2]);

		// 获取每一个子数组中的数据元素
		System.out.println("======================");
		System.out.println("arr1[0][0]的值："+arr1[0][0]);
		System.out.println("arr1[0][1]的值："+arr1[0][1]);
		System.out.println("arr1[0][2]的值："+arr1[0][2]);
		System.out.println("arr1[0][3]的值："+arr1[0][3]);
		System.out.println("arr1[1][0]的值："+arr1[1][0]);
		System.out.println("arr1[1][1]的值："+arr1[1][1]);
		System.out.println("arr1[1][2]的值："+arr1[1][2]);
		System.out.println("arr1[1][3]的值："+arr1[1][3]);
		System.out.println("arr1[2][0]的值："+arr1[2][0]);
		System.out.println("arr1[2][1]的值："+arr1[2][1]);
		System.out.println("arr1[2][2]的值："+arr1[2][2]);
		System.out.println("arr1[2][3]的值："+arr1[2][3]);
		
		// 在实例化过程中为每一个数组元素进行初始化
		int[][] arr2 = {{1,2,3,4},{5,10,20,30},{100,200,300,400}};
		System.out.println("======================");
		System.out.println("arr2[0][0]的值："+arr2[0][0]);
		System.out.println("arr2[0][1]的值："+arr2[0][1]);
		System.out.println("arr2[0][2]的值："+arr2[0][2]);
		System.out.println("arr2[0][3]的值："+arr2[0][3]);
		System.out.println("arr2[1][0]的值："+arr2[1][0]);
		System.out.println("arr2[1][1]的值："+arr2[1][1]);
		System.out.println("arr2[1][2]的值："+arr2[1][2]);
		System.out.println("arr2[1][3]的值："+arr2[1][3]);
		System.out.println("arr2[2][0]的值："+arr2[2][0]);
		System.out.println("arr2[2][1]的值："+arr2[2][1]);
		System.out.println("arr2[2][2]的值："+arr2[2][2]);
		System.out.println("arr2[2][3]的值："+arr2[2][3]);
		
		// 声明一个不规则数组
		// 对不规则数组的访问时，要注意每个子数组元素的长度，不要在访问元素值是发生数组索引越界异常
		int[][] arr3 = {{1,2},{5,10,20,30},{1}};
	}
}
