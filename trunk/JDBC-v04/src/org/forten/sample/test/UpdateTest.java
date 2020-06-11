package org.forten.sample.test;

import java.sql.SQLException;

import org.forten.sample.bo.CourseBo;

public class UpdateTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int i = CourseBo.doUpdateCredit(5, 80);
		System.out.println(i);
	}

}
