package org.forten.sample.test;

import java.sql.SQLException;
import java.util.Date;

import org.forten.sample.bo.UserBo;
import org.forten.sample.entity.User;

public class SaveDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int i = UserBo.doSave(new User("赵云", "M", new Date(), "123456", "skj@jkl.com"));
		System.out.println("Saved " + i);
	}
}
