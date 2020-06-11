package org.forten.sample;

public class Exception04 {
	public static void test(){
		throw new MyException("自定义异常已经被抛出");
	}
	
	public static void main(String[] args) {
		try{
			test();
		}catch(MyException e){
			System.out.println(e.getErrorTime());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
