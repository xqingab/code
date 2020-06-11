package org.forten.sample.jdbc;

import java.sql.SQLException;
import java.util.Date;

import org.forten.sample.bo.UserBo;
import org.forten.sample.entity.User;

public class InsertIntoDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 简单使用对获得数据库连接和关闭逻辑的封装，进行数据的保存
		// Connection conn = JDBCUtil.getMySQLConnection();
		// Statement stat = conn.createStatement();
		//
		// String sql = "INSERT INTO test_user"+
		// "(name,gender,birthday,password,email) VALUES"
		// +"('张小辽','M','1990-06-21','abcdefg','slkdjf@j.com')";
		//
		// int count = stat.executeUpdate(sql);
		//
		// JDBCUtil.close(conn, stat);
		//
		// System.out.println("成功添加了" + count + "个用户");

		// 使用了对用户数据操作的逻辑封装，把多个值保存为一条用户记录
		// int i = UserBo.save("曹操", "M", "1970-01-03", "abcde",
		// "caocao@163.com");
		// System.out.println("成功添加了" + i + "个用户");

		// 对用户信息进行了类的封装，使用以用户类型为参数的保存方法来进行用户的注册
		User u = new User("张飞", "M", new Date(), "8329389", "zf@sl.com");
		int i = UserBo.save(u);
		System.out.println("成功添加了" + i + "个用户");
	}

}
