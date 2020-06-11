package org.forten.sample.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// File file = new File("c:\\test.txt");
		// File file = new File("c:"+File.separator+"test.txt");
		// 实例化一个文件对象，以文件的路径及文件名为参数
		File file = new File("c:/test.txt");

		// 判断文件对象是否存在，如果不存在，进入if块
		if (!file.exists()) {
			// 创建文件
			file.createNewFile();
		}

		File dir = new File("c:/test");
		File dir2 = new File("c:/abc/123/xyz");
		if (!dir.exists()) {
			// 只创建一层目录结构，不能用于创建多层目录结构
			dir.mkdir();
		}
		if (!dir2.exists()) {
			// 用于创建多层目录结构
			dir2.mkdirs();
			System.out.println("c:/abc/123/xyz创建完成");
		}

		// 删除方法如果删除的是目录，则要求被删除的目录应该为空目录
		// dir2.deleteOnExit();
		dir2.delete();
		
		
	}

}
