package org.forten.sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection(String url, String username, String password, String driver)
			throws ClassNotFoundException, SQLException {
		// 加载要连接的数据库的主驱动类
		// 通知Java，要连接的数据库是MySQL的
		Class.forName(driver);

		// 让Java程序获得对Mysql的数据库连接
		Connection conn = DriverManager.getConnection(url, username, password);

		return conn;
	}

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		return getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "123456",
				"com.mysql.jdbc.Driver");
	}

	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
		return getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "123456", "oracle.jdbc.driver.OracleDriver");
	}

	public static void close(Connection conn, Statement stat) throws SQLException {
		if (stat != null) {
			stat.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public static void close(Connection conn, Statement stat, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stat != null) {
			stat.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
