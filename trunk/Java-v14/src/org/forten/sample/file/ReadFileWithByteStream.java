package org.forten.sample.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileWithByteStream {

	public static void main(String[] args) {
		File file = new File("c:/HelloWorld.java");
		
		// 使用java7的资源自动释放语法进行资源对象的声明和实例化
		try(InputStream in = new FileInputStream(file)){
			// 实例化了一个字节数组对象，容量是文件流的长度，此时它是空的
			byte[] arr = new byte[in.available()];
			// 从流中把文件的字节内容读取到字节数组中
			// 即把外部的文件内容转换成为Java程序可以识别的字节数组类型对象
			in.read(arr);
			// 把已经被文件内容填充好的字节数组转换成为字符串
			String s = new String(arr);
			System.out.println(s);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
