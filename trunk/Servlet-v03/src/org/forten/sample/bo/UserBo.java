package org.forten.sample.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.forten.sample.entity.User;
import org.forten.sample.util.JDBCUtil;

public class UserBo {
	public static User login(String name, String password) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT id,name,role_name FROM test_user WHERE name=? AND password=?";

		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, name);
		stat.setString(2, password);

		ResultSet rs = stat.executeQuery();

		if (!rs.next()) {
			return null;
		}

		int id = rs.getInt("id");
		String uname = rs.getString(2);
		int roleName = rs.getInt(3);

		User user = new User(id, uname, "", roleName);

		JDBCUtil.close(conn, stat, rs);

		return user;
	}
}
