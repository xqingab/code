package org.forten.sample.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyWithJavaAPI {

	public static void main(String[] args) {
		// 要复制的源文件目录及文件名
		File src = new File("c:/Windows/write.exe");
		// 得到到的目标目录及文件名
		File dist = new File("d:/写字板.exe");
		
		try(InputStream in = new FileInputStream(src);OutputStream out = new FileOutputStream(dist)){
			// 准备一个装文件内容的字节数组
			byte[] bytes = new byte[in.available()];
			// 把源文件的内容读取到这个数组中来
			in.read(bytes);
			// 把内容写入到目标文件中
			out.write(bytes);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("文件复制完毕");
	}

}
