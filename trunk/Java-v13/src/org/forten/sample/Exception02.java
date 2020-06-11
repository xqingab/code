package org.forten.sample;

import java.io.IOException;
import java.sql.SQLException;

public class Exception02 {
	public void test1() throws IOException, SQLException {
		throw new IOException("磁盘已满");
	}

	public void test2() throws Error {
		throw new Error("错误");
	}

	public void test3() throws RuntimeException {
		throw new RuntimeException("运行时异常");
	}

	public static void main(String[] args) {
		Exception02 e2 = new Exception02();

		// 调用test1()方法时，因为可能会抛出受检异常，所以我们要对这些异常进行处理
		// 本例中不使用再次抛出，而改用内部消化的方法来处理异常：try-catch-finally
		// try块会尝试着执行test1()方法，如果没有发生异常，则会在执行完try块中所有语句后
		// 跳过所有catch块，执行finally块
		// catch块用于捕获各种try块中语句会抛出的异常对象，
		// 当抛出的某个异常对象与某个catch块要捕获的异常对象类型匹配时，
		// 程序就会进行到该catch块，执行它的逻辑
		// catch块执行完毕后会继续执行finally块
		// 无论try块中的语句是否会抛出异常，都会执行finally块中的语句，
		// 通常此块会被用于释放系统资源（如关闭数据库连接、关闭文件流等）
		// 如果try块出现，则至少要在其后跟一个catch块（1到多个），finally块是可选的（零到一个）

		// 如果在try-catch块后出现了finally块，并且在try或catch块中出现了return语句
		// 结果还是会先执行finally中的语句，然后再return
		// 当执行return时，发现有finally块，则先会挂起程序的返回，执行finally块，然后再执行被挂起的return
		
		// 异常处理方式的使用原则：早抛出，晚捕获。
		// 一定要注意：在catch块中一定要有异常处理的语句，至少要有对printStackTrace()方法的调用
		// 空的catch语句块虽然不会被报编译错误或警告，但它属性一类程序安全警告
		try {
			e2.test1();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			System.out.println("就是要执行~");
		}

		// e2.test2();
		// e2.test3();
	}

}
