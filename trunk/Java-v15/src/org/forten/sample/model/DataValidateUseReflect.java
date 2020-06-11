package org.forten.sample.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.forten.sample.model.annotation.NotEmpty;

public class DataValidateUseReflect {
	public static boolean validate(Object obj){
		Class<?> clazz = obj.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			NotEmpty ann = method.getDeclaredAnnotation(NotEmpty.class);
			if(ann!=null){
				try {
					String str = (String) method.invoke(obj);
					if(str!=null&&str.trim().length()>0){
						continue;
					}else{
						System.out.println(ann.msg());
						return false;
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	/**
	 * 校验对象中的getName方法返回值是否是空串
	 * @param obj 要校验的对象
	 * @return 如果非空返回true；否则返回false
	 */
	public static boolean validateNameNotEmpty(Object obj) {
		// 最终返回结果
		boolean result = false;
		// 得到对象的类型元信息
		Class<?> cla = obj.getClass();
		// 描述getName方法的信息对象
		Method getNameMethod = null;
		try {
			// 获得参数对象类型中定义的getName方法对象
			getNameMethod = cla.getMethod("getName");
			// 调用这个对象的getName方法，并把返回值赋给name局部变量
			String name = (String) getNameMethod.invoke(obj);
			// 判断name是否是空串
			result = name != null && name.trim().length() > 0;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		// 返回结果
		return result;
	}
}
