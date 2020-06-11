<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../styles/css/reset.css">
<link type="text/css" rel="stylesheet" href="../styles/css/index.css">
<title>课程维护</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="gotoCourseList.do">课程维护</a></td>
			<td><a href="gotoSelectionInfoList.do">选课情况统计</a></td>
		</tr>
	</table><br>
	<s:form name="saveForm" action="saveCourse.do">
		<table id="input_table">
			<tbody>
				<tr>
					<td>课程名</td>
					<td><s:textfield label="姓名" name="courseDtoForSave.name"></s:textfield></td>
					<td>时间</td>
					<td><s:textfield label="时间" name="courseDtoForSave.teachTime"></s:textfield></td>
					<td>教师</td>
					<td><s:textfield label="教师" name="courseDtoForSave.teacherName"></s:textfield></td>
					<td>学分</td>
					<td><s:textfield label="学分" name="courseDtoForSave.credit"></s:textfield></td>
					<td><s:submit value="添加"></s:submit></td>
				</tr>
			</tbody>
		</table>
	</s:form>
	<BR>
	<table class="rc_tab01" cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<th style="width: 10%; text-align: center;">课程名</th>
				<th style="width: 10%; text-align: center;">上课时间</th>
				<th style="width: 20%; text-align: center;">任课教师</th>
				<th style="width: 20%; text-align: center;">学分</th>
			</tr>
			<s:iterator value="courseDtoList" status="dto">
				<tr>
					<td><s:property value="courseDtoList[#dto.index].name" /></td>
					<td><s:property value="courseDtoList[#dto.index].teachTime" /></td>
					<td><s:property value="courseDtoList[#dto.index].teacherName" /></td>
					<td><s:property value="courseDtoList[#dto.index].credit" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>