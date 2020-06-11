package org.forten.sample.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileCopyWithCommonsIO {

	public static void main(String[] args) {
		// 要复制的源文件目录及文件名
		File src = new File("c:/Windows/write.exe");
		// 得到到的目标目录及文件名
		File dist = new File("d:/写字板.exe");

		try {
			FileUtils.copyFile(src, dist);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
