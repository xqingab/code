package org.forten.sample.test;

import java.sql.SQLException;

import org.forten.sample.bo.CourseBo;

public class GetCountTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int c = CourseBo.queryCount();
		System.out.println(c);
	}

}
