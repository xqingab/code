package org.forten.sample;

import java.io.IOException;
import java.sql.SQLException;

public class Exception01 {
	// 在方法的参数列表圆括号后可以跟throws关键字
	// throws关键字声明了这个方法在被调用时可能会抛出的异常类型
	// 多个异常类型之间使用逗号分隔
	public void test1() throws IOException, SQLException {
		if (true) {
			// throw关键字的功能是抛出某个类型的异常对象
			// 抛出给调用此方法的客户程序
			// 当方法抛出异常后，此方法就执行结束了
			// throw相对于return，也是一种方法结束的出口
			// 只不过return是方法的正常结束，throw是方法的异常结束
			throw new IOException("IO-受检");
		}
		// 因为以上if条件一定为true，所以IOException会被抛出
		// 这个方法也必然结束，所以以下if块是不会被执行到的
		if(true){
			throw new SQLException("SQL-受检");
		}
	}
	
	// 当在一个方法中调用另一个抛出了受检异常的方法时，这个方法也要对这些受检异常进行处理
	// 处理方式有两种：
	// 1.再次抛出这些异常（击鼓传花）
	// 2.内部消化（把异常在内容进行转化或逻辑处理掉）
	// 在test2()中调用了抛出了受检异常的test1()方法，在test2()中使用了再次抛出方式进行处理
	public void test2() throws IOException,SQLException{
		test1();
	}
	
	// 此方法在运行过程中一定会抛出Error类型的错误对象
	// 但因为它属于非受检异常，一般是程序员不能解决的问题所导致的（如：网络断开、系统故障等）
	// 所以可以不用进行对此类错误的处理
	public void test3() throws Error{
		throw new Error("错误-非受检");
	}
	
	public void test4(){
		test3();
	}
	
	// 此方法在运行过程中一定会抛出RuntimeException类型的运行时异常
	// 但因为它属于非受检异常，一般是程序员应该可以修改或避免的问题，不应该由程序来处理
	// 所以可以不用进行对此类异常的处理
	public void test5() throws RuntimeException{
		throw new RuntimeException("运行时异常-非受检");
	}
	
	public void test6(){
		test5();
	}
	
	public static void main(String[] args) throws IOException, SQLException {
		Exception01 e1 = new Exception01();
		e1.test2();
		e1.test4();
		e1.test6();
	}
}
