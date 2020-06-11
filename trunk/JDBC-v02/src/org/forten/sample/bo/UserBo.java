package org.forten.sample.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.forten.sample.entity.User;
import org.forten.sample.util.JDBCUtil;

public class UserBo {
	public static int save(String name, String gender, String birthday, String password, String email)
			throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		Statement stat = conn.createStatement();

		String sql = "INSERT INTO test_user (name,gender,birthday,password,email) VALUES ('" + name + "','" + gender
				+ "','" + birthday + "','" + password + "','" + email + "')";

		int count = stat.executeUpdate(sql);

		JDBCUtil.close(conn, stat);
		return count;
	}

	public static int save(User user) throws ClassNotFoundException, SQLException {
		Date b = user.getBirthday();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String bstr = sdf.format(b);
		return save(user.getName(), user.getGender(), bstr, user.getPassword(), user.getEmail());
	}

	public static int delete(int id) throws SQLException, ClassNotFoundException {
		Connection conn = JDBCUtil.getMySQLConnection();
		Statement stat = conn.createStatement();

		String sql = "DELETE FROM test_user WHERE id=" + id;

		int c = stat.executeUpdate(sql);
		return c;
	}

	public static int updatePassword(int id, String pwd) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		Statement stat = conn.createStatement();
		String sql = "UPDATE test_user SET password='" + pwd + "' WHERE id=" + id;
		int c = stat.executeUpdate(sql);
		return c;
	}

	public static List<User> queryByName(String name) throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<>();

		Connection conn = JDBCUtil.getMySQLConnection();
		Statement stat = conn.createStatement();

		String sql = "SELECT * FROM test_user WHERE name LIKE '%" + name + "%' ORDER BY birthday";
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
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

	public static List<User> queryAll() throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<>();

		Connection conn = JDBCUtil.getMySQLConnection();
		Statement stat = conn.createStatement();

		String sql = "SELECT * FROM test_user ORDER BY birthday";
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			Date birthday = rs.getDate("birthday");
			Timestamp registTime = rs.getTimestamp("regist_time");
			User u = new User(id, name, gender, birthday, password, email, registTime);
			list.add(u);
		}

		JDBCUtil.close(conn, stat, rs);

		return list;
	}
}
