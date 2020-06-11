package org.forten.sample.model;

// 不使用反射技术进行项目中数据对象name属性非空校验
// 对于每一种类型的数据都要写一个方法来进行校验，且这些方法是很相似的
// 在日后的数据类型添加情况出现时，需要不断对这种类进行修改
public class DataValidate {
	public static boolean validate(User u) {
		return u.getName() != null && u.getName().trim().length() > 0;
	}

	public static boolean validate(Car car) {
		return car.getName() != null && car.getName().trim().length() > 0;
	}

	public static boolean validate(Movie movie) {
		return movie.getName() != null && movie.getName().trim().length() > 0;
	}
}
