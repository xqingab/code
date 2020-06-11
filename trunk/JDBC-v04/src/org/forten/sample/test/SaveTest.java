package org.forten.sample.test;

import java.sql.SQLException;
import java.util.Date;

import org.forten.sample.bo.CourseBo;
import org.forten.sample.entity.Course;

public class SaveTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * int i = CourseBo.doSave(new Course("大学语文", "221", "李其", new Date(),
		 * 5)); int i = CourseBo.doSave(new Course("大学英语", "442", "张潮", new
		 * Date(), 4));
		 */
		int i = CourseBo.doSave(new Course("计算机基础文化", "1002", "粱辉", new Date(), 8));
		System.out.println(i);
	}

}
