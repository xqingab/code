package org.forten.sample;

public class MsgTest {
	public void print(IntFun intFun,String m){
		System.out.println(m+intFun.test(10));
	}
	
	public static void main(String[] args) {
		IntFun i = (x)->{
			int result = 1;
			for(int j = 1;j<=x;j++){
				result = result*j;
			}
			return result;
		};
		
		MsgTest mt = new MsgTest();
		mt.print(i, "阶乘:");
		
		i = (x)->{
			int sum = 0;
			for (int j = 1; j <=x ; j++) {
				sum = sum+j;
			}
			return sum;
		};
		mt.print(i, "总和:");
	}

}
