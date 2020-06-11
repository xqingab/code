package org.forten.sample.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.forten.sample.entity.Course;
import org.forten.sample.util.JDBCUtil;

public class CourseBo {
	public static int doSave(Course c) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "INSERT INTO test_course (name,teacher,teach_time,credit,classroom) VALUES (?,?,?,?,?)";

		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(2, c.getTeacher());
		stat.setString(1, c.getName());
		stat.setTimestamp(3, new Timestamp(c.getTeachTime().getTime()));
		stat.setString(5, c.getClassroom());
		stat.setInt(4, c.getCredit());

		int i = stat.executeUpdate();

		JDBCUtil.close(conn, stat);
		return i;
	}

	public static int doDelete(int id) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "DELETE FROM test_course WHERE id=?";

		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, id);

		int i = stat.executeUpdate();
		JDBCUtil.close(conn, stat);
		return i;
	}

	public static int doUpdateCredit(int id, int credit) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "UPDATE test_course SET credit=? WHERE id=?";

		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(2, id);
		stat.setInt(1, credit);

		int i = stat.executeUpdate();
		JDBCUtil.close(conn, stat);

		return i;
	}

	public static List<Course> queryAll() throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT * FROM test_course";

		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);

		List<Course> list = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String classroom = rs.getString("classroom");
			String teacher = rs.getString("teacher");
			int credit = rs.getInt("credit");
			Date teachTime = rs.getTimestamp("teach_time");

			Course c = new Course(id, name, classroom, teacher, teachTime, credit);
			list.add(c);
		}

		JDBCUtil.close(conn, stat, rs);

		return list;
	}

	public static int queryCount() throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT count(id) FROM test_course";

		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);

		rs.next();
		return rs.getInt(1);
	}

	public static List<Course> queryBy(String name) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT * FROM test_course WHERE name LIKE ?";

		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, "%" + name + "%");

		ResultSet rs = stat.executeQuery();
		List<Course> list = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String uname = rs.getString(2);
			String classroom = rs.getString("classroom");
			String teacher = rs.getString("teacher");
			int credit = rs.getInt("credit");
			Date teachTime = rs.getTimestamp("teach_time");

			Course c = new Course(id, uname, classroom, teacher, teachTime, credit);
			list.add(c);
		}

		JDBCUtil.close(conn, stat, rs);

		return list;
	}

	public static List<Course> queryBy(String name, String teacher, Integer minCredit, Integer maxCredit)
			throws ClassNotFoundException, SQLException {
		// 按照用户输入的条件值进行SQL语句查询逻辑的动态封装
		String sql = "SELECT * FROM test_course WHERE 1=1 ";
		if (name != null && !name.trim().equals("")) {
			sql = sql + "AND name LIKE ? ";
		}
		if (teacher != null && !teacher.trim().equals("")) {
			sql = sql + "AND teacher LIKE ? ";
		}
		if (minCredit != null && maxCredit != null) {
			sql = sql + "AND credit BETWEEN ? AND ? ";
		}

		Connection conn = JDBCUtil.getMySQLConnection();
		PreparedStatement stat = conn.prepareStatement(sql);

		if (name != null && !name.trim().equals("")) {
			stat.setString(1, "%" + name + "%");
		}
		if (teacher != null && !teacher.trim().equals("")) {
			if (name != null && !name.trim().equals("")) {
				stat.setString(2, "%" + teacher + "%");
			} else {
				stat.setString(1, "%" + teacher + "%");
			}
		}
		if (minCredit != null && maxCredit != null) {
			if (name != null && !name.trim().equals("")) {
				if (teacher != null && !teacher.trim().equals("")) {
					stat.setInt(3, minCredit);
					stat.setInt(4, maxCredit);
				} else {
					stat.setInt(2, minCredit);
					stat.setInt(3, maxCredit);
				}

			} else {
				if (teacher != null && !teacher.trim().equals("")) {
					stat.setInt(2, minCredit);
					stat.setInt(3, maxCredit);
				} else {
					stat.setInt(1, minCredit);
					stat.setInt(2, maxCredit);
				}
			}
		}

		ResultSet rs = stat.executeQuery();
		List<Course> list = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String uname = rs.getString(2);
			String classroom = rs.getString("classroom");
			String t = rs.getString("teacher");
			int credit = rs.getInt("credit");
			Date teachTime = rs.getTimestamp("teach_time");

			Course c = new Course(id, uname, classroom, t, teachTime, credit);
			list.add(c);
		}

		JDBCUtil.close(conn, stat, rs);

		return list;
	}
}
