package org.forten.sample.test;

import java.sql.SQLException;
import java.util.List;

import org.forten.sample.bo.CourseBo;
import org.forten.sample.entity.Course;

public class ListAllTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Course> list = CourseBo.queryAll();
		for (Course course : list) {
			System.out.println(course);
		}
	}
}
