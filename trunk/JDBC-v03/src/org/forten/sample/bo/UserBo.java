package org.forten.sample.bo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.forten.sample.entity.User;
import org.forten.sample.util.JDBCUtil;

public class UserBo {
	public static int doSave(User user) throws ClassNotFoundException, SQLException {
		// 获得MySQL数据库的连接
		Connection conn = JDBCUtil.getMySQLConnection();
		// 以参数占位符（？）的形式编写要执行的SQL语句，每个参数以一个问号代替
		String sql = "INSERT INTO test_user (name,gender,birthday,password,email) VALUES (?,?,?,?,?)";
		// 把使用了参数占位符的SQL语句创建成为JDBC的准备语句对象（PreparedStatement）
		PreparedStatement stat = conn.prepareStatement(sql);

		// 进行参数值与SQL语句中参数占位符之间的绑定
		// 使用准备语句对象的setXXX(index,value)方法来进行参数的绑定，XXX是要绑定参数的类型
		// 其中index是占位符的索引号，从1开始
		// value是参数的值
		stat.setString(1, user.getName());
		stat.setString(2, user.getGender());
		// 在进行日期类型数据绑定时需要注意，setDate(index,date)方法中的date是java.sql.Date类型
		// 把一个java.util.Date对象转型成为java.sql.Date需要先得到java.util.Date的毫秒数（getTime()）
		// 把这个毫秒数传递给java.sql.Date的构造方法
		stat.setDate(3, new Date(user.getBirthday().getTime()));
		stat.setString(4, user.getPassword());
		stat.setString(5, user.getEmail());

		// 执行SQL语句，注意，这里不要把sql语句的字符串再以参数的形式传递给executeUpdate()方法了
		int c = stat.executeUpdate();

		// 释放数据库资源
		JDBCUtil.close(conn, stat);

		return c;
	}

	public static int doUpdatePassword(int id, String pwd) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "UPDATE test_user SET password=? WHERE id=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		
		stat.setString(1, pwd);
		stat.setInt(2, id);
		
		int c = stat.executeUpdate();
		
		JDBCUtil.close(conn, stat);
		
		return c;
	}

	public static int doDeleteById(int id) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "DELETE FROM test_user WHERE id=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		
		stat.setInt(1, id);
		
		int c = stat.executeUpdate();
		
		JDBCUtil.close(conn, stat);
		
		return c;
	}

	public static List<User> queryAll() throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		Statement stat = conn.createStatement();
		String sql = "SELECT * FROM test_user ORDER BY regist_time DESC";
		ResultSet rs = stat.executeQuery(sql);
		
		List<User> list = new ArrayList<>();
		while(rs.next()){
			int id = rs.getInt("id");
			String uname = rs.getString("name");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			Date birthday = rs.getDate("birthday");
			Timestamp registTime = rs.getTimestamp("regist_time");
			User u = new User(id, uname, gender, birthday, password, email, registTime);
			list.add(u);
		}
		
		JDBCUtil.close(conn, stat, rs);
		
		return list;
	}

	public static List<User> queryByName(String name) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT * FROM test_user WHERE name LIKE ? ORDER BY regist_time DESC";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, "%"+name+"%");
		ResultSet rs = stat.executeQuery();
		
		List<User> list = new ArrayList<>();
		while(rs.next()){
			int id = rs.getInt("id");
			String uname = rs.getString("name");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			Date birthday = rs.getDate("birthday");
			Timestamp registTime = rs.getTimestamp("regist_time");
			User u = new User(id, uname, gender, birthday, password, email, registTime);
			list.add(u);
		}
		
		JDBCUtil.close(conn, stat, rs);
		
		return list;
	}
}
