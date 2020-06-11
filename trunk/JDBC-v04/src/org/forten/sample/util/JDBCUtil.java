package org.forten.sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCUtil {
	/**
	 * 使用与数据库服务器直接连接的方式打开连接
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param driver
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection(String url, String username, String password, String driver)
			throws ClassNotFoundException, SQLException {
		// 加载要连接的数据库的主驱动类
		// 通知Java，要连接的数据库是MySQL的
		Class.forName(driver);

		// 让Java程序获得对Mysql的数据库连接
		Connection conn = DriverManager.getConnection(url, username, password);

		return conn;
	}

	/**
	 * 使用从数据库连接池中获得已有连接的方式打开连接
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param driver
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnectionFromDBCP(String url, String username, String password, String driver) {
		try (BasicDataSource ds = new BasicDataSource()) {
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			// 设置数据库连接池中初始化时打开的连接数量
			ds.setInitialSize(10);
			// 设置数据库连接池中最多打开的连接数量
			ds.setMaxTotal(30);
			// 设置数据库连接池中最多保持的空闲连接数量
			ds.setMaxIdle(5);
			// 设置数据库连接池中最少保持的空闲连接数量
			ds.setMinIdle(2);
			// 设置数据库连接池中的最大等待时间
			ds.setMaxWaitMillis(60000);

			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		return getConnectionFromDBCP("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "123456",
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
