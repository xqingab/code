package org.forten.sample.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.forten.sample.bo.UserBo;
import org.forten.sample.entity.User;

public class SelectAllDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection conn = JDBCUtil.getMySQLConnection();
		// Statement stat = conn.createStatement();
		//
		// String sql = "SELECT * FROM test_user ORDER BY birthday";
		// ResultSet rs = stat.executeQuery(sql);
		// while (rs.next()) {
		// int id = rs.getInt("id");
		// String name = rs.getString("name");
		// String email = rs.getString("email");
		// String password = rs.getString("password");
		// String gender = rs.getString("gender");
		// Date birthday = rs.getDate("birthday");
		// Timestamp registTime = rs.getTimestamp("regist_time");
		// System.out.println(id + "\t" + name + "\t" + password + "\t" + email
		// + "\t" + birthday + "\t" + gender
		// + "\t" + registTime);
		// }
		//
		// JDBCUtil.close(conn, stat, rs);

		List<User> list = UserBo.queryAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
