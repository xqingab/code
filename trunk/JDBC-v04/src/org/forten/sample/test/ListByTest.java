package org.forten.sample.test;

import java.sql.SQLException;
import java.util.List;

import org.forten.sample.bo.CourseBo;
import org.forten.sample.entity.Course;

public class ListByTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Course> list = CourseBo.queryBy("", "", null, null);
		for (Course course : list) {
			System.out.println(course);
		}
		
		System.out.println("============================");
		
		list = CourseBo.queryBy("大", "", null, null);
		for (Course course : list) {
			System.out.println(course);
		}
		System.out.println("============================");
		
		list = CourseBo.queryBy("", "辉", null, null);
		for (Course course : list) {
			System.out.println(course);
		}
		
		System.out.println("============================");
		
		list = CourseBo.queryBy("", "", 0, 10);
		for (Course course : list) {
			System.out.println(course);
		}
		
		System.out.println("============================");
		list = CourseBo.queryBy("英", "", 0, 10);
		for (Course course : list) {
			System.out.println(course);
		}
		System.out.println("============================");
		list = CourseBo.queryBy("", "李", 0, 10);
		for (Course course : list) {
			System.out.println(course);
		}
		System.out.println("============================");
		list = CourseBo.queryBy("没", "李", 0, 10);
		for (Course course : list) {
			System.out.println(course);
		}
	}

}
