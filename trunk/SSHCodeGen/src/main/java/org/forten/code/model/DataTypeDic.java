package org.forten.code.model;

public enum DataTypeDic {
	TINYINT("Integer"), SMALLINT("Integer"), MEDIUMINT("Integer"), INT("Integer"), BIGINT(
			"Long"), FLOAT("Float"), DOUBLE("Double"), DECIMAL("Double"), NUMBER(
			"Long"), CHAR("String"), VARCHAR("String"), VARCHAR2("String"), TINYTEXT(
			"String"), TEXT("String"), MEDIUMTEXT("String"), LONGTEXT("String"), CLOB(
			"String"), TINYBLOB("byte[]"), BLOB("byte[]"), MEDIUMBLOB("byte[]"), LONGBLOB(
			"byte[]"), DATE("Date"), TIME("Date"), DATETIME("Date"), TIMESTAMP(
			"Date");

	private String javaType;

	private DataTypeDic(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaType() {
		return javaType;
	}
}
