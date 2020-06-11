package org.forten.sample.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.forten.sample.entity.User;
import org.forten.sample.util.JDBCUtil;

public class UserBo {
	public static List<User> queryAll() throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT * FROM test_user ORDER BY id DESC";
		Statement stat = conn.createStatement();

		ResultSet rs = stat.executeQuery(sql);

		List<User> list = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String gender = rs.getString("gender");
			int age = rs.getInt("age");

			User user = new User(id, name, "你看我不到", email, gender, age);
			list.add(user);
		}

		JDBCUtil.close(conn, stat, rs);

		return list;
	}

	public static User queryBy(int id) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT * FROM test_user WHERE id=?";
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setInt(1, id);
		ResultSet rs = stat.executeQuery();

		if (!rs.next()) {
			return null;
		}

		String name = rs.getString("name");
		String email = rs.getString("email");
		String gender = rs.getString("gender");
		int age = rs.getInt("age");

		User user = new User(id, name, "你看我不到", email, gender, age);

		JDBCUtil.close(conn, stat, rs);
		return user;
	}

	public static int doRegist(User user) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "INSERT INTO test_user (name,password,email,gender,age) VALUES (?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, user.getName());
		stat.setString(2, user.getPassword());
		stat.setString(3, user.getEmail());
		stat.setString(4, user.getGender());
		stat.setInt(5, user.getAge());

		int i = stat.executeUpdate();

		JDBCUtil.close(conn, stat);

		return i;
	}

	public static int doUpdate(User user) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "UPDATE test_user SET name=?,email=?,gender=?,age=? WHERE id=?";
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, user.getName());
		stat.setString(2, user.getEmail());
		stat.setString(3, user.getGender());
		stat.setInt(4, user.getAge());
		stat.setInt(5, user.getId());

		int i = stat.executeUpdate();
		JDBCUtil.close(conn, stat);
		return i;
	}

	public static int doDelete(int id) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "DELETE FROM test_user WHERE id=?";
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setInt(1, id);
		int i = stat.executeUpdate();

		JDBCUtil.close(conn, stat);

		return i;
	}
}
