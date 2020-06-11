package org.forten.code.util;

import java.io.File;

public class PackageUtil {
	public static String covertePackageToPath(String packageStr) {
		String str = packageStr.replaceAll("\\.", "/").replaceAll("\\\\", "/");
		return str;
	}

	public static void mdPackagePath(String path) {
		File file = new File(path.replaceAll("\\\\", "/"));
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
