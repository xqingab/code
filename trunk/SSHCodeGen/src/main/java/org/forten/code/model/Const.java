package org.forten.code.model;

import org.forten.code.util.PackageUtil;

public class Const {
	public static ContextConfig context;

	public static String getProjectPath() {
		return context.getWorkspace() + "/" + context.getProjectName() + "/";
	}

	public static String getSrcPath() {
		return getProjectPath() + "src/main/java/";
	}

	public static String getResourcesPath() {
		return getProjectPath() + "src/main/resources/";
	}

	public static String getBasePackagePath() {
		return getSrcPath()
				+ PackageUtil
						.covertePackageToPath(context.getBasePackageName())
				+ "/";
	}
}
