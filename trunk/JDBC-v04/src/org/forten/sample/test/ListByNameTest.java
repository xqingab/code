package org.forten.sample.test;

import java.sql.SQLException;
import java.util.List;

import org.forten.sample.bo.CourseBo;
import org.forten.sample.entity.Course;

public class ListByNameTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String name = "";
		List<Course> list = CourseBo.queryBy(name);
		for (Course course : list) {
			System.out.println(course);
		}
	}

}
