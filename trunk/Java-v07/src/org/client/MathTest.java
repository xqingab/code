package org.client;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.E);
		System.out.println(Math.PI);
		// 绝对值
		System.out.println(Math.abs(1.5));
		System.out.println(Math.abs(-1.5));
		System.out.println(Math.abs(0));
		// 向上取整，取比参数大的那个最小整数
		System.out.println(Math.ceil(5.8));
		System.out.println(Math.ceil(-5.8));
		System.out.println(Math.ceil(5.1));
		System.out.println(Math.ceil(-5.1));
		System.out.println(Math.ceil(5.0));
		System.out.println(Math.ceil(-5.0));
		
		System.out.println("----------------------");
		
		// 向下取整，取比参数小的那个最大整数
		System.out.println(Math.floor(5.8));
		System.out.println(Math.floor(-5.8));
		System.out.println(Math.floor(5.1));
		System.out.println(Math.floor(-5.1));
		System.out.println(Math.floor(5.0));
		System.out.println(Math.floor(-5.0));
		
		System.out.println("----------------------");

		// 取最小值
		System.out.println(Math.min(100, 10));
		// 取最大值
		System.out.println(Math.max(100, 10));
		
		System.out.println("----------------------");
		// 计算n的m次方
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.pow(2, 10));
		System.out.println(Math.pow(2, -3));
		System.out.println(Math.pow(2, 0));
		System.out.println("----------------------");
		
		// 开平方
		System.out.println(Math.sqrt(16));
		System.out.println(Math.sqrt(144));
		System.out.println(Math.sqrt(-144));// NaN
		
		// 取[0.0,1.0)区间的随机数
		System.out.println(Math.random());
		
		// 四舍五入
		System.out.println(Math.round(5.8));
		System.out.println(Math.round(5.1));
		System.out.println(Math.round(5.15638923489*10000)/10000.0);
		
	}

}
