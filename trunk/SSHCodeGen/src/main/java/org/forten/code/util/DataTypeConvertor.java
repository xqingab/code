package org.forten.code.util;

import org.forten.code.model.DataTypeDic;

public class DataTypeConvertor {
	public static String convertToJavaType(String dataType) {
		//return EnumUtil.getEnumByName(DataTypeDic.class, dataType).getJavaType();
		DataTypeDic[] arr = DataTypeDic.values();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].name().equalsIgnoreCase(dataType)) {
				return arr[i].getJavaType();
			}
		}
		return "UNKNOWN_TYPE";
	}
}
