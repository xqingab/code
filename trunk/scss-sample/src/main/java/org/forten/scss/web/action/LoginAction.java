/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.forten.scss.web.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.forten.scss.bo.LoginBo;
import org.forten.scss.dto.UserDtoForShow;
import org.forten.scss.web.BaseAction;
import org.springframework.context.annotation.Scope;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
@Namespace("/")
@Scope("prototype")
public class LoginAction extends BaseAction {
	@Resource
	private LoginBo loginBo;

	private String userName;
	private String password;
	private UserDtoForShow userDtoForShow;

	@Action(value = "gotoLogin", results = { @Result(name = "input", location = "/WEB-INF/pages/login.jsp") })
	public String gotoLogin() {
		return "input";
	}

	@Action(value = "login", results = {
			@Result(name = "input", location = "/WEB-INF/pages/login.jsp"),
			@Result(name = "toAdmin", location = "admin/gotoCourseList", type = "redirectAction"),
			@Result(name = "toStudent", location = "student/gotoSelectCourse", type = "redirectAction") })
	public String login() {
		// 认证查询动作，如果成功返回的是真实存在的用户数据，
		// 如果失败则返回一个UserDtoForShow中定义的空对象
		userDtoForShow = loginBo.authenticate(userName, password);
		if (userDtoForShow.equals(UserDtoForShow.NULL_USER_DTO_FOR_SHOW)) {
			return "input";
		} else {
			//保存认证成功的对象到Session中，以备后续功能使用我们的用户数据
			session.put("userInfo", userDtoForShow);
			if (userDtoForShow.getType().equalsIgnoreCase("S")) {
				return "toStudent";
			} else {
				return "toAdmin";
			}
		}
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userDtoForShow
	 */
	public UserDtoForShow getUserDtoForShow() {
		return userDtoForShow;
	}

	/**
	 * @param userDtoForShow
	 *            the userDtoForShow to set
	 */
	public void setUserDtoForShow(UserDtoForShow userDtoForShow) {
		this.userDtoForShow = userDtoForShow;
	}
}
