
public class Array01 {
	public static void main(String[] args) {
		// 声明一个名称为arr的数组对象
		// int指明了数组对象中元素的类型
		int[] arr;
		// 实例化数组
		// 实例化了一个可以承载5个int类型元素的数组
		// 每个数组元素会被初始化为0
		// 所有数字类型的数组元素都以0为初始值
		// 所有布尔类型的数组元素都以false为初始值
		// 所有引用类型的数组元素都以null为初始值
		arr = new int[5];

		// 访问数组中的元素：以arr-name[index]格式进行访问
		// index的范围是0到数组长度减1；第一个元素的index是0，第二个元素的index是1...最后一个元素的index是数组长度-1
		// 可以使用arr-name.length来获得某个数组的元素总数
		System.out.println("arr的元素总数是：" + arr.length);
		System.out.println("arr的第一个元素值是：" + arr[0]);
		System.out.println("arr的第二个元素值是：" + arr[1]);
		System.out.println("arr的第三个元素值是：" + arr[2]);
		System.out.println("arr的第四个元素值是：" + arr[3]);
		System.out.println("arr的第五个元素值是：" + arr[4]);

		// 为数组元素赋值
		// arr-name[index]=?
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;

		System.out.println("==========================");
		System.out.println("arr的元素总数是：" + arr.length);
		System.out.println("arr的第一个元素值是：" + arr[0]);
		System.out.println("arr的第二个元素值是：" + arr[1]);
		System.out.println("arr的第三个元素值是：" + arr[2]);
		System.out.println("arr的第四个元素值是：" + arr[3]);
		System.out.println("arr的第五个元素值是：" + arr[4]);

		System.out.println("==========================");
		// 如果在访问数组元素时，使用的index值小于0或大于数组长度-1，Java会抛出ArrayIndexOutOfBoundsException（数组索引值越界异常）
		// System.out.println(arr[-1]);// 错误
		// System.out.println(arr[5]);// 错误
		
		// 声明数组的另外一种方式，与int[] array = new int[5];功能完全一致，为表述性考虑，推荐使用第一种方式声明数组类型对象
		int array[] = new int[5];
		
		// 在实例化数组对象的时候对元素直接进行初始化
		int[] arr1 = new int[]{1,2,3,5,9,13};
		System.out.println("==========================");
		System.out.println("arr1的元素总数是：" + arr1.length);
		System.out.println("arr1的第一个元素值是：" + arr1[0]);
		System.out.println("arr1的第二个元素值是：" + arr1[1]);
		System.out.println("arr1的第三个元素值是：" + arr1[2]);
		System.out.println("arr1的第四个元素值是：" + arr1[3]);
		System.out.println("arr1的第五个元素值是：" + arr1[4]);
		System.out.println("arr1的第五个元素值是：" + arr1[5]);

		int[] arr2 = {5,10,15,20,25,30};
		System.out.println("==========================");
		System.out.println("arr2的元素总数是：" + arr2.length);
		System.out.println("arr2的第一个元素值是：" + arr2[0]);
		System.out.println("arr2的第二个元素值是：" + arr2[1]);
		System.out.println("arr2的第三个元素值是：" + arr2[2]);
		System.out.println("arr2的第四个元素值是：" + arr2[3]);
		System.out.println("arr2的第五个元素值是：" + arr2[4]);
		System.out.println("arr2的第五个元素值是：" + arr2[5]);
	}
}
