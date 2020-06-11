package org.forten.sample.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	private FileUtil(){
		
	}
	
	public static void writeFile(File file, String str){
		try(OutputStream out = new FileOutputStream(file)){
			byte[] bytes = str.getBytes();
			out.write(bytes);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readFile(File file){
		byte[] byteArr = null;
		try(InputStream in = new FileInputStream(file)){
			byteArr = new byte[in.available()];
			in.read(byteArr);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return new String(byteArr);
	}
}
