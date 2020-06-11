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

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.forten.scss.bo.CourseBo;
import org.forten.scss.dto.CourseDtoForShow;
import org.forten.scss.dto.UserDtoForShow;
import org.forten.scss.web.BaseAction;
import org.springframework.context.annotation.Scope;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
@Namespace("/student")
@Scope("prototype")
public class StudentAction extends BaseAction {
	@Resource
	private CourseBo courseBo;

	private List<CourseDtoForShow> courseDtoList;
	private int[] courseId;
	private String userName;

	@Action(value = "gotoSelectCourse", results = { @Result(name = "input", location = "/WEB-INF/pages/student/selectCourse.jsp") })
	public String gotoSelectCourse() {
		UserDtoForShow currentUser = (UserDtoForShow) session.get("userInfo");
		userName = currentUser.getName();
		courseDtoList = courseBo.queryNotSelectedCourse(currentUser.getId());
		return "input";
	}

	@Action(value = "selectCourse", results = { @Result(name = "success", location = "gotoSelectCourse", type = "redirectAction") })
	public String selectCourse() {
		UserDtoForShow currentUser = (UserDtoForShow) session.get("userInfo");
		courseBo.doSelectCourse(currentUser.getId(), courseId);
		return "success";
	}

	public List<CourseDtoForShow> getCourseDtoList() {
		return courseDtoList;
	}

	public void setCourseDtoList(List<CourseDtoForShow> courseDtoList) {
		this.courseDtoList = courseDtoList;
	}

	public int[] getCourseId() {
		return courseId;
	}

	public void setCourseId(int[] courseId) {
		this.courseId = courseId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
