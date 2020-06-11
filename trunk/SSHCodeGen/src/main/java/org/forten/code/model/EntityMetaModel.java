package org.forten.code.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EntityMetaModel {
	private String tableName;
	private String className;
	private String packageName;
	private String comment;
	private List<FieldMetaModel> fieldModelList = new ArrayList<FieldMetaModel>();

	/**
	 * 
	 */
	public EntityMetaModel() {
		super();
	}

	/**
	 * @param tableName
	 * @param className
	 * @param packageName
	 * @param comment
	 * @param fieldModelList
	 */
	public EntityMetaModel(String tableName, String className,
			String packageName, String comment,
			List<FieldMetaModel> fieldModelList) {
		super();
		this.tableName = tableName;
		this.className = className;
		this.packageName = packageName;
		this.comment = comment;
		this.fieldModelList = fieldModelList;
	}

	/**
	 * @return className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName
	 *            the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * @return tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment.trim();
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return fieldModelList
	 */
	public List<FieldMetaModel> getFieldModelList() {
		return fieldModelList;
	}

	/**
	 * @param fieldModelList
	 *            the fieldModelList to set
	 */
	public void setFieldModelList(List<FieldMetaModel> fieldModelList) {
		this.fieldModelList = fieldModelList;
	}

	public void addFieldModel(FieldMetaModel... fieldMetaModel) {
		Collections.addAll(this.fieldModelList, fieldMetaModel);
	}

	public void removeFieldModel(FieldMetaModel... fieldMetaModel) {
		fieldModelList.removeAll(Arrays.asList(fieldMetaModel));
	}

	public FieldMetaModel getFieldModel(String columnName) {
		for (FieldMetaModel model : fieldModelList) {
			if (model.getColumnName().equalsIgnoreCase(columnName)) {
				return model;
			}
		}
		throw new IllegalArgumentException();
	}
}
