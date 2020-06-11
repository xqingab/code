package org.forten.sample.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter {

	public static void main(String[] args) {
		Student s = new Student("Tom",22, "美国", "10398432");
		File file = new File("c:/student.obj");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
