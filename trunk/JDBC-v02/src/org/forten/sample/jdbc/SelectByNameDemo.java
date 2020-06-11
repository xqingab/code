package org.forten.sample.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.forten.sample.bo.UserBo;
import org.forten.sample.entity.User;

public class SelectByNameDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<User> list = UserBo.queryByName("");
		for (User user : list) {
			System.out.println(user);
		}
	}
}
