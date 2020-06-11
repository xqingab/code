package org.forten.sample.jdbc;

import java.sql.SQLException;

import org.forten.sample.bo.UserBo;

public class UpdateDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int c = UserBo.updatePassword(2, "abc123");
		System.out.println("修改了" + c + "条数据");
		
	}

}
