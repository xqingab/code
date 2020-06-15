/**
 * Javadoc注释
 * 第一个Java程序
 * 传说中的HelloWorld
 */
// 以下这行定义了一个类，public是访问修饰符，定义了所修饰的程序成员为公有的
// class是类声明时使用的关键字，后边接类名。HelloWorld是类的名称
// 在类名后是一对花括号，花括号之间定义类的主体
// 所有的Java程序逻辑一定是封装在类中的
public class HelloWorld {
	/*
	 * 这里是多行注释
	 * 可以书写大篇幅的注释
	 * 也可以在一行中注释中间的某一部分
	 * Java中的各种注释在编译时都会被忽略
	 * Java中多行注释和Javadoc注释不可以嵌套
	 */
	// 以下一行定义了一个方法，这个方法是Java的主方法，也是这个类的执行入口
	// public表示这个方法是公有的
	// static表示这个方法是静态的，在本类没有被实例化成为对象之前就可以调用这个方法
	// void表示这个方法的返回类型是不返回任何内容
	// main是方法名
	// main后的一对圆括号中定义的是参数列表，可以有0到多个参数，多个参数之间要以逗号分隔
	// 在参数列表的圆括号后是一对花括号，定义了方法的方法主体，其中定义的是方法的逻辑
	public static void main(String[] args) {
		// 单行注释，从//开始一直到本行结束
		// 一条语句，每条语句在java中都必须以分号作为结束，换行不作为语句的结束符号
		// System是JavaSE API中的一个预定义类，此类提供对系统访问的能力
		// out是连接到控制台的一个输出流对象
		// println是输出流对象的一个方法，会把它的参数部分输出到控制台上，并加入一个换行。
		System.
		out.
		println("Hello World!");
	}
}

// 在一个Java源代码文件中可以定义多个class，但只能存在一个被public修改的class，并且这个public的class名称要与源代码的文件名完全一致
// 每个class在编译后都会生成一个独立的字节码文件
// 在一个Java源代码文件中定义多个class的行为是不推荐的，推荐在一个源代码文件中只定义一个公有类
class Example{
	
}