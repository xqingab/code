package org.forten.sample.test;

import java.sql.SQLException;

import org.forten.sample.bo.CourseBo;

public class DeleteTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int i = CourseBo.doDelete(4);
		System.out.println(i);
	}
}
