package org.forten.sample.jdbc.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 加载要连接的数据库的主驱动类
		// 通知Java，要连接的数据库是MySQL的
		Class.forName("com.mysql.jdbc.Driver");

		// 连接数据库用的用户名
		String username = "root";
		// 连接数据库用的密码
		String password = "123456";
		// 设置连接数据库的URL，通知Java接连哪个数据库：jdbc:mysql://主机:端口/数据库名?characterEncoding=字符集
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";

		// 让Java程序获得对Mysql的数据库连接
		Connection conn = DriverManager.getConnection(url, username, password);

		String sql = "SELECT * FROM test_stu";

		Statement stat = conn.createStatement();

		// executeQuery(sql)方法会执行sql语句的查询逻辑，得到数据结果集合（rs）对象
		// rs中是若干记录组成的数据集合，每一行由若干列的值构成（单元格）
		// rs是可以被迭代的，最初指针会指在第一行数据之前的位置
		ResultSet rs = stat.executeQuery(sql);

		// 遍历数据结果集合（rs）对象中的数据，并打印
		// next()方法可以向下移动指针，同时返回是否还有下一行数据的boolean值
		while (rs.next()) {
			// 通过rs的getXXX(列索引)方法可以得到某个单元格中的值，注意列的索引值是从1开始，XXX是指返回值的类型
			int id = rs.getInt(1);
			String name = rs.getString(2);
			// 还可以通过rs.getXXX(列名)来得到某个单元素格中的值
			Date birthday = rs.getDate("birthday");
			double score = rs.getDouble(4);
			System.out.println(id + "\t" + name + "\t" + birthday + "\t" + score);
		}

		rs.close();
		stat.close();
		conn.close();
	}

}
