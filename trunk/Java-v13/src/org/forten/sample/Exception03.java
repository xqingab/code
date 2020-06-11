package org.forten.sample;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.sql.SQLException;
import java.util.Random;

public class Exception03 {
	public void test() throws IOException, SQLException, CharacterCodingException, ClassNotFoundException, Exception {
		Random r = new Random();
		int n = r.nextInt(6);
		System.out.println(n);
		switch (n) {
		case 1:
			throw new SQLException("SQLException");
		case 2:
			throw new IOException("IOException");
		case 3:
			throw new CharacterCodingException();
		case 4:
			throw new ClassNotFoundException("类未找到");
		case 5:
			throw new Exception("Exception");
		default:
			System.out.println("执行完毕");
			break;
		}
	}

	public static void main(String[] args) {
		Exception03 e3 = new Exception03();
		// 在捕获多个异常对象时，应该把更特殊（具体）的异常类型的catch块放到前面，更一般（抽象）的异常类型的catch块放到后面
		// 否则会得到不能到达引语句块的编译错误
		try {
			e3.test();
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("释放资源了~~");
		}
	}

}
