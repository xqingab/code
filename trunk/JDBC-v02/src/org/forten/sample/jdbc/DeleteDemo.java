package org.forten.sample.jdbc;

import java.sql.SQLException;

import org.forten.sample.bo.UserBo;

public class DeleteDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int count = UserBo.delete(3);
		System.out.println("成功删除了"+count+"条数据");
	}

}
