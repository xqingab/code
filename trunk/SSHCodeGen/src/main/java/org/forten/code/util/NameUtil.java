package org.forten.code.util;

public class NameUtil {
	private NameUtil() {

	}

	public static String buildClassName(String tableName, int beginIndex) {
		return buildHumpString(tableName, "_", beginIndex);
	}

	public static String buildClassName(String tableName) {
		return buildClassName(tableName, 0);
	}

	public static String buildFieldName(String fieldName) {
		return lowerFirstLetter(buildHumpString(fieldName, "_", 0));
	}

	public static String buildGetterMethodName(String fieldName) {
		return "get" + buildHumpString(fieldName, "_", 0);
	}

	public static String buildSetterMethodName(String fieldName) {
		return "set" + buildHumpString(fieldName, "_", 0);
	}

	/**
	 * 构建驼峰式字符串
	 * 
	 * @param origin
	 *            原始字符串
	 * @param splitChar
	 *            分隔符
	 * @param beginIndex
	 *            开始处理的字符串索引
	 * @return 驼峰字符串
	 */
	public static String buildHumpString(String origin, String splitChar,
			int beginIndex) {
		StringBuffer buff = new StringBuffer();
		String[] nameParts = origin.split(splitChar);
		for (int i = beginIndex; i < nameParts.length; i++) {
			String temp = nameParts[i].toLowerCase();
			buff.append(upperFirstLetter(temp));
		}
		return buff.toString();
	}

	// 单词首字母变为大写
	private static String upperFirstLetter(String word) {
		return word.replaceFirst(word.substring(0, 1), word.substring(0, 1)
				.toUpperCase());
	}

	// 单词首字母变为小写,其余字母大小写不变
	private static String lowerFirstLetter(String word) {
		return word.replaceFirst(word.substring(0, 1), word.substring(0, 1)
				.toLowerCase());
	}
}
