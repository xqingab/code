package org.forten.sample;

public class IntFunTest {

	public static void main(String[] args) {
		IntFun i = (x)->{
			int result = 1;
			for(int j = 1;j<=x;j++){
				result = result*j;
			}
			return result;
		};
		
		System.out.println(i.test(3));
		System.out.println(i.test(10));
	}

}
