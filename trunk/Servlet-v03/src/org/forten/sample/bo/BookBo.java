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

import org.forten.sample.entity.Book;
import org.forten.sample.util.JDBCUtil;

public class BookBo {
	public static List<Book> queryAll() throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT * FROM test_book ORDER BY id DESC";
		Statement stat = conn.createStatement();

		ResultSet rs = stat.executeQuery(sql);
		List<Book> list = new ArrayList<>();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String author = rs.getString("author");
			String pubName = rs.getString("pub_name");
			double price = rs.getDouble("price");
			Date pubDate = rs.getDate("pub_date");
			Timestamp createTime = rs.getTimestamp("create_time");

			Book book = new Book(id, name, author, pubName, price, pubDate, createTime);
			list.add(book);
		}

		JDBCUtil.close(conn, stat, rs);

		return list;
	}

	public static int doDelete(int id) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "DELETE FROM test_book WHERE id=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, id);

		int i = stat.executeUpdate();
		JDBCUtil.close(conn, stat);

		if (i == 0) {
			throw new IllegalStateException("要被删除的id所对应的数据不存在");
		}

		return i;
	}

	public static Book queryBy(int id) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "SELECT * FROM test_book WHERE id=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, id);

		ResultSet rs = stat.executeQuery();
		if (!rs.next()) {
			return null;
		}

		int ids = rs.getInt("id");
		String name = rs.getString("name");
		String pubName = rs.getString("pub_name");
		String author = rs.getString("author");
		java.util.Date pubDate = rs.getDate("pub_date");
		java.util.Date createTime = rs.getTimestamp("create_time");
		double price = rs.getDouble("price");

		Book book = new Book(ids, name, author, pubName, price, pubDate, createTime);

		JDBCUtil.close(conn, stat, rs);
		return book;
	}

	public static int doSave(Book book) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "INSERT INTO test_book (name,author,pub_name,price,pub_date,create_time) "
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, book.getName());
		stat.setString(2, book.getAuthor());
		stat.setString(3, book.getPubName());
		stat.setDouble(4, book.getPrice());
		stat.setDate(5, new java.sql.Date(book.getPubDate().getTime()));
		stat.setTimestamp(6, new Timestamp(book.getCreateTime().getTime()));

		int i = stat.executeUpdate();
		JDBCUtil.close(conn, stat);

		return i;
	}

	public static int doUpdate(Book book) throws ClassNotFoundException, SQLException {
		Connection conn = JDBCUtil.getMySQLConnection();
		String sql = "UPDATE test_book SET name=?,author=?,price=?,pub_date=?,pub_name=? WHERE id=?";
		PreparedStatement stat = conn.prepareStatement(sql);

		stat.setString(1, book.getName());
		stat.setString(2, book.getAuthor());
		stat.setDouble(3, book.getPrice());
		stat.setDate(4, new java.sql.Date(book.getPubDate().getTime()));
		stat.setString(5, book.getPubName());
		stat.setInt(6, book.getId());

		int i = stat.executeUpdate();

		JDBCUtil.close(conn, stat);

		return i;
	}
}
