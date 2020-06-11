package org.forten.sample.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.forten.sample.model.User;
import org.forten.sample.model.annotation.NotEmpty;

public class ReflectTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// 模拟出一个已经被实例化好的User对象
		User user = new User("Tom", "男", 30);

		// Class类是描述一个对象所属类型的类
		// Class的对象就是描述某个对象类型的对象（类的元信息描述）
		// 通过对象引用的getClass()方法可以获得一个对象的类型对象
		Class<?> clazz = user.getClass();

		// 通过getName()方法可以得到类型的全限定名称（带包名的类名称）
		System.out.println("类的全限定名称是：" + clazz.getName());
		// 通过getSimpleName()方法可以得到类型的简称（不带包名的类名称）
		System.out.println("类的简称是：" + clazz.getSimpleName());

		// 通过getSuperclass()方法可以得到描述此类所继承的那个父类Class的对象
		Class<?> superClass = clazz.getSuperclass();
		System.out.println("父类的全限定名称是：" + superClass.getName());
		System.out.println("父类的简称是：" + superClass.getSimpleName());

		// 通过getInterfaces()方法可以得到描述此类所实现的所有接口Class对象的数组
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> jk : interfaces) {
			System.out.println("接口的全限定名称是：" + jk.getName());
			System.out.println("接口的简称是：" + jk.getSimpleName());
		}

		// 通过getConstructors()方法可以得到类中所有构造方法对象组成的一个数组
		// Constructor类描述的是构造方法的元信息
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> c : constructors) {
			System.out.println(c.getName());
			// getParameterCount()方法可以返回一个构造方法的参数数量
			System.out.println(c.getParameterCount());
		}

		// 通过getConstructor(Class<?>...)方法可以按照参数类型和个数来精准获得类中的某一个构造方法对象
		Constructor<?> noParamCon = clazz.getConstructor();
		System.out.println("无参构造方法的参数数量是：" + noParamCon.getParameterCount());
		// 可以通过类或基本数据类型.class的语法来直接得到描述它们类型元信息的Class对象
		Constructor<?> hasParamCon = clazz.getConstructor(String.class, String.class, int.class);
		System.out.println("有参构造方法的参数数量是：" + hasParamCon.getParameterCount());

		// Constructor对象的newInstance(Object...)方法可以实例化一个对象
		// 与通过new关键字调用这个构造方法的作用一致
		User user2 = (User) hasParamCon.newInstance("Mike", "男", 20);
		System.out.println(user2);
		
		// Field类是用于描述类中实例变量的类型
		// 通过getDeclaredFields()方法可以得到类中所有被声明的实例对象的元信息对象（Field类型的对象数组）
		Field[] allFields = clazz.getDeclaredFields();
		for (Field field : allFields) {
			// 通过setAccessible(boolean)方法可以设计一个实例变量的可访问性
			field.setAccessible(true);
			// getName()方法可以得到实例变量的名字
			// filed.get(object)的含义是从object对象获得field对象所描述的实例变量的值
			// 这就是利用反射技术对某个对象的实例变量进行访问的方式
			System.out.println(field.getName()+"="+field.get(user));
			field.setAccessible(false);
		}
		
		// 通过getDeclaredField(String)方法可以按实例变量名得到某个实例变量对象
		Field nameField = clazz.getDeclaredField("name");
		nameField.setAccessible(true);
		System.out.println(nameField.get(user));
		System.out.println(nameField.get(user2));
		nameField.setAccessible(false);
		
		// getDeclaredMethods()方法得到的是本类中定义的方法对象
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println(clazz.getSimpleName()+"中定义了以下方法：");
		for (Method method : methods) {
			System.out.println("\t"+method.getName());
		}
		System.out.println("============================");
		// getMethods()方法得到的是本类及其所有父类中定义的方法对象
		methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println("\t"+method.getName());
		}
		
		// 通过getDeclaredMethod(String,Class<?>...)获得某个特定的方法对象
		Method getNameMethod = clazz.getDeclaredMethod("getName");
		Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
		
		// 通过反射技术调用方法对象对应的方法
		// method.invoke(obj,paramValues)=》obj.methodName(paramValues)
		System.out.println(getNameMethod.invoke(user));
		System.out.println(getNameMethod.invoke(user2));
		setNameMethod.invoke(user, "Jack");
		setNameMethod.invoke(user2, "张飞");
		System.out.println(getNameMethod.invoke(user));
		System.out.println(getNameMethod.invoke(user2));
		
		User u = (User) clazz.newInstance();
		System.out.println(u);
		
		methods = clazz.getDeclaredMethods();
		System.out.println(clazz.getSimpleName()+"类中标有@NotEmpty注解的方法有以下几个：");
		for (Method method : methods) {
			NotEmpty ann = method.getDeclaredAnnotation(NotEmpty.class);
			if(ann!=null){
				System.out.println(method.getName());
			}
		}
	}

}
