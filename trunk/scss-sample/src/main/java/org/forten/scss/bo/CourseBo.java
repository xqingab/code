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
package org.forten.scss.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.forten.scss.dao.HibernateDao;
import org.forten.scss.dto.CourseDtoForSave;
import org.forten.scss.dto.CourseDtoForSelectionInfo;
import org.forten.scss.dto.CourseDtoForShow;
import org.forten.scss.entity.Course;
import org.forten.scss.entity.User;
import org.forten.utils.system.BeanPropertyUtil;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
@Service("courseBo")
public class CourseBo {
	@Resource
	private HibernateDao hibernateDao;

	public void doSave(CourseDtoForSave dto) {
		Course course = new Course();
		BeanPropertyUtil.copy(course, dto);
		hibernateDao.save(course);
	}

	public List<CourseDtoForShow> queryAll() {
		// String hql = "FROM Course ORDER BY id DESC";
		// 查询出所有的实体对象，以一个实体对象的List展现
		// List<Course> entityList = hibernateDao.findEntity(hql,
		// new HashMap<String, Object>(0));
		// 声明一个等待填充的，装Dto对象的List
		// List<CourseDtoForShow> dtoList = new ArrayList<CourseDtoForShow>(
		// entityList.size());
		// 遍历entityList，
		// 把entityList中的每一个实体对象的数据填充到一个Dto对象中，
		// 然后把这个Dto对象放到dtoList中等待返回
		// for (Course course : entityList) {
		// CourseDtoForShow dto = new CourseDtoForShow();
		// BeanPropertyUtil.copy(dto, course);
		// dtoList.add(dto);
		// }
		// return dtoList;

		String hql = "SELECT "
				+ "new org.forten.scss.dto.CourseDtoForShow(c.id,c.name,c.teachTime,c.teacherName,c.credit) "
				+ "FROM Course c ORDER BY c.id DESC";
		return hibernateDao.findEntity(hql, new HashMap<String, Object>(0));
	}

	public void doSelectCourse(int userId,int... courseId) {
		User user = hibernateDao.findById(User.class, userId);
		for (int id : courseId) {
			Course course = hibernateDao.findById(Course.class, id);
			user.addCourse(course);
		}
		hibernateDao.update(user);
	}

	public List<CourseDtoForSelectionInfo> querySelectionInfo() {
		String hql = "FROM Course c1 WHERE c1.userSet IS NOT EMPTY";
		List<Course> selectedCourse = hibernateDao.findEntity(hql,
				new HashMap<String, Object>(0));
		List<CourseDtoForSelectionInfo> dtoList = new ArrayList<CourseDtoForSelectionInfo>();
		for (Course course : selectedCourse) {
			CourseDtoForSelectionInfo dto = new CourseDtoForSelectionInfo();
			BeanPropertyUtil.copy(dto, course);
			dto.setStudentCount(course.getUserSet().size());
			StringBuilder names = new StringBuilder();
			for (User user : course.getUserSet()) {
				names.append(user.getName());
				names.append("，");
			}
			names = names.delete(names.length() - 1, names.length());
			dto.setStudentNames(names.toString());
			dtoList.add(dto);
		}
		return dtoList;
	}

	public List<CourseDtoForShow> queryNotSelectedCourse(int userId) {
		String hql = "SELECT "
				+ "new org.forten.scss.dto.CourseDtoForShow(c.id,c.name,c.teachTime,c.teacherName,c.credit) "
				+ "FROM Course c WHERE (SELECT u FROM User u WHERE u.id=:userId) not in elements(c.userSet) ORDER BY c.id DESC";
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("userId", userId);
		return hibernateDao.findEntity(hql, params);
	}
}
