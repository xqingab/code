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
import org.forten.scss.dto.CourseDtoForSave;
import org.forten.scss.dto.CourseDtoForSelectionInfo;
import org.forten.scss.dto.CourseDtoForShow;
import org.forten.scss.web.BaseAction;
import org.springframework.context.annotation.Scope;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
@Namespace("/admin")
@Scope("prototype")
public class AdminAction extends BaseAction {
	@Resource
	private CourseBo courseBo;

	private List<CourseDtoForShow> courseDtoList;
	private CourseDtoForSave courseDtoForSave;

	private List<CourseDtoForSelectionInfo> selectionInfoDtoList;

	@Action(value = "gotoSelectionInfoList", results = { @Result(name = "success", location = "/WEB-INF/pages/admin/courseSelectionInfoList.jsp") })
	public String gotoSelectionInfoList() {
		selectionInfoDtoList = courseBo.querySelectionInfo();
		return "success";
	}

	@Action(value = "gotoCourseList", results = { @Result(name = "input", location = "/WEB-INF/pages/admin/courseList.jsp") })
	public String gotoCourseList() {
		courseDtoForSave = new CourseDtoForSave();
		courseDtoList = courseBo.queryAll();
		return "input";
	}

	@Action(value = "saveCourse", results = { @Result(name = "success", location = "gotoCourseList", type = "redirectAction") })
	public String saveCourse() {
		courseBo.doSave(courseDtoForSave);
		return "success";
	}

	public List<CourseDtoForShow> getCourseDtoList() {
		return courseDtoList;
	}

	public void setCourseDtoList(List<CourseDtoForShow> courseDtoList) {
		this.courseDtoList = courseDtoList;
	}

	public CourseDtoForSave getCourseDtoForSave() {
		return courseDtoForSave;
	}

	public void setCourseDtoForSave(CourseDtoForSave courseDtoForSave) {
		this.courseDtoForSave = courseDtoForSave;
	}

	public List<CourseDtoForSelectionInfo> getSelectionInfoDtoList() {
		return selectionInfoDtoList;
	}

	public void setSelectionInfoDtoList(
			List<CourseDtoForSelectionInfo> selectionInfoDtoList) {
		this.selectionInfoDtoList = selectionInfoDtoList;
	}
}
