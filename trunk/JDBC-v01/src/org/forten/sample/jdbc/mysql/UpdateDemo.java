package org.forten.sample.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
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

		String sql = "UPDATE test_stu SET score=score-10 WHERE score>550";

		Statement stat = conn.createStatement();

		int i = stat.executeUpdate(sql);
		System.out.println("更新了" + i + "条数据");

		// 释放资源
		stat.close();
		conn.close();
	}
}
