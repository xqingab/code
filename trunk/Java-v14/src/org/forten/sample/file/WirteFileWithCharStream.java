package org.forten.sample.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WirteFileWithCharStream {

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

		Writer w = null;
		try {
			// 以替换方式写入字符
			// w = new FileWriter(file);
			// 以追加方式写入字符
			w = new FileWriter(file, true);
			// 向文件中写入内容
			w.write("清华大学在北京\n");
			// 把要向文件中写入的字符从内存中冲刷到目标文件上
			w.flush();
		} catch (IOException e) {
			System.out.println("文件写入失败");
			e.printStackTrace();
		} finally {
			try {
				// 关闭字符的输出流
				w.close();
			} catch (IOException e) {
				System.out.println("资源释放失败");
				e.printStackTrace();
			}
		}
		System.out.println("文件写入成功");
	}

}
