package org.forten.sample.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadFileWithCharStream {

	public static void main(String[] args) {
		// 实例化要被读取的文件对象
		File file = new File("c:/test.txt");

		// 声明临时存放文件内容的字符数组
		// file的length方法可以获得文件的内容的长度
		char[] charArr = new char[(int) file.length()];

		// 每次读取的字符
		int temp = 0;
		// 读取字符的计数器
		int count = 0;

		Reader r = null;
		try {
			r = new FileReader(file);
			// 使用Reader的read方法可以把文件中的字符逐个读取出来，存入char数组中相应的位置
			// read方法如果返回的是-1，则表示文件已经读取到结束
			// 如果read方法返回的是正值，则表示当前读取字符的Unicode编码
			while ((temp = r.read()) != -1) {
				// 把读取出来的字符编码强制转换为char类型，放到字符数组的相应位置
				charArr[count] = (char) temp;
				// 计数器累加
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 倒读文件
		for (int i = 0, j = charArr.length - 1; i <= j; i++, j--) {
			char t = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = t;
		}

		// 把已经从文件中读出的字符数组实例化成为一个字符串
		String s = new String(charArr);
		System.out.println(s);
	}

}
