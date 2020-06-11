package org.forten.sample.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFileWithByteStream {

	public static void main(String[] args) {
		// 目标文件
		File file = new File("c:/HelloWorld.java");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 使用java7的资源自动释放语法进行资源对象的声明和实例化
		try (OutputStream out = new FileOutputStream(file);) {
			// 要写入的内容
			String s1 = "public class HelloWorld{\n";
			String s2 = "\tpublic static void main(String[] args){\n";
			String s3 = "\t\tSystem.out.println(\"Hello World!\");\n";
			String s4 = "\t}\n";
			String s5 = "}";
			String str = s1 + s2 + s3 + s4 + s5;
			// 把要写入的字符转换成为字节数组
			byte[] arr = str.getBytes();
			// 把字符转换成为的字节数组（内容）写入到输出流中
			// 因为此时的out引用的是FileOutputStream类型的对象
			// 所以out会把内容输出到一个文件中
			out.write(arr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("写入完毕");
	}

}
