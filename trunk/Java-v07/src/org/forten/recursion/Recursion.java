package org.forten.recursion;

public class Recursion {
	// 递归算法：方法自己调用自己
	// 需要注意的是一定要设置正确的结束条件
	public static int jc(int x) {
		if (x == 1) {
			return 1;
		} else {
			return x * jc(x - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(jc(10));
	}

}
