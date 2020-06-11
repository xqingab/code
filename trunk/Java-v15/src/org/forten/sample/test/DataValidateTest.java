package org.forten.sample.test;

import org.forten.sample.model.Car;
import org.forten.sample.model.Course;
import org.forten.sample.model.DataValidateUseReflect;
import org.forten.sample.model.User;

public class DataValidateTest {
	public static void main(String[] args) {
		User u1 = new User("", "M", 30);
		System.out.println(DataValidateUseReflect.validate(u1));
		User u2 = new User("Tom", "M", 30);
		System.out.println(DataValidateUseReflect.validate(u2));
		User u3 = new User("Tom", "", 30);
		System.out.println(DataValidateUseReflect.validate(u3));
		
		Car c1 = new Car("F22", 30000, 100);
		Car c2 = new Car("", 30000, 100);
		System.out.println(DataValidateUseReflect.validate(c1));
		System.out.println(DataValidateUseReflect.validate(c2));
		
		Course co1 = new Course("Java","228", "周五第二节","张良");
		Course co2 = new Course("","228", "周五第二节","张良");
		Course co3 = new Course("Java","", "周五第二节","张良");
		System.out.println(DataValidateUseReflect.validate(co1));
		System.out.println(DataValidateUseReflect.validate(co2));
		System.out.println(DataValidateUseReflect.validate(co3));
	}
}
