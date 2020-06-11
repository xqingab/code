package org.forten.code.model;

import org.forten.code.util.NameUtil;

public class FieldMetaModel {
	private String columnName;
	private String fieldName;
	private String dataType;
	private String comment;

	/**
	 * 
	 */
	public FieldMetaModel() {
		super();
	}

	/**
	 * @param columnName
	 * @param fieldName
	 * @param dataType
	 * @param comment
	 */
	public FieldMetaModel(String columnName, String fieldName, String dataType,
			String comment) {
		super();
		this.columnName = columnName;
		this.fieldName = fieldName;
		this.dataType = dataType;
		this.comment = comment;
	}

	/**
	 * @return columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName
	 *            the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		if(comment==null||comment.trim().length()==0){
			return "";
		}
		return comment.trim();
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSetMethodName() {
		return NameUtil.buildSetterMethodName(this.columnName);
	}

	public String getGetMethodName() {
		return NameUtil.buildGetterMethodName(this.columnName);
	}
}
