package org.forten.sample.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WirteFileWithCharStream2 {

	public static void main(String[] args) {
		File file = new File("c:/test.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("创建文件失败");
				e.printStackTrace();
			}
		}

		// 以替换方式写入字符
		// w = new FileWriter(file);
		// 以追加方式写入字符
		
		// JavaSE7以后出现的资源自动关闭语法
		// 被声明在try关键字后括号中的对象会在try块或catch块执行完毕后进行自动的释放
		// 这个对象的类一定实现了java.lang.AutoCloseable接口
		try(Writer w = new FileWriter(file, true);) {
			// 向文件中写入内容
			w.write("北京大学也在北京\n");
			// 把要向文件中写入的字符从内存中冲刷到目标文件上
			w.flush();
		} catch (IOException e) {
			System.out.println("文件写入失败");
			e.printStackTrace();
		}
		System.out.println("文件写入成功");
	}

}
