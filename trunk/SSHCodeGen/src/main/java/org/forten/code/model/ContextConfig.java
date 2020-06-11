package org.forten.code.model;

import java.io.Serializable;

public class ContextConfig implements Serializable {
	private static final long serialVersionUID = -9025773271117301241L;

	private String workspace;
	private String projectName;
	private String basePackageName;
	private String jdbcDriverClass;
	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;
	private String templatePath;

	public ContextConfig() {
		super();
	}

	public ContextConfig(String workspace, String projectName,
			String basePackageName, String jdbcDriverClass, String jdbcUrl,
			String jdbcUsername, String jdbcPassword, String templatePath) {
		super();
		this.workspace = workspace;
		this.projectName = projectName;
		this.basePackageName = basePackageName;
		this.jdbcDriverClass = jdbcDriverClass;
		this.jdbcUrl = jdbcUrl;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		this.templatePath = templatePath;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBasePackageName() {
		return basePackageName;
	}

	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}

	public String getJdbcDriverClass() {
		return jdbcDriverClass;
	}

	public void setJdbcDriverClass(String jdbcDriverClass) {
		this.jdbcDriverClass = jdbcDriverClass;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getJdbcUsername() {
		return jdbcUsername;
	}

	public void setJdbcUsername(String jdbcUsername) {
		this.jdbcUsername = jdbcUsername;
	}

	public String getJdbcPassword() {
		return jdbcPassword;
	}

	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	@Override
	public String toString() {
		return "ContextConfig [workspace=" + workspace + ", projectName="
				+ projectName + ", basePackageName=" + basePackageName
				+ ", jdbcDriverClass=" + jdbcDriverClass + ", jdbcUrl="
				+ jdbcUrl + ", jdbcUsername=" + jdbcUsername
				+ ", jdbcPassword=" + jdbcPassword + ", templatePath="
				+ templatePath + "]";
	}
}
