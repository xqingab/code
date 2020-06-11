package org.forten.sample.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReader {

	public static void main(String[] args) {
		File file = new File("c:/student.obj");
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			Student s = (Student) in.readObject();
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
