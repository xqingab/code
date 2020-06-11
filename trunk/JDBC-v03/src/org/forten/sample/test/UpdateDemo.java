package org.forten.sample.test;

import java.sql.SQLException;

import org.forten.sample.bo.UserBo;

public class UpdateDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int i = UserBo.doUpdatePassword(7, "987321");
		
		System.out.println(i);
	}

}
