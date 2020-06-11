package org.forten.sample.file;

import java.io.File;
import java.util.Date;

public class FileMethodTest {
	public static void main(String[] args) {
		File file = new File("c:/test.txt");
		// 判断文件是否可以执行
		System.out.println(file.canExecute());
		// 判断文件是否可以读取
		System.out.println(file.canRead());
		// 判断文件是否可以写入
		System.out.println(file.canWrite());
		
		// 设置文件只读
		file.setReadOnly();
		// 判断文件是否隐藏
		System.out.println(file.isHidden());
		// 得到文件的最后修改时间
		System.out.println(new Date(file.lastModified()));
		// 得到文件的绝对路径
		System.out.println(file.getAbsolutePath());
		// 判断文件对象是否是文件
		System.out.println(file.isFile());
		// 判断文件对象是否是目录
		System.out.println(file.isDirectory());
	}
}
