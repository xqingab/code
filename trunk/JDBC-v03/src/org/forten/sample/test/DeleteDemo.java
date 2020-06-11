package org.forten.sample.test;

import java.sql.SQLException;

import org.forten.sample.bo.UserBo;

public class DeleteDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int i = UserBo.doDeleteById(6);
		System.out.println(i);
	}

}
