package org.forten.sample.bo;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.forten.sample.entity.Book;
import org.forten.sample.util.JDBCUtil;
import org.junit.Before;
import org.junit.Test;

public class BookBoTest {
	@Before
	public void init() throws ClassNotFoundException, SQLException {
		String dropSql = "DROP TABLE IF EXISTS test_book";
		String createSql = "CREATE TABLE test_book (id int(10) primary key AUTO_INCREMENT,name varchar(80),"
				+ "author varchar(30),pub_name varchar(50)," + "price double(6,2),pub_date date,create_time datetime)";
		String insertSql1 = "INSERT INTO test_book (name,author,pub_name,price,pub_date,create_time) "
				+ "VALUES ('新华字典','鲁迅','三味书屋',38.2,'1983-05-20','2015-01-03 08:34:22')";
		String insertSql2 = "INSERT INTO test_book (name,author,pub_name,price,pub_date,create_time) "
				+ "VALUES ('红楼梦','曹雪芹','大清邮电出版社',302,'1973-01-22','2013-11-30 18:04:32')";
		String insertSql3 = "INSERT INTO test_book (name,author,pub_name,price,pub_date,create_time) "
				+ "VALUES ('Java基础教程','张小良','电子工业出版社',68,'2014-12-30','2015-01-05 10:10:10')";
		String insertSql4 = "INSERT INTO test_book (name,author,pub_name,price,pub_date,create_time) "
				+ "VALUES ('面向对象程序设计','刘伟','人民邮电出版社',89,'2013-10-03','2013-11-01 09:30:30')";
		String insertSql5 = "INSERT INTO test_book (name,author,pub_name,price,pub_date,create_time) "
				+ "VALUES ('Oracle数据库管理','马宣','人民邮电出版社',65,'2015-04-23','2015-04-30 15:30:30')";

		Connection conn = JDBCUtil.getMySQLConnection();
		Statement stat = conn.createStatement();

		stat.execute(dropSql);
		stat.execute(createSql);
		stat.executeUpdate(insertSql1);
		stat.executeUpdate(insertSql2);
		stat.executeUpdate(insertSql3);
		stat.executeUpdate(insertSql4);
		stat.executeUpdate(insertSql5);

		JDBCUtil.close(conn, stat);
	}

	@Test
	public void testQueryAll() throws Exception {
		List<Book> list = BookBo.queryAll();
		assertNotNull(list);
		assertEquals(5, list.size());
		assertEquals(5, list.get(0).getId());
	}

	@Test
	public void testDoDelete() throws Exception {
		List<Book> list = BookBo.queryAll();
		assertNotNull(list);
		assertEquals(5, list.size());
		assertEquals(5, list.get(0).getId());

		int i = BookBo.doDelete(5);
		assertEquals(1, i);

		list = BookBo.queryAll();
		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals(4, list.get(0).getId());
	}

	@Test(expected = IllegalStateException.class)
	public void testDoDeleteWhenIdNotExist() throws Exception {
		BookBo.doDelete(10);
		fail("此处应该抛出IllegalStateException");
	}

	@Test
	public void testDoSave() throws Exception {
		Book book = new Book("new book", "someone", "ABC", 1000, new Date());

		int i = BookBo.doSave(book);
		assertEquals(1, i);

		List<Book> list = BookBo.queryAll();
		assertNotNull(list);
		assertEquals(6, list.size());
		assertEquals(6, list.get(0).getId());
	}

	@Test(expected = SQLException.class)
	public void testDoSaveWithNameTooLong() throws Exception {
		Book book = new Book(
				"new booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew booknew book",
				"someone", "ABC", 1000, new Date());

		BookBo.doSave(book);
		fail("由于name的值过长，所以此处应该抛出异常");
	}

	@Test
	public void testQueryById() throws Exception {
		Book book = BookBo.queryBy(1);

		assertNotNull(book);
		assertEquals(1, book.getId());
		assertEquals("新华字典", book.getName());
	}

	@Test(expected = NullPointerException.class)
	public void testQueryByIdWhenIdNotExist() throws Exception {
		Book book = BookBo.queryBy(10);

		assertNull(book);
		book.getName();
		fail("应该抛出NullPointerException，而未得到");
	}

	@Test
	public void testDoUpdate() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(1983, 4, 20);
		Date pubDate = cal.getTime();

		cal.set(2015, 0, 3, 8, 34, 22);
		Date createTime = cal.getTime();

		Book book = new Book(1, "新华字典", "鲁迅", "三味书屋", 38.2, pubDate, createTime);
		
		book.setAuthor("茅盾");
		
		int i = BookBo.doUpdate(book);
		
		assertEquals(1, i);
		
		book = BookBo.queryBy(1);
		assertEquals("茅盾", book.getAuthor());
	}
}
