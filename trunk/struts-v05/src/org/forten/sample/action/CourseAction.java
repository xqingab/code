package org.forten.sample.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.forten.sample.model.Course;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Course course;
	private String message;

	private String name;
	private List<Course> dataList;

	@Action(value = "gotoSave", results = { @Result(name = "input", location = "/save.jsp") })
	public String gotoSave() {
		return INPUT;
	}

	@Action(value = "save", results = { @Result(name = "success", location = "gotoSave", type = "chain") })
	public String save() {
		System.out.println(course);
		message = "保存成功";
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = "success", location = "/list.jsp") })
	public String list() {
		dataList = new ArrayList<>();
		Course c1 = new Course(1, "Java", "2016-01-01", "张辽", 10);
		Course c2 = new Course(2, "Javascript", "2016-01-01", "张辽", 5);
		Course c3 = new Course(3, "python", "2016-01-01", "张辽", 3);
		Course c4 = new Course(4, "ruby", "2016-01-01", "张辽", 6);
		Course c5 = new Course(5, "c++", "2016-01-01", "张辽", 1);

		Map<String, Course> db = new HashMap<>();
		db.put(c1.getName(), c1);
		db.put(c2.getName(), c2);
		db.put(c3.getName(), c3);
		db.put(c4.getName(), c4);
		db.put(c5.getName(), c5);

		System.out.println("查询名称中带" + name + "的课程");
		if (name == null || name.equals("")) {
			for (Course course : db.values()) {
				dataList.add(course);
			}
		} else {
			for (String n : db.keySet()) {
				if (n.contains(name)) {
					dataList.add(db.get(n));
				}
			}
		}
		return SUCCESS;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Course> getDataList() {
		return dataList;
	}

	public void setDataList(List<Course> dataList) {
		this.dataList = dataList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
