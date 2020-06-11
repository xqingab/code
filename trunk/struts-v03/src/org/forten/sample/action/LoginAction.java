package org.forten.sample.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
public class LoginAction extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, SessionAware, ApplicationAware {
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> session;
	private Map<String, Object> application;

	private Map<String, String> userMap = new HashMap<>();

	private String message;

	public LoginAction() {
		userMap.put("user1", "1");
		userMap.put("user2", "1");
		userMap.put("user3", "1");
		userMap.put("user4", "1");
		userMap.put("user5", "1");
	}

	@Action(value = "gotoLogin", results = { @Result(name = "success", location = "/login.jsp") })
	public String gotoLogin() {
		return SUCCESS;
	}

	@Action(value = "login", results = { @Result(name = "success", location = "/index.jsp"),
			@Result(name = "input", location = "gotoLogin", type = "chain"),
			@Result(name = "error", location = "gotoLogin", type = "chain") })
	public String login() {
		String username = request.getParameter("name");
		String password = request.getParameter("password");

		if (!userMap.containsKey(username)) {
			message = "用户名不存在";
			return INPUT;
		}
		if (!userMap.get(username).equals(password)) {
			message = "登录失败";
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.application = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
