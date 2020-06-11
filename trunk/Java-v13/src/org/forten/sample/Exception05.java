package org.forten.sample;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.sql.SQLException;
import java.util.Random;

public class Exception05 {
	public static void test() throws IOException, SQLException, CharacterCodingException, ClassNotFoundException {
		Random r = new Random();
		int n = r.nextInt(5);
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
		default:
			System.out.println("执行完毕");
			break;
		}
	}

	public static void main(String[] args) {
		// Java7以后出现的多异常对象捕获语法，可以在一个catch块中捕获多种异常类型的对象
		// 语法是catch(异常类型1 | 异常类型2 | 异常类型3 | .... | 异常类型n e)
		// 其异常的捕获顺序还应该是从特殊到一般的，
		// 更具体的异常类型的catch块应该放在前面，更抽象的异常类型的catch块应该在后面捕获
		try {
			test();
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
