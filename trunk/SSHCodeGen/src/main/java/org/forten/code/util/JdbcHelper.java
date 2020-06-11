package org.forten.code.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcHelper {
	public static Connection getConnection(String driverName, String url,
			String userName, String password) {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn, Statement stat) {
		closeStatement(stat);
		closeConnection(conn);
	}

	public static void close(Connection conn, Statement stat, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(stat);
		closeConnection(conn);
	}

	private static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

			} finally {
				conn = null;
			}
		}
	}

	private static void closeStatement(Statement stat) {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {

			} finally {
				stat = null;
			}
		}
	}

	private static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

			} finally {
				rs = null;
			}
		}
	}
}
